package me.thahzan.hirethahzan.model;

import java.io.Serializable;

/**
 * Created by TaZ on 7/4/15.
 */
public class Reference implements Serializable {

    private String name;
    private String reference;

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public boolean isValid() {
        return name != null && reference != null;
    }

}
