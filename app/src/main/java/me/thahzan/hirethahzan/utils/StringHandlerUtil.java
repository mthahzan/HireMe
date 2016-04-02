package me.thahzan.hirethahzan.utils;

/**
 * Created by TaZ on 7/4/15.
 */
public class StringHandlerUtil {

    public static boolean isValidString(String instance) {
        return instance != null && instance.length() > 0
                && (!instance.equalsIgnoreCase("null") || !instance.equalsIgnoreCase("n/a"));

    }

}
