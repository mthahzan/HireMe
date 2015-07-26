package me.thahzan.hirethahzan.model;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 * <p/>
 * Used to hold professional experience details.
 */
public class WorkExperience implements Serializable {

    private String company;
    private String position;
    @Nullable
    private String website;
    private String startDate;
    @Nullable
    private String endDate;
    private String summary;
    @Nullable
    private List<String> highlights;

    public WorkExperience(String company, String position, @Nullable String website, String startDate,
                          @Nullable String endDate, String summary, @Nullable List<String> highlights) {
        this.company = company;
        this.position = position;
        this.website = website;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.highlights = highlights;
    }

    public String getCompany() {
        return company;
    }

//    public void setCompany(String company) {
//        this.company = company;
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
        return company != null && position != null;
    }

//    public void setHighlights(@Nullable List<String> highlights) {
//        this.highlights = highlights;
//    }

//    public static WorkExperience parseWorkExperiance(JSONObject instance) throws JSONException {
//
//        WorkExperience workExperience = new WorkExperienceBuilder()
//                .setCompany(instance.getString("company"))
//                .setPosition(instance.getString("position"))
//                .setStartDate(instance.getString("startDate"))
//                .setSummary(instance.getString("summary"))
//                .createWorkExperience();
//
//        String website = instance.getString("website");
//        if(StringHandlerUtil.isValidString(website)) {
//            workExperience.setWebsite(website);
//        }
//
//        String endDate = instance.getString("endDate");
//        if(StringHandlerUtil.isValidString(endDate)) {
//            workExperience.setEndDate(endDate);
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
//            workExperience.setHighlights(highlights);
//        }
//
//        return workExperience;
//    }
//
//    public JSONObject toJSON() {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("company", company);
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

//    public static class WorkExperienceBuilder {
//
//        private String company;
//        private String position;
//        private String website;
//        private String startDate;
//        private String endDate;
//        private String summary;
//        private List<String> highlights;
//
//        public WorkExperienceBuilder setCompany(String company) {
//            this.company = company;
//            return this;
//        }
//
//        public WorkExperienceBuilder setPosition(String position) {
//            this.position = position;
//            return this;
//        }
//
//        public WorkExperienceBuilder setWebsite(String website) {
//            this.website = website;
//            return this;
//        }
//
//        public WorkExperienceBuilder setStartDate(String startDate) {
//            this.startDate = startDate;
//            return this;
//        }
//
//        public WorkExperienceBuilder setEndDate(String endDate) {
//            this.endDate = endDate;
//            return this;
//        }
//
//        public WorkExperienceBuilder setSummary(String summary) {
//            this.summary = summary;
//            return this;
//        }
//
//        public WorkExperienceBuilder setHighlights(List<String> highlights) {
//            this.highlights = highlights;
//            return this;
//        }
//
//        public WorkExperience createWorkExperience() {
//            return new WorkExperience(company, position, website, startDate, endDate, summary, highlights);
//        }
//    }
}
