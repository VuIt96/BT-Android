package com.example.bt2.fragmentdialoglist;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bt2.R;

public class FragmentList extends ListFragment {
    String[] arrayCity = {"Thanh Hoa", "Ha Noi", "Hue", "Ninh Binh"};
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayCity);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_list_frag, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), arrayCity[position ], Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
}
