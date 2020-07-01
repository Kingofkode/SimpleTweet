package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Entities {

    public List<Media> mediaList;

    // Empty constructor required by Parceler
    public Entities() {}

    public static Entities fromJson(JSONObject jsonObject) throws JSONException {
        Entities entities = new Entities();

        // Media such as photos and videos
        if (!jsonObject.isNull("media")) {
            JSONArray mediaJsonArray = jsonObject.getJSONArray("media");
            entities.mediaList = Media.fromJsonArray(mediaJsonArray);
        }

        return entities;
    }


}
