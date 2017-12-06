package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.view.Publicaciones;

/**
 * Created by Jonathan on 30/11/2017.
 */

public class PublicacionDbo {
    private DbConnection connection;
    Usuario user = new Usuario();

    public PublicacionDbo(Context context) {
        connection = new DbConnection(context);

    }

    public void crear(Publicacion publicacion){
        ContentValues contentValues = new ContentValues();
        //contentValues.put("id", publicacion.getId());
        contentValues.put("fecha", publicacion.getFecha());
        contentValues.put("descripcion", publicacion.getDescripcion());
        contentValues.put("costo", publicacion.getCosto());
        contentValues.put("estado", publicacion.getEstado());
        contentValues.put("cupo", publicacion.getCupo());
        contentValues.put("usuario", publicacion.getUser().toString());
        contentValues.put("origen", publicacion.getOrigen());

        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacion", null, contentValues);
        publicacion.setId(id.intValue());
        db.close();
    }

    public List<Publicacion> buscar(){
        List<Publicacion> publicacion = new ArrayList<>();


        String[] campos = {"id", "fecha", "descripcion", "costo", "estado", "cupo", "usuario", "origen"};
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query("publicacion", campos, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Publicacion p = new Publicacion();

            //Creando una nueva rama
            p.setId(cursor.getInt(cursor.getColumnIndex("id")));
            p.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            p.setCosto(cursor.getFloat(cursor.getColumnIndex("costo")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            p.setCupo(cursor.getInt(cursor.getColumnIndex("cupo")));
            p.setUser(StringToUser(cursor.getString(cursor.getColumnIndex("usuario"))));
            p.setOrigen(cursor.getString(cursor.getColumnIndex("origen")));
            publicacion.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return publicacion;
    }

    public Usuario StringToUser(String s){
        Usuario u = new Usuario();
        String[] valores = s.split("=");

        u.setId(Integer.parseInt(valores[1].substring(0, valores[1].indexOf(", nombre"))));
        u.setNombre(valores[2].substring(valores[2].indexOf("'")+1, valores[2].indexOf("',")));
        u.setTipoDeUsuario(TipoUsuario.CLIENTE); //Debe usarse Publicador, pero por fines prácticos se utilizó la constante CLIENTE
        u.setTelefono(valores[4].substring(valores[4].indexOf("'")+1, valores[4].indexOf("',")));
        u.setEmail(valores[5].substring(valores[5].indexOf("'")+1, valores[5].indexOf("'}")));
        return u;
    }
}
