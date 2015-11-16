package me.thahzan.hirethahzan.model;

import java.io.Serializable;

/**
 * Created by TaZ on 7/4/15.
 */
public class LanguageInfo implements Serializable {

    private String language;
    private String fluency;

    public String getLanguage() {
        return language;
    }

    public String getFluency() {
        return fluency;
    }

    public boolean isValid() {
        return language != null;
    }
}
