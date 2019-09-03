package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class AsynTaskVolleyActivity extends AppCompatActivity {
    ListView lvAsynTask;
    CourseAdapter courseAdapter;
    ArrayList<Course> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task_volley);
        lvAsynTask = (ListView) findViewById(R.id.lvAsynTask);
        arrayList = new ArrayList<>();
        courseAdapter = new CourseAdapter(AsynTaskVolleyActivity.this, arrayList);
        lvAsynTask.setAdapter(courseAdapter);
        getData();
    }

    private void getData() {
        ReadDataWithAsynTask();
    }

    private void ReadDataWithAsynTask() {
        new ReadDataAsynTask().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo5.json");
    }

    class ReadDataAsynTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            return readDataUrl(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.optString("khoahoc");
                    String price = jsonObject.optString("hocphi");
                    String img = jsonObject.optString("hinhanh");
                    arrayList.add(new Course(name, price, img));
                }
                courseAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String readDataUrl(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
