package com.example.cantu.proyectofinalpma.Calificaciones;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cantu.proyectofinalpma.R;

import java.util.List;

public class califAdapter extends ArrayAdapter<califItem> {
    private Context context;
    private List<califItem> califItems ;
    public califAdapter(Context context, List<califItem> califItems){
        super(context, 0 , califItems);
        this.context = context;
        this.califItems = califItems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null)
            listView = LayoutInflater.from(context).inflate(R.layout.list_itemcalif,parent,false);

        califItem Item = califItems.get(position);
        TextView textView = listView.findViewById(R.id.textoCalif);
        textView.setText(Item.getText());
        TextView textView1 = listView.findViewById(R.id.materiaCalif);
        textView1.setText(Item.getMateria());

        return listView;


    }
}
