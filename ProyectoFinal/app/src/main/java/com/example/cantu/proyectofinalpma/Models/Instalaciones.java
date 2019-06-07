package com.example.cantu.proyectofinalpma.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Instalaciones {

    @SerializedName("nombre")
    String nombre;
    @SerializedName("lan")
    double lan;
    @SerializedName("lng")
    double lng;
    @SerializedName("imgUrl")
    String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
