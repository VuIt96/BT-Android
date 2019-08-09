package com.example.bt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {
    Button btPopupMenu;
    Button btConTextMenu;
    ConstraintLayout Manhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        btPopupMenu = (Button) findViewById(R.id.bt_popMenu);
        btConTextMenu = (Button) findViewById(R.id.btContextMenu);
        Manhinh = (ConstraintLayout) findViewById(R.id.manhinh);
        btPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMenu();
            }
        });
        registerForContextMenu(btConTextMenu);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menudemo, menu);
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.setHeaderTitle("Mau ");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSetting:
                Manhinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuShare:
                Manhinh.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuSearch:
                Manhinh.setBackgroundColor(Color.GREEN);
            case R.id.menuEmail:
                Manhinh.setBackgroundColor(Color.GRAY);
                break;
            case R.id.menuSdt:
                Manhinh.setBackgroundColor(Color.YELLOW);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void ShowMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btPopupMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popmenu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuThem:
                        Toast.makeText(PopupMenuActivity.this, "Them", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menuXoa:
                        Toast.makeText(PopupMenuActivity.this, "Xoa", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menuSua:
                        Toast.makeText(PopupMenuActivity.this, "Sua", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
    }

}
