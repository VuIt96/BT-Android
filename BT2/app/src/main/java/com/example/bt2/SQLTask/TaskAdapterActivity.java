package com.example.bt2.SQLTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bt2.R;

import java.util.List;

public class TaskAdapterActivity extends BaseAdapter {
    private SQLiteListActivity context;
    private int layout;
    private List<TaskActivity> TaskList;

    public TaskAdapterActivity(SQLiteListActivity context, int layout, List<TaskActivity> taskList) {
        this.context = context;
        this.layout = layout;
        TaskList = taskList;
    }

    @Override
    public int getCount() {
        return TaskList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtNameQSL;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtNameQSL = (TextView) view.findViewById(R.id.txtNameTask);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            holder.imgEdit = (ImageView) view.findViewById(R.id.imgEdit);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final TaskActivity taskActivity = TaskList.get(i);
        holder.txtNameQSL.setText(taskActivity.getName());
        // bat su kien xoa sua
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialogUpdateTask(taskActivity.getName(), taskActivity.getId());
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialogDeleteTask(taskActivity.getName(), taskActivity.getId());
            }
        });
        return view;
    }
}
