package com.example.bt2.FragmentSendReceive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bt2.R;

public class FragSendReceiveActivity extends AppCompatActivity {
    Button btSendReveice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_send_receive);
        btSendReveice = (Button) findViewById(R.id.btSend);
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        btSendReveice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FSendReceiveOne fSendReceiveOne = new FSendReceiveOne();

                Bundle bundle = new Bundle();
                bundle.putString("noidung", "1");
                // bundle.putInt("noidung",11);

                fSendReceiveOne.setArguments(bundle);

                fragmentTransaction.add(R.id.llView, fSendReceiveOne);
                fragmentTransaction.commit();

            }
        });
    }
}
