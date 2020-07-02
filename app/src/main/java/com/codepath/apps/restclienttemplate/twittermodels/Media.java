package com.codepath.apps.restclienttemplate.twittermodels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Media {

    public String mediaUrl;

    // Empty constructor required by Parceler
    public Media() {}

    public static Media fromJson(JSONObject jsonObject) throws JSONException {
        Media media = new Media();
        media.mediaUrl = jsonObject.getString("media_url_https");
        return media;
    }

    public static List<Media> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Media> mediaList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            mediaList.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return mediaList;
    }

}
