package com.telerikacademy.api.tests;

import org.json.JSONObject;

public class HelperMethods {
    public static boolean isValidJSON(String json) {

        try {
            new JSONObject(json);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
