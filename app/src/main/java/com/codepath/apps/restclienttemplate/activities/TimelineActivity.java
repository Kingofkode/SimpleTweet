package com.codepath.apps.restclienttemplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.codepath.apps.restclienttemplate.EndlessRecyclerViewScrollListener;
import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.TweetsAdapter;
import com.codepath.apps.restclienttemplate.TwitterApp;
import com.codepath.apps.restclienttemplate.TwitterClient;
import com.codepath.apps.restclienttemplate.twittermodels.Tweet;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class TimelineActivity extends AppCompatActivity {

    private static final String TAG = "TimelineActivity";

    public static final int COMPOSE_REQUEST_CODE = 20;

    // Instance variables
    TwitterClient client;
    RecyclerView rvTweets;
    List<Tweet> tweets;
    TweetsAdapter adapter;
    SwipeRefreshLayout swipeContainer;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        client = TwitterApp.getRestClient(this);

        swipeContainer = findViewById(R.id.swipeContainer);

        // Find the recycler view
        rvTweets = findViewById(R.id.rvTweets);

        layoutManager = new LinearLayoutManager(this);

        // Initialize the list of tweets and adapter
        tweets = new ArrayList<>();
        adapter = new TweetsAdapter(this, tweets);

        // Recycler view set up: layout manager and the adapter
        rvTweets.setLayoutManager(layoutManager);
        rvTweets.setAdapter(adapter);

        addTweetDividers();

        setupToolBarClickListener();

        populateHomeTimeline();

        setupPullToRefresh();

        setupPagination();
    }

    // Add divider lines between tweets
    private void addTweetDividers() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvTweets.getContext(),
                layoutManager.getOrientation());
        rvTweets.addItemDecoration(dividerItemDecoration);
    }

    // Tap toolbar to scroll back to the top
    private void setupToolBarClickListener() {
        Toolbar toolbar = findViewById(R.id.twitter_toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvTweets.smoothScrollToPosition(0);
            }
        });
    }

    // Called when returning from ComposeTweetActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == COMPOSE_REQUEST_CODE && resultCode == RESULT_OK) {

            // Early out if data is null
            if (data == null) {
                return;
            }

            // Get data from the intent
            Tweet publishedTweet = Parcels.unwrap(data.getParcelableExtra("tweet"));

            // Modify data source of tweets
            tweets.add(0, publishedTweet);

            // Update the adapter
            adapter.notifyItemInserted(0);

            // Scroll to new tweet
            rvTweets.smoothScrollToPosition(0);

        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    // User taps compose floating button
    public void onComposeClick(View view) {
        Intent composeIntent = new Intent(this, ComposeActivity.class);
        startActivityForResult(composeIntent, COMPOSE_REQUEST_CODE);
    }

    private void setupPullToRefresh() {
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(R.color.colorTwitterBlue);

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.i(TAG, "Fetching new data...");
                populateHomeTimeline();
            }
        });
    }

    // Infinite scrolling
    private void setupPagination() {
        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadMoreTweets();
            }
        };
        rvTweets.addOnScrollListener(scrollListener);
    }

    // Request next batch of tweets from API
    private void loadMoreTweets() {
        Tweet lastTweet = tweets.get(tweets.size() - 1);
        // 1. Send an API request to retrieve appropriate paginated data
        client.getNextPageOfTweets(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.i(TAG, "onSuccess: for loading more tweets");

                // 2. Deserialize and construct new model objects from the API response
                JSONArray jsonArray = json.jsonArray;
                try {
                    List<Tweet> olderTweets = Tweet.fromJsonArray(jsonArray);

                    // 3. Append the new data objects to the existing set of items
                    // 4. Notify the adapter of the new items made
                    adapter.addAll(olderTweets);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "onFailure: for loading more tweets");
                showTwitterApiLimitToast();
            }
        }, lastTweet.id);
    }

    // Called when activity first starts and by pull to refresh
    private void populateHomeTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess!");
                JSONArray jsonArray = json.jsonArray;
                try {
                    adapter.clear();
                    adapter.addAll(Tweet.fromJsonArray(jsonArray));

                    // Dismiss refreshing indicator
                    swipeContainer.setRefreshing(false);

                } catch (JSONException e) {
                    Log.e(TAG, "JSON exception: ", e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "onFailure: " + response, throwable);
                showTwitterApiLimitToast();
                swipeContainer.setRefreshing(false);
            }
        });
    }

    private void showTwitterApiLimitToast() {
        Toast.makeText(TimelineActivity.this, "Twitter API Limit Reached. Please try again later.", Toast.LENGTH_LONG).show();
    }

}