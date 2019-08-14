package com.example.bt.News;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bt.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReadRssActivity extends AppCompatActivity {
    ListView lvReadRss;
    ArrayList<String> arrayList, arrayLink;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_rss);
        lvReadRss = (ListView) findViewById(R.id.lvReadRss);
        arrayList = new ArrayList<>();
        arrayLink = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvReadRss.setAdapter(arrayAdapter);
        new ReadRss().execute("https://vnexpress.net/rss/so-hoa.rss");
        lvReadRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ReadRssActivity.this, ReadNewActivity.class);
                intent.putExtra("linkTinTuc", arrayLink.get(i));
                startActivity(intent);
            }
        });
    }

    private class ReadRss extends AsyncTask<String, Void, String> {
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
            XMLDOMPerser xmldomPerser = new XMLDOMPerser();
            Document document = xmldomPerser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            String tieude = "";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                tieude = xmldomPerser.getValue(element, "title");
                arrayList.add(tieude);
                arrayLink.add(xmldomPerser.getValue(element, "link"));
            }
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
