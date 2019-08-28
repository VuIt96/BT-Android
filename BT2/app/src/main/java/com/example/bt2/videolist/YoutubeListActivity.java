package com.example.bt2.videolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bt2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class YoutubeListActivity extends AppCompatActivity {
    ListView lvVideoList;
    ArrayList<VideoYoutubeList> arrayList;
    VideoListAdapter adapter;
   public static String API_KEY = "AIzaSyCiP30n86jOPe7KqLlgvxxsWgQdJun4MNU";
    String ID_PLAYLIST = "PLEO3IH-XyIU_piu-9xS2RH-zPpHSg5n1C";
    String s = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + ID_PLAYLIST + "&key=" + API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_list);
        lvVideoList = (ListView) findViewById(R.id.lvVideoList);
        arrayList = new ArrayList<>();
        adapter = new VideoListAdapter(this, R.layout.row_video_youtube_list, arrayList);
        lvVideoList.setAdapter(adapter);
        GetJsonYoutubeList(s);
        lvVideoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(YoutubeListActivity.this, PlayVideoListActivity.class);
                intent.putExtra("idVideoList", arrayList.get(i).getVideoId());
                startActivity(intent);
            }
        });
    }

    private void GetJsonYoutubeList(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    String title = "";
                    String url = "";
                    String idVideo = "";
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        JSONObject objectSnippet = jsonObject.getJSONObject("snippet");
                        title = objectSnippet.getString("title");
                        JSONObject jsonThumbnails = objectSnippet.getJSONObject("thumbnails");
                        JSONObject jsonMedium = jsonThumbnails.getJSONObject("medium");
                        url = jsonMedium.getString("url");
                        JSONObject jsonResourceId = objectSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceId.getString("videoId");
                        arrayList.add(new VideoYoutubeList(title, url, idVideo));
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //  Toast.makeText(YoutubeListActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(YoutubeListActivity.this, "Loi", Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
