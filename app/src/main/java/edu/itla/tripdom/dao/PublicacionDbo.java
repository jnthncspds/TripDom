package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.view.Publicaciones;

/**
 * Created by Jonathan on 30/11/2017.
 */

public class PublicacionDbo {
    private DbConnection connection;
    Usuario user = new Usuario();
    Publicaciones pub = new Publicaciones();

    public PublicacionDbo(Context context) {
        connection = new DbConnection(context);;
    }

    public void crear(Publicacion publicacion){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", publicacion.getId());
        contentValues.put("fecha", publicacion.getFecha());
        contentValues.put("descripcion", publicacion.getDescripcion());
        contentValues.put("costo", publicacion.getCosto());
        contentValues.put("estado", publicacion.getEstado());
        contentValues.put("cupo", publicacion.getCupo());
        contentValues.put("usuario", user.getEmail());
        contentValues.put("origen", publicacion.getOrigen());

        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacion", null, contentValues);
        publicacion.setId(id.intValue());
        db.close();
    }
}
