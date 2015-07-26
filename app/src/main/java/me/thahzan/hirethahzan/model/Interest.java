package me.thahzan.hirethahzan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TaZ on 7/4/15.
 */
public class Interest implements Serializable {

    private String name;
    private List<String> keywords;

    public String getName() {
        return name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public boolean isValid() {
        return name != null;
    }
}
