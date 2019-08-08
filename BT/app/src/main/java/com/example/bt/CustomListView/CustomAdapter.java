package com.example.bt.CustomListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.bt.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> userArrayList;

    public CustomAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return userArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // giu lai anh xa -> app chay nhanh
    class ViewHolder {
        TextView txtName;
        CheckBox cbName;
    }

    public void UpdateListview(ArrayList<User> users) {
        this.userArrayList = users;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.dong_custonlayout, null);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txt_name);
            viewHolder.cbName = (CheckBox) view.findViewById(R.id.cb_custom1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        User user = (User) getItem(i);
        viewHolder.txtName.setText(user.getUsername());
        if (user.isIschecked()) {
            viewHolder.cbName.setChecked(true);
        } else {
            viewHolder.cbName.setChecked(false);
        }
        return view;
    }
}
