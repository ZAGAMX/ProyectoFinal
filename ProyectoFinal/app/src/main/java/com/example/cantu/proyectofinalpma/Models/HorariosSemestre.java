package com.example.cantu.proyectofinalpma.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class HorariosSemestre {

    @SerializedName("hora")
    String hora;
    List<Maestro> maestros;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Maestro> getMaestros() {
        return maestros;
    }

    public void setMaestros(List<Maestro> maestros) {
        this.maestros = maestros;
    }
}
