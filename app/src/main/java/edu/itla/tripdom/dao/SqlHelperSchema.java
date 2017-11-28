package edu.itla.tripdom.dao;

/**
 * Created by Jonathan on 26/11/2017.
 */

public class SqlHelperSchema {

    public static final String USUARIO_TABLE =
            "CREATE TABLE `usuario` (" +
            "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "`nombre`TEXT NOT NULL, " +
            "`email`TEXT NOT NULL, " +
            "`telefono`TEXT, " +
            "`tip_usuario`TEXT NOT NULL" +
            ")";
    public static final String PUBLICACION_TABLE = "CREATE TABLE `publicacion` (" +
            "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`fecha`TEXT NOT NULL," +
            "`usuario_id`INTEGER NOT NULL," +
            "`descripcion`TEXT NOT NULL," +
            "`costo`REAL NOT NULL," +
            "`estado`TEXT NOT NULL," +
            "`cupo`INTEGER NOT NULL," +
            "`usuario`TEXT NOT NULL," +
            "`origen`TEXT NOT NULL" +
            ")";
    public static final String DETALLE_PUBLICACION_TABLE = "CREATE TABLE `detallespublicacion` (" +
            "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`publicacion`TEXT NOT NULL," +
            "`lugar`TEXT NOT NULL," +
            "`descripcion`TEXT NOT NULL" +
            ")";
    //crear las restantes entidades
}
