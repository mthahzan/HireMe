package me.thahzan.hirethahzan.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by TaZ on 7/4/15.
 * <p/>
 * Used to hold Profile (Facebook, Twitter, Linkedin, etc.) information
 */
public class Profile implements Serializable {

    private String network;
    private String username;
    @SerializedName("url")
    private String profileURL;

    public Profile(String network, String username, String profileURL) {
        this.network = network;
        this.username = username;
        this.profileURL = profileURL;
    }

    public String getNetwork() {
        return network;
    }

//    public void setNetwork(String network) {
//        this.network = network;
//    }

    public String getUsername() {
        return username;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getProfileURL() {
        return profileURL;
    }

//    public void setProfileURL(String profileURL) {
//        this.profileURL = profileURL;
//    }

//    public static Profile parseProfile(JSONObject instance) throws JSONException {
//        return new Profile(instance.getString("network"), instance.getString("username"),
//                instance.getString("url"));
//    }
//
//    public JSONObject toJSON() {
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("network", network);
//        map.put("username", username);
//        map.put("url", profileURL);
//
//        return new JSONObject(map);
//    }

}
