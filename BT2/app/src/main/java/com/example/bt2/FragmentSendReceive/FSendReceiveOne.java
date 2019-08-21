package com.example.bt2.FragmentSendReceive;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bt2.R;

public class FSendReceiveOne extends Fragment {
    TextView txtSendReceiveOne;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sendreceive1, container, false);
        txtSendReceiveOne = (TextView) view.findViewById(R.id.txtSendReceiveOne);
        Bundle bundle = getArguments();
        if (bundle != null) {
            txtSendReceiveOne.setText(bundle.getString("noidung"));
        }
        return view;
    }
}
