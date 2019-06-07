 package com.example.cantu.proyectofinalpma.api;

import com.example.cantu.proyectofinalpma.Models.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetHorarios {
    @GET("horarios")
    Call<List<Example>> listaHorarios();
}
