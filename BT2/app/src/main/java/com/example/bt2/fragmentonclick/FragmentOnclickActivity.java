package com.example.bt2.fragmentonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bt2.R;

public class FragmentOnclickActivity extends AppCompatActivity {
    TextView txtHello;
    Button btClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_onclick);
        txtHello = (TextView) findViewById(R.id.txtHello);
        btClick = (Button) findViewById(R.id.btClick);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOnCLickOne fragmentOnCLickOne = (FragmentOnCLickOne) getFragmentManager().findFragmentById(R.id.fragOnclick1);
                fragmentOnCLickOne.setContent("noi dung");
            }
        });

    }

}
