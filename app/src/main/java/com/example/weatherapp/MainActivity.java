package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnGetCityId;
    Button btnGetWeatherByCityId;
    Button btnGetWeatherByCityName;

    EditText editTextDataInput;
    ListView listViewWeatherReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetCityId = findViewById(R.id.buttonGetCityId);
        btnGetWeatherByCityId = findViewById(R.id.buttonGetWeatherByCityId);
        btnGetWeatherByCityName = findViewById(R.id.buttonGetWeatherByCityName);
        editTextDataInput = findViewById(R.id.editTextDataInput);
        listViewWeatherReport = findViewById(R.id.listViewWeatherReports);


        btnGetCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://weatherstack.com/ws_api.php?ip=46.229.246.201";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String country = "nista";
                        try {
                            JSONObject myObject = response.getJSONObject("location");
                            country = myObject.getString("country");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this, country, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();

                    }
                });
                queue.add(request);
            }
        });

        btnGetWeatherByCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked btnGetWeatherByCityId", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked " + editTextDataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}