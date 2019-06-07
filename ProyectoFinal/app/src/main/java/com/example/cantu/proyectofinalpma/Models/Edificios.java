package com.example.cantu.proyectofinalpma.Models;

import com.google.gson.annotations.SerializedName;

class Edificios {
    @SerializedName("nombre")
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
