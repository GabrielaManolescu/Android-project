package com.example.gestiunechirii;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonRealEstateParser implements SirChar{


    public static List<JsonRealEstate> parseJson(String json) {
//        if(json == null) {
//            return null;
//        }
//        try {
//            JSONObject object = new JSONObject(json);
//            return getRealEstateListJson(object.getJSONArray("real estate"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
        try {
            JSONArray array = new JSONArray(json);
            return getRealEstateListJson(array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    private static List<JsonRealEstate> getRealEstateListJson(JSONArray jsonArray) throws JSONException {
        if(jsonArray == null) {
            return null;
        }
        List<JsonRealEstate> list = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++) {
            JsonRealEstate jsonRealEstate = getRealEstateJson(jsonArray.getJSONObject(i));
            if(jsonRealEstate != null) {
                list.add(jsonRealEstate);
            }
        }
        return list;
    }

    private static JsonRealEstate getRealEstateJson(JSONObject object) throws JSONException {
        String img = object.getString(REAL_ESTATE_IMG);
        String name = object.getString(REAL_ESTATE_NAME);
        String pret = object.getString(REAL_ESTATE_PRICE);


        return new JsonRealEstate(img, name, pret);

    }
}
