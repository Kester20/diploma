package com.diploma.noormal.util;

import org.json.JSONObject;

import java.util.Map;


/**
 * @author Arsalan. Created on 26.04.2017.
 */
public class JsonMaker {

    public static String make(Map<String, Object> data) {
        JSONObject json = new JSONObject();
        for (String key : data.keySet()) {
            Object value = data.get(key);
            json.put(key, value);
        }
        return json.toString();
    }
}
