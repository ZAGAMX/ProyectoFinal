package com.example.cantu.proyectofinalpma.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cantu.proyectofinalpma.Models.Instalaciones;
import com.example.cantu.proyectofinalpma.R;
import com.example.cantu.proyectofinalpma.mapaCamara.mapaInstalaciones;

import java.util.List;

public class AdapterInstalaciones extends RecyclerView.Adapter<AdapterInstalaciones.ViewHolder> {
    List<Instalaciones> instalaciones;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";
    public AdapterInstalaciones(List<Instalaciones> instalaciones){
        this.instalaciones = instalaciones;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_instalaciones, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.blind(instalaciones.get(i));
    }

    @Override
    public int getItemCount() {
        return instalaciones.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nombre;
        TextView ubica;
        ImageView poster;
        Double lan,lng;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreInstalacion);
            poster = itemView.findViewById(R.id.ImgEdificio);
            ubica = itemView.findViewById(R.id.Ubicacion);
            ubica.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent =  new Intent(context, mapaInstalaciones.class);
            intent.putExtra("lan",lan);
            intent.putExtra("lng",lng);
            intent.putExtra("nombre",nombre.getText().toString());
            context.startActivity(intent);
            //Toast.makeText(v.getContext(),String.valueOf(lng),Toast.LENGTH_SHORT).show();
        }
        public void blind(Instalaciones instalaciones1){
            nombre.setText(instalaciones1.getNombre());
            lan = instalaciones1.getLan();
            lng = instalaciones1.getLng();
            Glide.with(itemView)
                    .load(instalaciones1.getImg())
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    .into(poster);

        }

    }
}
