package com.lrz.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Created by gz000172 on 2018/5/20.
 */
public class JsonUtils {
    private static final ObjectMapper JSON = new ObjectMapper();
    static {
        JSON.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        JSON.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
    }
    public static String toJson(Object obj) {
        try {
            return JSON.writeValueAsString(obj);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
