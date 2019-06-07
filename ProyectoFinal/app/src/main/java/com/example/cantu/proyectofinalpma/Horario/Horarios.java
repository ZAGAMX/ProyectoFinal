package com.example.cantu.proyectofinalpma.Horario;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.cantu.proyectofinalpma.Adapter.AdapterHorarios;
import com.example.cantu.proyectofinalpma.Models.Example;
import com.example.cantu.proyectofinalpma.R;
import com.example.cantu.proyectofinalpma.api.GetHorarios;
import com.example.cantu.proyectofinalpma.api.HorarioRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Horarios extends AppCompatActivity {

    TableLayout tableLayout;
    RecyclerView recyclerView;
    AdapterHorarios adapterHorarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);
        tableLayout = findViewById(R.id.idtable);
        recyclerView = findViewById(R.id.recyclerHorario);

        GetHorarios getHorarios = HorarioRepository.getRetrofitInstance().create(GetHorarios.class);
        Call<List<Example>> call = getHorarios.listaHorarios();

        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                adapterHorarios = new AdapterHorarios(response.body());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapterHorarios);
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Horario");
        loadData();
    }
    private void loadData(){
       // List<HorariosSemestres> horarios = new ArrayList<>();


        crearColumnas();
        //Datos(horarios);

    }

    public void crearColumnas(){
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
        TextView textViewDia = new TextView(this);
        textViewDia.setText("Dia");
        textViewDia.setTextSize(16);
        textViewDia.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewDia.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewDia.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewDia);

        // Name Column
        TextView textViewHora = new TextView(this);
        textViewHora.setText("Hora");
        textViewHora.setTextSize(16);
        textViewHora.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewHora.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewHora.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewHora);

        // Price Column
        TextView textViewMateria = new TextView(this);
        textViewMateria.setText("Materia");
        textViewMateria.setTextSize(16);
        textViewMateria.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewMateria.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewMateria.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewMateria);

        // Profesor Column
        TextView textViewTeacher = new TextView(this);
        textViewTeacher.setText("Profesor");
        textViewTeacher.setTextSize(16);
        textViewTeacher.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewTeacher.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewTeacher.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewTeacher);

        // Price Column
        TextView textViewSalon = new TextView(this);
        textViewSalon.setText("Salon");
        textViewSalon.setTextSize(16);
        textViewSalon.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewSalon.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewSalon.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewSalon);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));


    }

    /*public void Datos(List<HorariosSemestres> horariosSemestres){
        for(HorariosSemestres horarios : horariosSemestres){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            // Id Column
            TextView textViewDia = new TextView(this);
            textViewDia.setText(horarios.getDia());
            textViewDia.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewDia.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewDia);

            // Name Column
            TextView textViewHora = new TextView(this);
            textViewHora.setText(horarios.getHora());
            textViewHora.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewHora.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewHora);

            // Price Column
            TextView textViewMateria = new TextView(this);
            textViewMateria.setText(horarios.getMateria());
            textViewMateria.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewMateria.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewMateria);

            // Profesor Column
            TextView textViewTeacher = new TextView(this);
            textViewTeacher.setText(horarios.getMaestro());
            textViewTeacher.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewTeacher.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewTeacher);

            // Price Column
            TextView textViewSalon = new TextView(this);
            textViewSalon.setText(horarios.getSalon());
            textViewSalon.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewSalon.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewSalon);

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }*/

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
