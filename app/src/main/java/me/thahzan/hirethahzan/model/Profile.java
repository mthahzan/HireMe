package me.thahzan.hirethahzan.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import me.thahzan.hirethahzan.R;

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

    public String getUsername() {
        return username;
    }

    public String getProfileURL() {
        return profileURL;
    }

    /**
     * Returns an array of [int, String]
     * The int is the ID of the drawable.
     * The String is the prefix of the Profile name.
     * @return An Array where the 0th Index is an integer and 1st index is a String.
     */
    @Nullable
    public Object[] getAppropriateDetails() {

        Object[] returnArray = null;

        if(network.equalsIgnoreCase("blogger"))
            returnArray = new Object[]{R.drawable.blogger, ""};
        if(network.equalsIgnoreCase("deviant art") || network.equalsIgnoreCase("deviantart"))
            returnArray = new Object[]{R.drawable.deviantart, ""};
        if(network.equalsIgnoreCase("facebook"))
            returnArray = new Object[]{R.drawable.facebook, ""};
        if(network.equalsIgnoreCase("flickr"))
            returnArray = new Object[]{R.drawable.flickr, ""};
        if(network.equalsIgnoreCase("github"))
            returnArray = new Object[]{R.drawable.github, ""};
        if(network.equalsIgnoreCase("google"))
            returnArray = new Object[]{R.drawable.google, ""};
        if(network.equalsIgnoreCase("gplus") || network.equalsIgnoreCase("google plus")
                || network.equalsIgnoreCase("google +") || network.equalsIgnoreCase("google+"))
            returnArray = new Object[]{R.drawable.gplus, "+"};
        if(network.equalsIgnoreCase("linkedin"))
            returnArray = new Object[]{R.drawable.linkedin, ""};
        if(network.equalsIgnoreCase("meetup"))
            returnArray = new Object[]{R.drawable.meetup, ""};
        if(network.equalsIgnoreCase("photo bucket") || network.equalsIgnoreCase("photobucket"))
            returnArray = new Object[]{R.drawable.photobucket, ""};
        if(network.equalsIgnoreCase("picasa"))
            returnArray = new Object[]{R.drawable.picasa, ""};
        if(network.equalsIgnoreCase("quora"))
            returnArray = new Object[]{R.drawable.quora, ""};
        if(network.equalsIgnoreCase("reddit"))
            returnArray = new Object[]{R.drawable.reddit, ""};
        if(network.equalsIgnoreCase("skype"))
            returnArray = new Object[]{R.drawable.skype, ""};
        if(network.equalsIgnoreCase("spotify"))
            returnArray = new Object[]{R.drawable.spotify, ""};
        if(network.equalsIgnoreCase("tumblr"))
            returnArray = new Object[]{R.drawable.tumblr, ""};
        if(network.equalsIgnoreCase("twitter"))
            returnArray = new Object[]{R.drawable.twitter, "@"};
        if(network.equalsIgnoreCase("vimeo"))
            returnArray = new Object[]{R.drawable.vimeo, ""};
        if(network.equalsIgnoreCase("youtube"))
            returnArray = new Object[]{R.drawable.youtube, ""};

        return returnArray;
    }

}
