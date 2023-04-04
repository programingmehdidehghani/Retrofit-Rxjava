package com.example.rxjavaretrofit.utils;

import com.example.rxjavaretrofit.model.BilimKadiniModel;
import com.google.gson.Gson;

public class ObjectUtil {

    public static String bilimKadiniToJsonString(BilimKadiniModel bilimKadiniModel)
    {
        Gson gson = new Gson();
        return gson.toJson(bilimKadiniModel);
    }
    public static BilimKadiniModel jsonStringToBilimKadini(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,BilimKadiniModel.class);
    }
}
