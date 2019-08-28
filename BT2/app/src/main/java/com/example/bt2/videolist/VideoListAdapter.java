package com.example.bt2.videolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bt2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<VideoYoutubeList> lists;

    public VideoListAdapter(Context context, int layout, List<VideoYoutubeList> lists) {
        this.context = context;
        this.layout = layout;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
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
        ImageView imgVideoList;
        TextView txtVideoList;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.imgVideoList = (ImageView) view.findViewById(R.id.imgVideoList);
            viewHolder.txtVideoList = (TextView) view.findViewById(R.id.txtVideoList);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        VideoYoutubeList videoYoutubeList = lists.get(i);
        viewHolder.txtVideoList.setText(videoYoutubeList.getTitle());
        Picasso.with(context).load(videoYoutubeList.getThumbnails()).into(viewHolder.imgVideoList);
        return view;
    }
}
