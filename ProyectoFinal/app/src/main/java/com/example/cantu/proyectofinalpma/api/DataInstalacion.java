package com.example.cantu.proyectofinalpma.api;

import com.example.cantu.proyectofinalpma.Models.Instalaciones;
import com.example.cantu.proyectofinalpma.Models.Maestro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInstalacion {

    @GET("instalaciones")
    Call<List<Instalaciones>> listaInstalaciones();
}
