package com.example.bt2.fragmentonclick;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bt2.R;

public class FragmentOnCLickOne extends Fragment {
    TextView txtOnclickOne;
    EditText etFragkOne;
    Button btCLickOne;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_onclick1, container, false);
        txtOnclickOne = (TextView) view.findViewById(R.id.txtOnclickOne);
        etFragkOne = (EditText) view.findViewById(R.id.etFragOne);
        btCLickOne = (Button) view.findViewById(R.id.btClickOne);
        btCLickOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtViewOne = (TextView) getActivity().findViewById(R.id.txtHello);
                txtViewOne.setText(etFragkOne.getText().toString());
            }
        });
        return view;
    }

    public void setContent(String content) {
        txtOnclickOne.setText(content);

    }
}
