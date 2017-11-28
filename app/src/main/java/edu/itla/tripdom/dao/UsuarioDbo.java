package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Jonathan on 26/11/2017.
 */

public class UsuarioDbo {
    private DbConnection connection;

    public UsuarioDbo(Context context) {
        connection = new DbConnection(context);
    }


    public void crear(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("email", usuario.getEmail());
        cv.put("tip_usuario", usuario.getTipoDeUsuario().toString());
        cv.put("telefono", usuario.getTelefono());

        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("usuario", null, cv);
        usuario.setId(id.intValue());

        db.close();
    }

    public List<Usuario> buscar() {
        List<Usuario> usuarios = new ArrayList<>();
        String columnas[] = new String[]{"id", "nombre", "email","telefono",  "tip_usuario"};
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Usuario u = new Usuario();

            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setTipoDeUsuario(TipoUsuario.valueOf((cursor.getString(cursor.getColumnIndex("tip_usuario")))));
            usuarios.add(u);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return usuarios;
    }

}
