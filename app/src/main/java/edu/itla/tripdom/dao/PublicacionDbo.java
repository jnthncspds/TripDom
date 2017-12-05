package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        contentValues.put("usuario", String.valueOf(user));
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
            Usuario u = new Usuario();
            String usuario = cursor.getString(cursor.getColumnIndex("usuario"));
            int[] i = new int[0];
            i[0] = usuario.indexOf("id=");
            i[1] = usuario.indexOf(", nombre=");
            i[2] = usuario.indexOf(", tipoDeUsuario=");
            i[3] = usuario.indexOf(", telefono='");
            i[4] = usuario.indexOf(", email='");
            i[5] = usuario.indexOf("}");
            u.setId(Integer.parseInt(usuario.substring(i[0], i[1])));
            u.setNombre(usuario.substring(i[1], i[2]));
            u.setTipoDeUsuario(TipoUsuario.CLIENTE);
            u.setEmail(usuario.substring(i[4], i[5]));
            String revisar = u.toString();
            Toast.makeText(pub, ""+revisar, Toast.LENGTH_SHORT).show();

            p.setId(cursor.getInt(cursor.getColumnIndex("id")));
            p.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            p.setCosto(cursor.getFloat(cursor.getColumnIndex("costo")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            p.setCupo(cursor.getInt(cursor.getColumnIndex("cupo")));
            p.setUser(u);
            p.setOrigen(cursor.getString(cursor.getColumnIndex("origen")));
        }


        return publicacion;
    }
}
