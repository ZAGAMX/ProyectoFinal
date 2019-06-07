package com.example.cantu.proyectofinalpma.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cantu.proyectofinalpma.R;

public class spinneradapter extends BaseAdapter {
    Context context;
    String[] palabras;
    LayoutInflater layoutInflater;

    public spinneradapter(Context context, String[] palabras){
        this.context = context;
        this.palabras = palabras;
        layoutInflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return palabras.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.sp_item, null);
        TextView textView = convertView.findViewById(R.id.textSpinner);
        textView.setText(palabras[position]);
        return convertView;
    }
}
