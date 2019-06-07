package com.example.cantu.proyectofinalpma.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("dia_id")
    @Expose
    private Integer diaId;
    @SerializedName("materia_id")
    @Expose
    private Integer materiaId;
    @SerializedName("maestro_id")
    @Expose
    private Integer maestroId;
    @SerializedName("turno_id")
    @Expose
    private Integer turnoId;
    @SerializedName("semestre_id")
    @Expose
    private Integer semestreId;
    @SerializedName("carrera_id")
    @Expose
    private Integer carreraId;
    @SerializedName("instalacion_id")
    @Expose
    private Integer instalacionId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("materia")
    @Expose
    private Materia materia;
    @SerializedName("maestro")
    @Expose
    private Maestro maestro;
    @SerializedName("semestre")
    @Expose
    private Semestre semestre;
    @SerializedName("turno")
    @Expose
    private Turno turno;
    @SerializedName("carrera")
    @Expose
    private Carrera carrera;
    @SerializedName("instalacion")
    @Expose
    private Instalacion instalacion;
    @SerializedName("dia")
    @Expose
    private Dia dia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getDiaId() {
        return diaId;
    }

    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Integer getMaestroId() {
        return maestroId;
    }

    public void setMaestroId(Integer maestroId) {
        this.maestroId = maestroId;
    }

    public Integer getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Integer turnoId) {
        this.turnoId = turnoId;
    }

    public Integer getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Integer semestreId) {
        this.semestreId = semestreId;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public Integer getInstalacionId() {
        return instalacionId;
    }

    public void setInstalacionId(Integer instalacionId) {
        this.instalacionId = instalacionId;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
}
