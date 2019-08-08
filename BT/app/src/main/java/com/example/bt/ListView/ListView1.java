package com.example.bt.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.bt.R;

import java.util.ArrayList;

public class ListView1 extends AppCompatActivity {
    ListView LV1;
    Button bt_Them;
    Button bt_Sua;
    Button bt_Xoa;
    ArrayList<String> arraymh;
    EditText et_name;
    int vtri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        callID();
        arraymh.add("Java");
        arraymh.add("C#");
        arraymh.add("Kotlin");
        arraymh.add("Java_Scrip");
        initEvent();

    }

    private void initEvent() {
        final ArrayAdapter arrayAdapter = new ArrayAdapter(ListView1.this, android.R.layout.simple_list_item_1, arraymh);
        LV1.setAdapter(arrayAdapter);
        LV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                et_name.setText(arraymh.get(i));
                vtri = i;
            }
        });
//        LV1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListView1.this, "Vu dep trai" + arraymh.get(i), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MH = et_name.getText().toString();
                arraymh.add(MH);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        bt_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arraymh.set(vtri,et_name.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
        bt_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arraymh.remove(vtri);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void callID() {
        LV1 = (ListView) findViewById(R.id.lv1);
        bt_Them = (Button) findViewById(R.id.bt1);
        bt_Sua = (Button) findViewById(R.id.bt2);
        bt_Xoa = (Button) findViewById(R.id.bt3);
        arraymh = new ArrayList<>();
        et_name = (EditText)findViewById(R.id.et1);
    }
}
