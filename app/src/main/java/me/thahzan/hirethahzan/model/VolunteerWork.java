package me.thahzan.hirethahzan.model;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 * <p/>
 * Used to hold Volunteer Work details.
 */
public class VolunteerWork implements Serializable {

    private String organization;
    private String position;
    @Nullable
    private String website;
    private String startDate;
    @Nullable
    private String endDate;
    private String summary;
    @Nullable
    private List<String> highlights;

    public VolunteerWork(String organization, String position, @Nullable String website, String startDate,
                         @Nullable String endDate, String summary, @Nullable List<String> highlights) {
        this.organization = organization;
        this.position = position;
        this.website = website;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.highlights = highlights;
    }

    public String getOrganization() {
        return organization;
    }

//    public void setOrganization(String organization) {
//        this.organization = organization;
//    }

    public String getPosition() {
        return position;
    }

//    public void setPosition(String position) {
//        this.position = position;
//    }

    @Nullable
    public String getWebsite() {
        return website;
    }

//    public void setWebsite(@Nullable String website) {
//        this.website = website;
//    }

    public String getStartDate() {
        return startDate;
    }

//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }

    @Nullable
    public String getEndDate() {
        return endDate;
    }

//    public void setEndDate(@Nullable String endDate) {
//        this.endDate = endDate;
//    }

    public String getSummary() {
        return summary;
    }

//    public void setSummary(String summary) {
//        this.summary = summary;
//    }

    @Nullable
    public List<String> getHighlights() {
        return highlights;
    }

    public boolean isValid() {
        return organization != null && position != null;
    }

//    public void setHighlights(@Nullable List<String> highlights) {
//        this.highlights = highlights;
//    }

}
