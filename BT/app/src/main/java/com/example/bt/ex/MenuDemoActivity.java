package com.example.bt.ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bt.R;


public class MenuDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudemo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSetting:
                Toast.makeText(MenuDemoActivity.this, "Setting", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuShare:
                Toast.makeText(MenuDemoActivity.this, "Share", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(MenuDemoActivity.this, "Search", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(MenuDemoActivity.this, "Email", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuSdt:
                Toast.makeText(MenuDemoActivity.this, "So dien thoai", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}