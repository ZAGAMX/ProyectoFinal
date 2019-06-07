package com.example.cantu.proyectofinalpma.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HorarioRepository {

    private static Retrofit retrofit;
    public static final String BASE_URL = "http://ojs.softwarejs.com/public/api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
