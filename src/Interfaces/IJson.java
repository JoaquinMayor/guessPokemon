package Interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface IJson {

    public void fromJson(JSONObject jsonObject) throws JSONException;
    public JSONObject toJson()throws JSONException;
    public void fromJsonAPI(JSONObject jsonObject)throws JSONException;


}

