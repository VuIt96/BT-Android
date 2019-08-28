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

public class FragmentOnClickTwo extends Fragment {
    TextView txtOnclickTwo;
    EditText etFragkTwo;
    Button btCLickTwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onclik2, container, false);
        txtOnclickTwo = (TextView) view.findViewById(R.id.txtOnclickTwo);
        etFragkTwo = (EditText) view.findViewById(R.id.etFragTwo);
        btCLickTwo = (Button) view.findViewById(R.id.btClickTwo);
        btCLickTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtViewTwo = (TextView) getActivity().findViewById(R.id.txtOnclickOne);
                txtViewTwo.setText(etFragkTwo.getText().toString());
            }
        });
        return view;
    }
}
