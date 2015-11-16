package me.thahzan.hirethahzan.model;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 *
 * The model class of a Resume.
 */
public class Resume implements Serializable {

    private BasicInfo basics;
    private List<WorkExperience> work;
    private List<VolunteerWork> volunteer;
    private List<Education> education;
    private List<Award> awards;
    private List<Publication> publications;
    private List<Skill> skills;
    private List<LanguageInfo> languages;
    private List<Interest> interests;
    private List<Reference> references;

    public static Resume getInstance(String json) {
        return new Gson().fromJson(json, Resume.class);
    }

    public BasicInfo getBasics() {
        return basics;
    }

    public List<WorkExperience> getWork() {
        return work;
    }

    public List<VolunteerWork> getVolunteer() {
        return volunteer;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<LanguageInfo> getLanguages() {
        return languages;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public List<String> getTitles() {

        List<String> titles = new ArrayList<>();

        titles.add("Personal Info");

        if(work != null) {
            for(WorkExperience workExperience : work) {
                if(workExperience.isValid()) {
                    titles.add("Professional Experience");
                    break;
                }
            }
        }

        if(education != null) {
            for(Education edu : education) {
                if(edu.isValid()) {
                    titles.add("Academic");
                    break;
                }
            }
        }

        if(volunteer != null) {
            for(VolunteerWork volunteerWork : volunteer) {
                if(volunteerWork.isValid()) {
                    titles.add("Volunteer Experience");
                    break;
                }
            }
        }

        if(awards != null) {
            for(Award award : awards) {
                if(award.isValid()) {
                    titles.add("Awards");
                    break;
                }
            }
        }

        if(publications != null) {
            for(Publication publication : publications) {
                if(publication.isValid()) {
                    titles.add("Publications");
                    break;
                }
            }
        }

        if(skills != null) {
            for(Skill skill : skills) {
                if(skill.isValid()) {
                    titles.add("Skills");
                    break;
                }
            }
        }

        if(languages != null) {
            for(LanguageInfo languageInfo : languages) {
                if(languageInfo.isValid()) {
                    titles.add("Languages");
                    break;
                }
            }
        }

        if(interests != null) {
            for(Interest interest : interests) {
                if(interest.isValid()) {
                    titles.add("Interests");
                    break;
                }
            }
        }

        if(references != null) {
            for(Reference reference : references) {
                if(reference.isValid()) {
                    titles.add("References");
                    break;
                }
            }
        }

        return titles;
    }

    public boolean isValid() {
        return basics != null;
    }

}
