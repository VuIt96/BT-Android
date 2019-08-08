package com.example.bt.CustomListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bt.R;

import java.util.ArrayList;

public class custum extends AppCompatActivity {
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<User> userArrayList;
    int preSelected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custum);
        listView = (ListView) findViewById(R.id.lv_custom);
        userArrayList = new ArrayList<>();
        userArrayList.add(new User("Nguyen Van A", false));
        userArrayList.add(new User("Nguyen Van B", false));
        userArrayList.add(new User("Nguyen Van c", false));
        userArrayList.add(new User("Nguyen Van D", false));
        userArrayList.add(new User("Nguyen Van E", false));
        userArrayList.add(new User("Nguyen Van F", false));
        userArrayList.add(new User("Nguyen Van G", false));
        userArrayList.add(new User("Nguyen Van H", false));
        userArrayList.add(new User("Nguyen Van I", false));

        customAdapter = new CustomAdapter(custum.this, userArrayList);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = userArrayList.get(i);
                user.setIschecked(true);
                userArrayList.set(i, user);
                if (preSelected > -1) {
                    User user1 = userArrayList.get(preSelected);
                    user1.setIschecked(false);
                    userArrayList.set(preSelected, user1);
                }
                preSelected = i;

                Toast.makeText(custum.this, userArrayList.get(i).getUsername() + " " + userArrayList.get(i).isIschecked(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
