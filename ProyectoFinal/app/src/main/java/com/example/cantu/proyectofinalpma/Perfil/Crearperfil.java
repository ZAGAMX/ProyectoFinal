package com.example.cantu.proyectofinalpma.Perfil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.cantu.proyectofinalpma.Adapter.spinneradapter;
import com.example.cantu.proyectofinalpma.R;

public class Crearperfil extends AppCompatActivity {

    String[] carrera = {"Ing. en Desarrollo de Software", "Ing. en Tecnologias de la Comunicacion", "Lic. en Administracion de la Tecnologia de la Informacion"};
    String[] semestre = {"2","4","6","8"};
    String[] turno = {"Matutino","Vespertino"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearperfil);
        setTitle("Crear cuenta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinner = findViewById(R.id.carrera);
        Spinner spinner1 = findViewById(R.id.semestre);
        Spinner spinner2 = findViewById(R.id.turno);
        SpinnerAdapter adapter = new spinneradapter(getApplicationContext(),carrera);
        spinner.setAdapter(adapter);

        SpinnerAdapter adapter1 = new spinneradapter(getApplicationContext(),semestre);
        spinner1.setAdapter(adapter1);

        SpinnerAdapter adapter2 = new spinneradapter(getApplicationContext(),turno);
        spinner2.setAdapter(adapter2);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
