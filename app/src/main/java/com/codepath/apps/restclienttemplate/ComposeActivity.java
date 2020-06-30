package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.apps.restclienttemplate.models.Tweet;
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
        getSupportActionBar().hide();

        client = TwitterApp.getRestClient(this);

        MAX_TWEET_LENGTH = this.getResources().getInteger(R.integer.max_tweet_length);

        etCompose = findViewById(R.id.etCompose);
        btnTweet = findViewById(R.id.btnTweet);

        etCompose.requestFocus();

        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        // Enable / disable tweet button depending on if EditText is empty
        etCompose.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnTweet.setEnabled(s.length() != 0 && s.length() <= MAX_TWEET_LENGTH);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}