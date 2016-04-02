package me.thahzan.hirethahzan.model;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by TaZ on 7/4/15.
 * <p/>
 * Used to hold publication information.
 */
public class Publication implements Serializable {

    private String name;
    private String publisher;
    private String releaseDate;
    @Nullable
    private String website;
    private String summary;

    public Publication(String name, String publisher, String releaseDate, String summary) {
        this.name = name;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getPublisher() {
        return publisher;
    }

//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }

    public String getReleaseDate() {
        return releaseDate;
    }

//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }

    @Nullable
    public String getWebsite() {
        return website;
    }

//    public void setWebsite(@Nullable String website) {
//        this.website = website;
//    }

    public String getSummary() {
        return summary;
    }

    public boolean isValid() {
        return name != null;
    }

//    public void setSummary(String summary) {
//        this.summary = summary;
//    }

}
