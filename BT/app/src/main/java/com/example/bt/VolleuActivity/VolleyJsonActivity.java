package com.example.bt.VolleuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bt.R;

import org.json.JSONException;
import org.json.JSONObject;

public class VolleyJsonActivity extends AppCompatActivity {
    TextView txtVolleyJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_json);
        txtVolleyJson = (TextView) findViewById(R.id.txtVolleyJson);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //txtVolleyJson.append(" " + response);
                try {
                    String mh = response.getString("monhoc");
                    txtVolleyJson.setText(" " + mh);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtVolleyJson.append("Error " + error);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
