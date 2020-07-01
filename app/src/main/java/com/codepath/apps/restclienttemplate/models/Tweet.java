package com.codepath.apps.restclienttemplate.models;

import android.text.format.DateUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Parcel
public class Tweet {

    public String body;
    public String createdAt;
    public long id;
    public User user;
    public Entities entities;

    // Empty constructor required by Parceler
    public Tweet() {}

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.id = jsonObject.getLong("id");
        tweet.body = jsonObject.getString("full_text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.entities = Entities.fromJson(jsonObject.getJSONObject("entities"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

    public String getRelativeTimeAgo() {
        String rawJsonDate = createdAt;
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Customizations:
        // Plural word must come before singular

        relativeDate = relativeDate.replace("ago", "");

        relativeDate = relativeDate.replace("In", "");

        // seconds -> s
        relativeDate = relativeDate.replace(" seconds", "s");
        relativeDate = relativeDate.replace(" second", "s");

        // minutes -> m
        relativeDate = relativeDate.replace(" minutes", "m");
        relativeDate = relativeDate.replace(" minute", "m");

        // hours -> h
        relativeDate = relativeDate.replace(" hours", "h");
        relativeDate = relativeDate.replace(" hour", "h");


        return relativeDate;
    }

}
