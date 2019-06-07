package com.example.cantu.proyectofinalpma.Perfil;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class NotesDataSource {
    private static String PREFKEY="notes";
    private SharedPreferences notePrefs;

    //instantiate it as the data source class itself is instantiated
    //The context is the superclass of an activity, and it's how we'll connect this Java class to the higher-level application
    public NotesDataSource(Context context){
        notePrefs=context.getSharedPreferences(PREFKEY,Context.MODE_PRIVATE);
    }

    public List<NoteItem> findAll(){
        //it doesn't know whether the value is a string, an integer
        Map<String,?> notesMap=notePrefs.getAll();
        //The key set returns a listing of all the keys for all the notes in the shared preferences,
        // but in any particular order. The tree set automatically sorts that data and returns it in a sorted set.
        SortedSet<String> keys = new TreeSet<String>(notesMap.keySet());
        List<NoteItem> NoteItems = new ArrayList<NoteItem>();
        for (String key:keys){
            NoteItem note=NoteItem.getNew();
            note.setKey(key);
            note.setText((String) notesMap.get(key));
            NoteItems.add(note);
        }

        return NoteItems;
    }

    public boolean update(NoteItem note){
        SharedPreferences.Editor editor = notePrefs.edit();
        editor.putString(note.getKey(), note.getText());
        editor.apply();
        return true;
    }
    public boolean remove(NoteItem note){
        if(notePrefs.contains(note.getKey())){
            SharedPreferences.Editor editor = notePrefs.edit();
            editor.remove(note.getKey());
            editor.apply();
        }
        return true;
    }
}
