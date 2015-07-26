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

//    public static VolunteerWork parseVolunteerWork(JSONObject instance) throws JSONException {
//
//        VolunteerWork volunteerWork = new VolunteerWorkBuilder()
//                .setOrganization(instance.getString("organization"))
//                .setPosition(instance.getString("position"))
//                .setStartDate(instance.getString("startDate"))
//                .setSummary(instance.getString("summary"))
//                .createWorkExperience();
//
//        String website = instance.getString("website");
//        if(StringHandlerUtil.isValidString(website)) {
//            volunteerWork.setWebsite(website);
//        }
//
//        String endDate = instance.getString("endDate");
//        if(StringHandlerUtil.isValidString(endDate)) {
//            volunteerWork.setEndDate(endDate);
//        }
//
//        JSONArray highlightsArray = instance.getJSONArray("highlights");
//        if(highlightsArray.length() > 0) {
//            List<String> highlights = null;
//            for(int highlightsIndex = 0; highlightsIndex < highlightsArray.length(); highlightsIndex++) {
//                String highlight = (String) highlightsArray.get(highlightsIndex);
//                if(StringHandlerUtil.isValidString(highlight)) {
//
//                    // Declare highlights ArrayList if it is null (which means, first credible loop)
//                    if(highlights == null) highlights = new ArrayList<>();
//
//                    // Add highlight string
//                    highlights.add(highlight);
//                }
//            }
//            volunteerWork.setHighlights(highlights);
//        }
//
//        return volunteerWork;
//    }
//
//    public JSONObject toJSON() {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("organization", organization);
//        map.put("position", position);
//        map.put("website", website);
//        map.put("startDate", startDate);
//        map.put("endDate", endDate);
//        map.put("summary", summary);
//
//        JSONArray highlightsArray = new JSONArray();
//        if(highlights != null) {
//            for(String highlight : highlights) {
//                highlightsArray.put(highlight);
//            }
//        }
//
//        map.put("highlights", highlightsArray);
//
//        return new JSONObject(map);
//    }
//
//    public static class VolunteerWorkBuilder {
//
//        private String organization;
//        private String position;
//        private String website;
//        private String startDate;
//        private String endDate;
//        private String summary;
//        private List<String> highlights;
//
//        public VolunteerWorkBuilder setOrganization(String organization) {
//            this.organization = organization;
//            return this;
//        }
//
//        public VolunteerWorkBuilder setPosition(String position) {
//            this.position = position;
//            return this;
//        }
//
//        public VolunteerWorkBuilder setWebsite(String website) {
//            this.website = website;
//            return this;
//        }
//
//        public VolunteerWorkBuilder setStartDate(String startDate) {
//            this.startDate = startDate;
//            return this;
//        }
//
//        public VolunteerWorkBuilder setEndDate(String endDate) {
//            this.endDate = endDate;
//            return this;
//        }
//
//        public VolunteerWorkBuilder setSummary(String summary) {
//            this.summary = summary;
//            return this;
//        }
//
//        public VolunteerWorkBuilder setHighlights(List<String> highlights) {
//            this.highlights = highlights;
//            return this;
//        }
//
//        public VolunteerWork createWorkExperience() {
//            return new VolunteerWork(organization, position, website, startDate, endDate, summary, highlights);
//        }
//    }

}
