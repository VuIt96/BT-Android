package com.example.bt.IntenteEx;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bt.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IntentExActivity extends AppCompatActivity {
    public static ArrayList<String> arrayList;
    ImageView imgBird1, imgBird2;
    int REQUEST_CODE_IMAGE = 123;
    String namePhotoRoot = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_ex);
        imgBird1 = (ImageView) findViewById(R.id.imgBird1);
        imgBird2 = (ImageView) findViewById(R.id.imgBird2);
        String[] arrayBird = getResources().getStringArray(R.array.list_name);
        arrayList = new ArrayList<>(Arrays.asList(arrayBird));
        // tron mang
        Collections.shuffle(arrayList);
        namePhotoRoot = arrayList.get(3);
        int idPhoto = getResources().getIdentifier(arrayList.get(3), "drawable", getPackageName());
        imgBird1.setImageResource(idPhoto);
        imgBird2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(IntentExActivity.this, ImageIntentActivity.class), REQUEST_CODE_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null) {
            String nameImagePhoto = data.getStringExtra("tenhinhchon");
            int idNamePhoto = getResources().getIdentifier(nameImagePhoto, "drawable", getPackageName());
            imgBird2.setImageResource(idNamePhoto);
            if (namePhotoRoot.equals(nameImagePhoto)) {
                Toast.makeText(this, "Thanh cong ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Sai", Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
