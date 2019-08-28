package com.example.bt2.fragmentstudient;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bt2.R;

public class FragmentStudientInfo extends Fragment {
    TextView txtNameInfo, txtYearofBirtInfo, txtAddressInfo, txtEmailInfo;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_studient_info, container, false);
        initEvent();
        return view;
    }

    public void setInfoStudient(StudientFrag sv) {
        txtNameInfo.setText(sv.getName());
        txtYearofBirtInfo.setText("nam sinh " + sv.getYearofbirt());
        txtAddressInfo.setText("dia chi " + sv.getAddress());
        txtEmailInfo.setText("email " + sv.getEmail());
    }

    private void initEvent() {
        txtNameInfo = (TextView) view.findViewById(R.id.txtNameInfo);
        txtYearofBirtInfo = (TextView) view.findViewById(R.id.txtYearofBirtInfo);
        txtAddressInfo = (TextView) view.findViewById(R.id.txtAddressInfo);
        txtEmailInfo = (TextView) view.findViewById(R.id.txtEmailInfo);
    }
}
