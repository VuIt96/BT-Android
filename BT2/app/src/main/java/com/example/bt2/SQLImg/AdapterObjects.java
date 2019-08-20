package com.example.bt2.SQLImg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bt2.R;

import java.util.List;

public class AdapterObjects extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoVat> doVatList;

    public AdapterObjects(Context context, int layout, List<DoVat> doVatList) {
        this.context = context;
        this.layout = layout;
        this.doVatList = doVatList;
    }

    @Override
    public int getCount() {
        return doVatList.size();
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
        TextView txtNameCustom, txtCustom;
        ImageView imgCustom;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            viewHolder.txtNameCustom = (TextView) view.findViewById(R.id.txtNameCustom);
            viewHolder.txtCustom = (TextView) view.findViewById(R.id.txtCustom);
            viewHolder.imgCustom = (ImageView) view.findViewById(R.id.imgCustom);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DoVat doVat = doVatList.get(i);
        viewHolder.txtNameCustom.setText(doVat.getTen());
        viewHolder.txtNameCustom.setText(doVat.getMota());
        //chuyen byte sang bitmap
        byte[] hinhanh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);
        viewHolder.imgCustom.setImageBitmap(bitmap);

        return null;
    }
}
