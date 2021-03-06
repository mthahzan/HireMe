package me.thahzan.hirethahzan.model;

import java.io.Serializable;

/**
 * Created by TaZ on 7/4/15.
 * <p/>
 * Used to hold award information.
 */
public class Award implements Serializable {

    private String title;
    private String date;
    private String awarder;
    private String summary;

    public Award(String title, String date, String awarder, String summary) {
        this.title = title;
        this.date = date;
        this.awarder = awarder;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getDate() {
        return date;
    }

//    public void setDate(String date) {
//        this.date = date;
//    }

    public String getAwarder() {
        return awarder;
    }

//    public void setAwarder(String awarder) {
//        this.awarder = awarder;
//    }

    public String getSummary() {
        return summary;
    }

    public boolean isValid() {
        return title != null && date != null;
    }

//    public void setSummary(String summary) {
//        this.summary = summary;
//    }

//    public static Award parseAward(JSONObject instance) throws JSONException {
//        return new Award(instance.getString("title"), instance.getString("date"),
//                instance.getString("awarder"), instance.getString("summary"));
//    }
//
//    public JSONObject toJSON() {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("title", title);
//        map.put("date", date);
//        map.put("awarder", awarder);
//        map.put("summary", summary);
//
//        return new JSONObject(map);
//    }

}
