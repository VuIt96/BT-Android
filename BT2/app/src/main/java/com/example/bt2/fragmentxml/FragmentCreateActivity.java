package com.example.bt2.fragmentxml;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.bt2.R;

public class FragmentCreateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_create);
    }

    public void AddFrag(View view) {
        Fragment fragment = null;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btFragA:
                fragment = new FragmentOne();
                break;
            case R.id.btFragAddB:
                fragment = new FragmentTwo();
                break;
        }
        //fragmentTransaction.add(R.id.Framelayout, fragment);
        fragmentTransaction.replace(R.id.Framelayout, fragment);
        fragmentTransaction.commit();
    }
}
