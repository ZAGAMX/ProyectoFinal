package com.example.cantu.proyectofinalpma.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cantu.proyectofinalpma.Carp_Directorio.Profesores;
import com.example.cantu.proyectofinalpma.Models.Instalaciones;
import com.example.cantu.proyectofinalpma.Models.Maestro;
import com.example.cantu.proyectofinalpma.R;
import com.example.cantu.proyectofinalpma.api.DataInstalacion;
import com.example.cantu.proyectofinalpma.api.GetData;
import com.example.cantu.proyectofinalpma.api.HorarioRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    Data_Adapter adapter;
    AdapterInstalaciones adapterInstalaciones;
    List<Profesores> profesores = new ArrayList<>();


    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        Intent intent = getIntent();
        final String rec = intent.getStringExtra("instala");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //init(rec);
       if(rec.equals("0")){
           setTitle("Directorio Profesores");
           GetData getData = HorarioRepository.getRetrofitInstance().create(GetData.class);
           Call<List<Maestro>> call = getData.listaMaestros();

           Log.wtf("URL Called", call.request().url() + "");

           call.enqueue(new Callback<List<Maestro>>() {
               @Override
               public void onResponse(Call<List<Maestro>> call, Response<List<Maestro>> response) {
                   adapter = new Data_Adapter(response.body(), 0);
                   recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                   recyclerView.setItemAnimator(new DefaultItemAnimator());
                   recyclerView.setAdapter(adapter);
               }

               @Override
               public void onFailure(Call<List<Maestro>> call, Throwable t) {

               }
           });
       }
       else{
           setTitle("Directorio Instalaciones");
           DataInstalacion dataInstalacion = HorarioRepository.getRetrofitInstance().create(DataInstalacion.class);
           Call<List<Instalaciones>> call = dataInstalacion.listaInstalaciones();
           call.enqueue(new Callback<List<Instalaciones>>() {
               @Override
               public void onResponse(Call<List<Instalaciones>> call, final Response<List<Instalaciones>> response) {
                   adapterInstalaciones = new AdapterInstalaciones(response.body());
                   recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                   recyclerView.setItemAnimator(new DefaultItemAnimator());
                   recyclerView.setAdapter(adapterInstalaciones);

               }

               @Override
               public void onFailure(Call<List<Instalaciones>> call, Throwable t) {

               }
           });
       }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return false; //meaning I handle this event, dont do anything else
        //return super.onOptionsItemSelected(item);
    }

    public void init(String x, List<Maestro> maestros) {
        if(x=="0"){
            adapter = new Data_Adapter(maestros,0);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }
    }
}
