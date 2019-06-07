 package com.example.cantu.proyectofinalpma.api;

import com.example.cantu.proyectofinalpma.Models.Maestro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {

    @GET("maestros")
    Call<List<Maestro>> listaMaestros();

}
