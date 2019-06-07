package com.example.cantu.proyectofinalpma.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cantu.proyectofinalpma.Models.Example;
import com.example.cantu.proyectofinalpma.Models.ListaHorario;
import com.example.cantu.proyectofinalpma.R;

import java.util.List;

public class AdapterHorarios extends RecyclerView.Adapter<AdapterHorarios.ItemHolder> {

    List<Example> listaHorarios;

    public AdapterHorarios(List<Example> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemhorarios, null, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        //Materias materia = new Materias();
        itemHolder.dia.setText(listaHorarios.get(i).getDia().getNombre());
        itemHolder.hora.setText(listaHorarios.get(i).getHora());
        itemHolder.materia.setText(listaHorarios.get(i).getMateria().getNombre());
        itemHolder.maestro.setText(listaHorarios.get(i).getMaestro().getNombre());
        itemHolder.instalacion.setText(listaHorarios.get(i).getInstalacion().getNombre());
        itemHolder.carrera.setText(listaHorarios.get(i).getCarrera().getNombre());
        itemHolder.semestre.setText(String.valueOf(listaHorarios.get(i).getSemestre().getNombre()));

    }

    @Override
    public int getItemCount() {
        return listaHorarios.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{

        TextView dia,hora,materia,maestro,instalacion,semestre,carrera;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            hora = itemView.findViewById(R.id.horaHorario);
            materia = itemView.findViewById(R.id.materiaHorario);
            dia = itemView.findViewById(R.id.diaHorario);
            maestro = itemView.findViewById(R.id.maestroHorario);
            instalacion = itemView.findViewById(R.id.salonHorario);
            semestre = itemView.findViewById(R.id.semestreHorario);
            carrera = itemView.findViewById(R.id.carreraHorario);

        }
    }
}
