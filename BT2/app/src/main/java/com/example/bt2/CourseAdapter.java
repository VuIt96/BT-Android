package com.example.bt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Course> list;

    public CourseAdapter(Context context, ArrayList<Course> arrayList) {
        this.context = context;
        this.list = arrayList;
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

    class ViewHolder {
        TextView txtNameCourse;
        TextView txtPriceCourse;
        ImageView imgCourse;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view != null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.row_item_layout, null);
            viewHolder.txtNameCourse = (TextView) view.findViewById(R.id.txtNameCourse);
            viewHolder.txtPriceCourse = (TextView) view.findViewById(R.id.txtPriceCourse);
            viewHolder.imgCourse = (ImageView) view.findViewById(R.id.imgCourse);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Course course = (Course) getItem(i);
        viewHolder.txtNameCourse.setText(course.getNameCourse());
        viewHolder.txtPriceCourse.setText(course.getPriceCourse() + " dong");
        Picasso.with(context).load(course.getImgCourse()).into(viewHolder.imgCourse);
        return view;
    }
}
