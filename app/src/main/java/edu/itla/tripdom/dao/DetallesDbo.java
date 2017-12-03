package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;

import edu.itla.tripdom.entity.DetallesPublicacion;
import edu.itla.tripdom.entity.Publicacion;

/**
 * Created by Jonathan on 30/11/2017.
 */

public class DetallesDbo {
    DbConnection connection;

    public DetallesDbo(Context context) {
        connection = new DbConnection(context);
    }
    public void crear(DetallesPublicacion detallesPublicacion){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", detallesPublicacion.getId());
        contentValues.put("publicacion", (detallesPublicacion.getPublicacion().toString()));
        contentValues.put("lugar", detallesPublicacion.getLugar());
        contentValues.put("descripcion", detallesPublicacion.getDescripcion());
    }
}
