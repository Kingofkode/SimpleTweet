package com.codepath.apps.restclienttemplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.TwitterApp;
import com.codepath.apps.restclienttemplate.TwitterClient;
import com.codepath.apps.restclienttemplate.twittermodels.Tweet;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class ComposeActivity extends AppCompatActivity {

    private static final String TAG = "ComposeActivity";

    public static int MAX_TWEET_LENGTH;

    EditText etCompose;
    Button btnTweet;

    TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        client = TwitterApp.getRestClient(this);

        MAX_TWEET_LENGTH = this.getResources().getInteger(R.integer.max_tweet_length);

        etCompose = findViewById(R.id.etCompose);
        btnTweet = findViewById(R.id.btnTweet);

        etCompose.requestFocus();

        setupTextChangeListener();

    }

    // Enable / disable tweet button depending on if tweet is valid
    private void setupTextChangeListener() {
        etCompose.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnTweet.setEnabled(tweetIsValid(s));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private Boolean tweetIsValid(CharSequence tweetBody) {
        return tweetBody.length() != 0 && tweetBody.length() <= MAX_TWEET_LENGTH;
    }

    // User tapped the "Tweet" button
    public void onTweetClick(View view) {
        final String tweetContent = etCompose.getText().toString();
        client.publishTweet(tweetContent, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.i(TAG, "onSuccess: to publish tweet");
                try {
                    Tweet publishedTweet = Tweet.fromJson(json.jsonObject);
                    Log.i(TAG, "Published tweet says: " + publishedTweet);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("tweet", Parcels.wrap(publishedTweet));

                    // Set result code and bundle data for response
                    setResult(RESULT_OK, resultIntent);

                    // Close the activity
                    finish();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "onFailure: to publish tweet", throwable);
            }
        });
    }

    // User tapped the cancel button
    public void onCancelClick(View view) {
        finish();
    }
}