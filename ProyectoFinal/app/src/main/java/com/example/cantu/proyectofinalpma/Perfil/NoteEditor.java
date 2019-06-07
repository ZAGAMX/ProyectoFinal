package com.example.cantu.proyectofinalpma.Perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.cantu.proyectofinalpma.R;


public class NoteEditor extends AppCompatActivity {

    private NoteItem note;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=this.getIntent();
        note=new NoteItem();
        note.setKey(intent.getStringExtra("key"));
        note.setText(intent.getStringExtra("text"));

        et = findViewById(R.id.noteText);
        et.setText(note.getText());
        et.setSelection(note.getText().length());
    }

    private void saveAndFinish(){
        String noteText=et.getText().toString();

        if(!noteText.equals("")){
            Intent intent = new Intent();
            intent.putExtra("key",note.getKey());
            intent.putExtra("text",noteText);
            setResult(RESULT_OK,intent); //everything is ok
            finish();
        }
        else{
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            saveAndFinish();
        }
        return false; //meaning I handle this event, dont do anything else
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        saveAndFinish();
    }
}
