package com.example.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String BASE_URL = "https://weatherstack.com/ws_api.php?ip=46.229.246.201";

    private Context context;
    private String stringValue;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String response);
    }


    public void getCityId(String propertyName, VolleyResponseListener listener) {

        String url = BASE_URL;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                stringValue = "";
                try {
                    JSONObject myObject = response.getJSONObject(propertyName);
                    stringValue = myObject.getString("country");
                    listener.onResponse(stringValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError("Something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public void getCityForecastByID(String propertyName, VolleyResponseListener listener) {
        String url = BASE_URL;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                WeatherReportModel model = new WeatherReportModel();
                try {
                    JSONObject myObject = response.getJSONObject(propertyName);
                    model.setTemperature(Integer.parseInt(myObject.getString("temperature")));
                    model.setWind_speed(Integer.parseInt(myObject.getString("wind_speed")));
                    model.setWind_dir(myObject.getString("wind_dir"));
                    model.setPressure(Integer.parseInt(myObject.getString("pressure")));
                    model.setPrecip(Integer.parseInt(myObject.getString("precip")));
                    model.setHumidity(Integer.parseInt(myObject.getString("humidity")));
                    listener.onResponse(model.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError("Something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);


    }
}
