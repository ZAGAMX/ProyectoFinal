package com.example.cantu.proyectofinalpma.Calificaciones;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class califItem {
    private String key;
    private String text;
    private String materia;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static califItem getNew(){
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);

        String pattern ="yy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key=formatter.format(new Date());

        califItem note = new califItem();
        note.setKey(key);
        note.setText("");
        note.setMateria("");
        return note;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
