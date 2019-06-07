package com.example.cantu.proyectofinalpma.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instalacion {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("lan")
    @Expose
    private Double lan;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("edificio_id")
    @Expose
    private Integer edificioId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getLan() {
        return lan;
    }

    public void setLan(Double lan) {
        this.lan = lan;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(Integer edificioId) {
        this.edificioId = edificioId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
