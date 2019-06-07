package com.example.cantu.proyectofinalpma.Perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cantu.proyectofinalpma.R;

import java.util.List;

public class Notes_Perfil extends AppCompatActivity {

    public static final int EDITOR_ACTIVITY_REQUEST = 1001;
    public static final int MENU_DELETE_ID = 1002; //ID of my context menu item
    /*There are going to be two methods. One to construct the context menu and one to handle the event
    that's fired when the user selects a menu item. You'll be able to detect which item in the list the
    user has selected when the context menu is constructed but not when the menu item is selected.
    So you have to save it persistently between the two operations. And that's what this new field is for.*/
    public static int currentNoteId;
    private NotesDataSource datasource;
    List<NoteItem> notesList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes__perfil);

        //registerForContextMenu(getListView());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datasource = new NotesDataSource(this);
        listView = findViewById(R.id.list);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoteItem note = notesList.get(position);
                Intent intent=new Intent(view.getContext(),NoteEditor.class);
                intent.putExtra("key",note.getKey());
                intent.putExtra("text",note.getText());
                startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNote();
            }
        });

        refreshDisplay();

    }

    private void refreshDisplay() {
        //The array adapter class will be used to wrap around the data, and feed that data to the list display
        notesList = datasource.findAll();
        ArrayAdapter<NoteItem> adapter = new ArrayAdapter<>(this,R.layout.list_item,notesList);
        listView.setAdapter(adapter);
        //setListAdapter(adapter); //Neu implement FragmentActivitt (de cho xuat hien menu on action bar, thi setListAdapter phai lam sao?
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void createNote() {
        NoteItem note =NoteItem.getNew();
        Intent intent=new Intent(this,NoteEditor.class);
        intent.putExtra("key",note.getKey());
        intent.putExtra("text",note.getText());
        startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);
        //When you start the activity, you pass in the request code. When the activity is finished,
        // it passes back the request code. And when the first activity receives the request code it
        // can figure out which screen it came from. The request code integer can be anything
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==EDITOR_ACTIVITY_REQUEST && resultCode==RESULT_OK){
            NoteItem note = new NoteItem();
            note.setKey(data.getStringExtra("key"));
            note.setText(data.getStringExtra("text"));
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
                            NoteItem note=notesList.get(currentNoteId);
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
