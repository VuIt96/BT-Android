package com.example.bt.IntenteEx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.bt.R;

import java.util.Collections;

public class ImageIntentActivity extends AppCompatActivity {
    TableLayout tableImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_intent);
        tableImg = (TableLayout) findViewById(R.id.tableImg);
        int numberline = 3;
        int numbercolum = 3;
        //tron
        Collections.shuffle(IntentExActivity.arrayList);
        for (int i = 1; i <= numberline; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 1; j <= numbercolum; j++) {
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(200, 200);
                imageView.setLayoutParams(layoutParams);
                final int vitri = numbercolum * (i - 1) + j - 1;
                int idPhoto = getResources().getIdentifier(IntentExActivity.arrayList.get(vitri), "drawable", getPackageName());
                imageView.setImageResource(idPhoto);
                //add img vao tablerow
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon", IntentExActivity.arrayList.get(vitri));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            //add tablerow vao Table
            tableImg.addView(tableRow);
        }
    }
}
