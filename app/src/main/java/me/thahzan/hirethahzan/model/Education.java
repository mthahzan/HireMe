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

}
