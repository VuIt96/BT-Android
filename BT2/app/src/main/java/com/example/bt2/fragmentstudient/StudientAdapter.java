package com.example.bt2.fragmentstudient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bt2.R;

import java.util.List;

public class StudientAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<StudientFrag> list;

    public StudientAdapter(Context context, int layout, List<StudientFrag> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txtStudient;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.txtStudient = (TextView) view.findViewById(R.id.txtStudien);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        StudientFrag studientFrag = list.get(i);
        viewHolder.txtStudient.setText(studientFrag.getName());
        return view;
    }
}
