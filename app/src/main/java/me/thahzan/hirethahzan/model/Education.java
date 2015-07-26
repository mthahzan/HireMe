package me.thahzan.hirethahzan.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 *
 * Used to hold education information.
 */
public class Education implements Serializable {

    private String institution;

    @SerializedName("area")
    private String studyArea;

    private String studyType;
    private String startDate;

    @Nullable
    private String endDate;

    @Nullable
    private String gpa;

    @Nullable
    private List<String> courses;

    public Education(String institution, String studyArea, String studyType, String startDate,
                     @Nullable String endDate, @Nullable String gpa, @Nullable List<String> courses) {
        this.institution = institution;
        this.studyArea = studyArea;
        this.studyType = studyType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.gpa = gpa;
        this.courses = courses;
    }

    public String getInstitution() {
        return institution;
    }

//    public void setInstitution(String institution) {
//        this.institution = institution;
//    }

    public String getStudyArea() {
        return studyArea;
    }

//    public void setStudyArea(String studyArea) {
//        this.studyArea = studyArea;
//    }

    public String getStudyType() {
        return studyType;
    }

//    public void setStudyType(String studyType) {
//        this.studyType = studyType;
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

    @Nullable
    public String getGpa() {
        return gpa;
    }

//    public void setGpa(@Nullable String gpa) {
//        this.gpa = gpa;
//    }

    @Nullable
    public List<String> getCourses() {
        return courses;
    }

    public boolean isValid() {
        return institution != null;
    }

//    public void setCourses(@Nullable List<String> courses) {
//        this.courses = courses;
//    }

//    public static Education parseEducation(JSONObject instance) throws JSONException {
//
//        Education education = new EducationBuilder()
//                .setInstitution(instance.getString("institution"))
//                .setStudyArea(instance.getString("area"))
//                .setStudyType(instance.getString("studyType"))
//                .setStartDate(instance.getString("startDate"))
//                .createEducation();
//
//        String gpa = instance.getString("gpa");
//        if(StringHandlerUtil.isValidString(gpa)) {
//            education.setGpa(gpa);
//        }
//
//        String endDate = instance.getString("endDate");
//        if(StringHandlerUtil.isValidString(endDate)) {
//            education.setEndDate(endDate);
//        }
//
//        JSONArray coursesArray = instance.getJSONArray("courses");
//        if(coursesArray.length() > 0) {
//            List<String> courses = null;
//            for(int coursesIndex = 0; coursesIndex < coursesArray.length(); coursesIndex++) {
//                String course = (String) coursesArray.get(coursesIndex);
//                if(StringHandlerUtil.isValidString(course)) {
//
//                    // Declare courses ArrayList if it is null (which means, first credible loop)
//                    if(courses == null) courses = new ArrayList<>();
//
//                    // Add course string
//                    courses.add(course);
//                }
//            }
//            education.setCourses(courses);
//        }
//
//        return education;
//    }
//
//    public JSONObject toJSON() {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("institution", institution);
//        map.put("area", studyArea);
//        map.put("studyType", studyType);
//        map.put("startDate", startDate);
//        map.put("endDate", endDate);
//        map.put("gpa", gpa);
//
//        JSONArray coursesArray = new JSONArray();
//        if(courses != null) {
//            for(String course : courses) {
//                coursesArray.put(course);
//            }
//        }
//
//        map.put("courses", coursesArray);
//
//        return new JSONObject(map);
//    }
//
//    public static class EducationBuilder {
//
//        private String institution;
//        private String studyArea;
//        private String studyType;
//        private String startDate;
//        private String endDate;
//        private String gpa;
//        private List<String> courses;
//
//        public EducationBuilder setInstitution(String institution) {
//            this.institution = institution;
//            return this;
//        }
//
//        public EducationBuilder setStudyArea(String studyArea) {
//            this.studyArea = studyArea;
//            return this;
//        }
//
//        public EducationBuilder setStudyType(String studyType) {
//            this.studyType = studyType;
//            return this;
//        }
//
//        public EducationBuilder setStartDate(String startDate) {
//            this.startDate = startDate;
//            return this;
//        }
//
//        public EducationBuilder setEndDate(String endDate) {
//            this.endDate = endDate;
//            return this;
//        }
//
//        public EducationBuilder setGpa(String gpa) {
//            this.gpa = gpa;
//            return this;
//        }
//
//        public EducationBuilder setCourses(List<String> courses) {
//            this.courses = courses;
//            return this;
//        }
//
//        public Education createEducation() {
//            return new Education(institution, studyArea, studyType, startDate, endDate, gpa, courses);
//        }
//    }

}
