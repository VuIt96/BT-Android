package com.example.bt.JSON;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bt.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonObjectActivity extends AppCompatActivity {
    ListView lvKhoahoc;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object);
        lvKhoahoc = (ListView) findViewById(R.id.lv_khoahoc);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvKhoahoc.setAdapter(adapter);
        new JsonObjectRead().execute("https://backend-students-vudo.herokuapp.com/student");


    }

    private class JsonObjectRead extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);

                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            try {
//                JSONObject jsonObject = new JSONObject(s);
//                JSONArray jsonArray = jsonObject.getJSONArray("danhsach");
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject objectkh = jsonArray.getJSONObject(i);
//                    String ten = objectkh.getString("khoahoc");
//                    Toast.makeText(JsonObjectActivity.this, ten, Toast.LENGTH_SHORT).show();
//                }
//                // Toast.makeText(JsonObjectActivity.this, " " +jsonArray.length()  , Toast.LENGTH_SHORT).show();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            try {
                JSONArray jsonArray = new JSONArray(s);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String khoahoc = jsonObject.getString("test_score");
                    String que = jsonObject.getString("address");
                    String nganh = jsonObject.getString("faculty");
                    String KQ = jsonObject.getString("result");
                    //String hocphi = jsonObject.getString("hocphi");
                    Toast.makeText(JsonObjectActivity.this, khoahoc, Toast.LENGTH_LONG).show();
                    arrayList.add(khoahoc + "_" + que + "_" + nganh + "_" + KQ);
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
