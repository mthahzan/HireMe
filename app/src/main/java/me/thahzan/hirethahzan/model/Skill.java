package me.thahzan.hirethahzan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 *
 * Used to hold skill information.
 */
public class Skill implements Serializable {

    private String name;
    private String level;
    private List<String> keywords;

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public boolean isValid() {
        return name != null;
    }

}
