package com.example.cantu.proyectofinalpma.Perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cantu.proyectofinalpma.MainActivity;
import com.example.cantu.proyectofinalpma.R;

public class Sesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        setTitle("Inicio de Sesión");
    }
    public void Onclick(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    public void OnclickCrear(View view){
        startActivity(new Intent(this,Crearperfil.class));
    }
}
