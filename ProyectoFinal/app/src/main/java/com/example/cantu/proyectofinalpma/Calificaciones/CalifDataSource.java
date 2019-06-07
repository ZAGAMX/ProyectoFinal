package com.example.cantu.proyectofinalpma.Calificaciones;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class CalifDataSource {

    private static String PREFKEY="notesCalif";
    private SharedPreferences notePrefs;

    public CalifDataSource(Context context){
        notePrefs=context.getSharedPreferences(PREFKEY,Context.MODE_PRIVATE);
    }

    public List<califItem> findAll(){
        //it doesn't know whether the value is a string, an integer
        Map<String,?> notesMap = notePrefs.getAll();
        //The key set returns a listing of all the keys for all the notes in the shared preferences,
        // but in any particular order. The tree set automatically sorts that data and returns it in a sorted set.
        SortedSet<String> keys = new TreeSet<String>(notesMap.keySet());
        List<califItem> NoteItems = new ArrayList<>();

        for (String key:keys){
            califItem note=califItem.getNew();
            note.setKey(key);
            note.setText((String) notesMap.get(key));

            NoteItems.add(note);
        }

        return NoteItems;
    }

    public boolean update(califItem note){
        SharedPreferences.Editor editor = notePrefs.edit();
        editor.putString("matery",note.getMateria());
        editor.putString(note.getKey(), note.getText());
        editor.apply();
        return true;
    }
    public boolean remove(califItem note){
        if(notePrefs.contains(note.getKey())){
            SharedPreferences.Editor editor = notePrefs.edit();
            editor.remove(note.getKey());
            editor.apply();
        }
        return true;
    }
}
