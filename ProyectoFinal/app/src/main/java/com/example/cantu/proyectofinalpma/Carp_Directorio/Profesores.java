package com.example.cantu.proyectofinalpma.Carp_Directorio;

public class Profesores {
    String nombre;
    String correo;
    String ubicacion;
    String disponible;

    public Profesores(String nombre, String ubicacion, String disponible){
        this.disponible = disponible;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Profesores(String nombre, String correo, String ubicacion, String disponible){
        this.correo = correo;
        this.disponible = disponible;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
}
