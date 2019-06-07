package com.example.cantu.proyectofinalpma.api;

import com.example.cantu.proyectofinalpma.Models.Example;

import java.util.List;

public interface OnGetHorariosCallback {
    void onSuccess(List<Example> movies);

    void onError();
}
