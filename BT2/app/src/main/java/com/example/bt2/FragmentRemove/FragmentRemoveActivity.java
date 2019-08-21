package com.example.bt2.FragmentRemove;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bt2.R;

public class FragmentRemoveActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_remove);
    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameRemove, new FragmentAddA(), "addA");
        fragmentTransaction.addToBackStack("aaa");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameRemove, new FragmentAddB(), "addB");
        fragmentTransaction.addToBackStack("bbb");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameRemove, new FragmentAddC(), "addC");
        fragmentTransaction.addToBackStack("ccc");
        fragmentTransaction.commit();
    }

    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAddA fragmentAddA = (FragmentAddA) getFragmentManager().findFragmentByTag("addA");
        if (fragmentAddA != null) {
            fragmentTransaction.remove(fragmentAddA);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "kiem tra lai", Toast.LENGTH_SHORT).show();
        }

    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAddB fragmentAddB = (FragmentAddB) getFragmentManager().findFragmentByTag("addB");
        if (fragmentAddB != null) {
            fragmentTransaction.remove(fragmentAddB);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "kiem tra lai", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAddC fragmentAddC = (FragmentAddC) getFragmentManager().findFragmentByTag("addC");
        if (fragmentAddC != null) {
            fragmentTransaction.remove(fragmentAddC);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "kiem tra lai", Toast.LENGTH_SHORT).show();
        }
    }

    public void Back(View view) {
        getFragmentManager().popBackStack();
    }

    public void Pop(View view) {
        getFragmentManager().popBackStack("aaa", 0);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {

            getFragmentManager().popBackStack();

        } else {

            super.onBackPressed();
        }
    }
}
