package com.example.bt2.fragmentstudient;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bt2.R;

import java.util.ArrayList;

public class FragmentStudientList extends ListFragment {
    ArrayList<StudientFrag> arrayList;
    StudientAdapter adapter;
    TransferStudents students;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        students = (TransferStudents) getActivity();
        arrayList = new ArrayList<>();
        addArrayStudient();
        adapter = new StudientAdapter(getActivity(), R.layout.frag_row_studient, arrayList);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_studient_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        students.DataStudien(arrayList.get(position));
    }

    private void addArrayStudient() {

        arrayList.add(new StudientFrag("Do viewt vu", 1990, "Thanh hoa", "123@gmail.com"));
        arrayList.add(new StudientFrag("Do viewt vu", 1990, "Thanh hoa", "123@gmail.com"));
        arrayList.add(new StudientFrag("Do viewt vu", 1990, "Thanh hoa", "123@gmail.com"));
        arrayList.add(new StudientFrag("Do viewt vu", 1990, "Thanh hoa", "123@gmail.com"));
        arrayList.add(new StudientFrag("Do viewt vu", 1990, "Thanh hoa", "123@gmail.com"));
        arrayList.add(new StudientFrag("Do viewt vu", 1990, "Thanh hoa", "123@gmail.com"));
    }
}
