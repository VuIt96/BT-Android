package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;

public class VolleyStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_string);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //method, url,listener(su kien nhan chuoi), enorr su kien
        String url = "http://online.khoapham.vn/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(VolleyStringActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyStringActivity.this, "Loi", Toast.LENGTH_SHORT).show();
                Log.d("AAA", "\n" + error.toString());
            }
        });
        requestQueue.add(stringRequest);
    }
}
