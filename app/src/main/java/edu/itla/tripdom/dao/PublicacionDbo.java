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
        contentValues.put("usuario_id", publicacion.getUserId());
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

    public List<Publicacion> buscar(){ //Retorna una lista de publicaciones.
        List<Publicacion> publicacion = new ArrayList<>(); //lista que retorna


        String[] campos = {"id", "fecha","usuario_id", "descripcion", "costo", "estado", "cupo", "usuario", "origen"}; //campos en la base de datos
        SQLiteDatabase db = connection.getReadableDatabase(); //se llama la conexion leible de la base de datos
        Cursor cursor = db.query("publicacion", campos, null, null, null, null, null);
        cursor.moveToFirst(); //Declaracion del cursor, cursor sirve para pasar por las posiciones de una lista.
        while (!cursor.isAfterLast()){ //Bucle while, mientras el cursor no está despues de la posicion final ejecuta este codigo
            Publicacion p = new Publicacion();

            //Creando una nueva ram
            p.setId(cursor.getInt(cursor.getColumnIndex("id"))); //Asigna un id a una variable publicacion para ser añadida a la lista.
            p.setFecha(cursor.getString(cursor.getColumnIndex("fecha"))); //Asigna valor, al igual que en las lineas de abajo.
            p.setUserId(StringToUser(cursor.getString(cursor.getColumnIndex("usuario"))).getId());
            p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            p.setCosto(cursor.getFloat(cursor.getColumnIndex("costo")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            p.setCupo(cursor.getInt(cursor.getColumnIndex("cupo")));
            p.setUser(StringToUser(cursor.getString(cursor.getColumnIndex("usuario")))); //Se utiliza el metodo StringToUser para pasar los valores
            p.setOrigen(cursor.getString(cursor.getColumnIndex("origen")));
            publicacion.add(p); //Añade la publicacion a la lista.
            cursor.moveToNext(); // indica al cursor que se mueva a la siguiente posicion
        }
        cursor.close(); //Indica al cursor que cierra o termine.
        db.close(); // Indica que termine la conexion a la base de datos.

        return publicacion; //retorna la lista de publicaciones.
    }

    private Usuario StringToUser(String s){//Toma un String con el formato de un usuario en base de datos y lo transforma en usuario
        Usuario u = new Usuario();
        String[] valores = s.split("=");

        u.setId(Integer.parseInt(valores[1].substring(0, valores[1].indexOf(", nombre")))); //Toma el valor del string, donde el valor esta entre 0 y ", nombre"
        u.setNombre(valores[2].substring(valores[2].indexOf("'")+1, valores[2].indexOf("',"))); //Mismo concepto que la linea de arriba.
        u.setTipoDeUsuario(TipoUsuario.CLIENTE); //Debe usarse Publicador, pero por fines prácticos se utilizó la constante CLIENTE
        u.setTelefono(valores[4].substring(valores[4].indexOf("'")+1, valores[4].indexOf("',")));
        u.setEmail(valores[5].substring(valores[5].indexOf("'")+1, valores[5].indexOf("'}")));
        return u; //devuelve el usuario
    }
}
