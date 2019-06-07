package com.example.cantu.proyectofinalpma.Adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cantu.proyectofinalpma.Models.Instalaciones;
import com.example.cantu.proyectofinalpma.Models.Maestro;
import com.example.cantu.proyectofinalpma.R;

import java.util.List;

public class Data_Adapter extends RecyclerView.Adapter<Data_Adapter.ViewHolder> {

    List<Maestro> profesores;
    List<Instalaciones> instalaciones;
    int layout;

    public Data_Adapter(List<Instalaciones> instalaciones){
        this.instalaciones = instalaciones;
    }

    public Data_Adapter(List<Maestro> profesores, int layout){
        this.profesores = profesores;
        this.layout = layout;
    }



    @NonNull
    @Override
    public Data_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_profesores, null, false);
        int layout;
        switch (this.layout){
            case 0:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_profesores, null, false);
                layout = R.layout.item_profesores;
                break;
            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_instalaciones, null, false);
                layout = R.layout.item_instalaciones;
                break;
                default:
                    layout = 0;
                    break;
        }

        return new ViewHolder(view, layout);
    }

    @Override
    public void onBindViewHolder(@NonNull Data_Adapter.ViewHolder viewHolder, int i) {
        switch (layout){
            case 0:
                viewHolder.nombre.setText(profesores.get(i).getNombre());
                viewHolder.correo.setText(profesores.get(i).getCorreo());
                /*viewHolder.ubicacion.setText(profesores.get(i).getUbicacion());
                viewHolder.disponible.setText(profesores.get(i).getDisponible());*/
                break;
            case 1:
                viewHolder.nombre.setText(instalaciones.get(i).getNombre());
                /*viewHolder.ubicacion.setText(profesores.get(i).getUbicacion());
                viewHolder.disponible.setText(profesores.get(i).getDisponible());*/
                break;
        }

    }

    @Override
    public int getItemCount() {
        return profesores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView correo;
        TextView ubicacion;
        TextView disponible;

        int layout;


        public ViewHolder(@NonNull View itemView, @LayoutRes int layout) {
            super(itemView);
            this.layout = layout;
            switch (layout){
                case R.layout.item_profesores:
                    nombre = itemView.findViewById(R.id.nombreProfesor);
                    correo = itemView.findViewById(R.id.correoProfesor);
                    ubicacion = itemView.findViewById(R.id.dispoProfesor);
                    disponible = itemView.findViewById(R.id.salonProfesor);
                    break;
                case R.layout.item_instalaciones:
                    nombre = itemView.findViewById(R.id.nombreInstalacion);
                    ubicacion = itemView.findViewById(R.id.Ubicacion);
                    disponible = itemView.findViewById(R.id.dispoInstalacion);
                        break;
            }

        }
    }
}
