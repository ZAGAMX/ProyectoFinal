package com.example.cantu.proyectofinalpma.Calificaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.cantu.proyectofinalpma.R;

import java.util.List;

public class calificacion extends AppCompatActivity {

    public static final int EDITOR_ACTIVITY_REQUEST = 1001;
    public static final int MENU_DELETE_ID = 1002;
    public static int currentNoteId;
    private CalifDataSource datasource;
    List<califItem> notesList;
    ListView listView;
    califItem note;
    califAdapter adapterCali;

    String[] materias = {"Admin", "Android","Sist. Distribuido"};
    String obtener;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        setTitle("Calificaciones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datasource = new CalifDataSource(this);
        listView = findViewById(R.id.listCali);
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                note = notesList.get(position);
                Intent intent=new Intent(view.getContext(),agregarCalificaciones.class);
                intent.putExtra("key",note.getKey());
                intent.putExtra("text",note.getText());
                startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fabCali);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               createCalif();
            }
        });
        refreshDisplay();
    }

    private void createCalif() {
        califItem note = califItem.getNew();
        Intent intent=new Intent(this,agregarCalificaciones.class);
        intent.putExtra("key",note.getKey());
        intent.putExtra("text",note.getText());
        intent.putExtra("matery", note.getMateria());
        startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);
        //When you start the activity, you pass in the request code. When the activity is finished,
        // it passes back the request code. And when the first activity receives the request code it
        // can figure out which screen it came from. The request code integer can be anything
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

    private void refreshDisplay() {
        //The array adapter class will be used to wrap around the data, and feed that data to the list display
        notesList = datasource.findAll();
        //ArrayAdapter<califItem> adapter = new ArrayAdapter<>(this,R.layout.list_item,notesList);
        adapterCali = new califAdapter(this, notesList);

        listView.setAdapter(adapterCali);
        //setListAdapter(adapter); //Neu implement FragmentActivitt (de cho xuat hien menu on action bar, thi setListAdapter phai lam sao?
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==EDITOR_ACTIVITY_REQUEST && resultCode==RESULT_OK){
            califItem note = new califItem();
            note.setKey(data.getStringExtra("key"));
            note.setText(data.getStringExtra("text"));
            note.setMateria(data.getStringExtra("matery"));
            datasource.update(note);
            refreshDisplay();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // the menu info object has been cast as info, and that object can tell me which item of the list I'm talking about.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        currentNoteId=(int) info.id;
        menu.add(0, MENU_DELETE_ID,0,"Borrar esta nota");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==MENU_DELETE_ID){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Desea borrar esta nota?");
            builder.setTitle("Borrar Nota");
            builder.setCancelable(false);
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    califItem note=notesList.get(currentNoteId);
                    datasource.remove(note);
                    refreshDisplay();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.cancel();
                }
            });
            // Create the Alert dialog
            AlertDialog alertDialog = builder.create();

            // Show the Alert Dialog box
            alertDialog.show();



        }
        return super.onContextItemSelected(item);
    }


}
