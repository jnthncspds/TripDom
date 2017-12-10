package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import edu.itla.tripdom.R;
import edu.itla.tripdom.UsuarioActual;
import edu.itla.tripdom.dao.PublicacionDbo;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class CrearPublicacion extends AppCompatActivity {
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");
    PublicacionDbo publicacionDbo = new PublicacionDbo(this); //Se declara una variable para empezar una conexion
    Publicacion publicacion = new Publicacion(); //variable publicacion
    Usuario user = new Usuario(); //Variable usuario, esta sirve para pasar el valor de un usuario para la publicacion.
    //La variable usuario sera reemplazada por el valor que pase en un bundle al activity, sobre los datos del usuario que inicio sesion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_publicacion);

        final EditText txtFecha = findViewById(R.id.txtFecha); //Se mapean las variables del activity.
        final EditText txtDescripcion = findViewById(R.id.txtDescripcion);
        final EditText txtCosto = findViewById(R.id.txtCosto);
        final EditText txtEstado = findViewById(R.id.txtEstado);
        final EditText txtCupo = findViewById(R.id.txtCupo);
        final EditText txtOrigen = findViewById(R.id.txtOrigen);

        Random r = new Random(); // Esto no es necesario. Solo sirve para asignar un numero al azar al id... esto sera reemplazado
        int i = r.nextInt(); // es poco seguro asignar un id al azar debido a que puede existir en la base de datos.



        Button btnPub = findViewById(R.id.btnPub); //Se mapea el boton de crear publicacion

        btnPub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Se empieza la configuracion del boton
                if (UsuarioActual.getUsuario()==null){
                    Toast.makeText(CrearPublicacion.this, "Usted no puede crear una publicacion", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        publicacion.setFecha(DF.parse(txtFecha.getText().toString())); //Se asignan los valores de la publicacion por las variables de mapeo
                    }catch(Exception ex){
                        Toast.makeText(CrearPublicacion.this, "Fecha incorrecta", Toast.LENGTH_SHORT).show();

                    }

                    publicacion.setDescripcion(txtDescripcion.getText().toString());
                    publicacion.setCosto(Double.parseDouble(txtCosto.getText().toString()));
                    publicacion.setEstado(txtEstado.getText().toString());
                    publicacion.setCupo(Integer.parseInt(txtCupo.getText().toString()));
                    publicacion.setUser(UsuarioActual.getUsuario());
                    publicacion.setOrigen(txtOrigen.getText().toString());
                    publicacionDbo.crear(publicacion); //Se llama al metodo crear publicacion para inicializar la publicacion en base de datos
                    Log.i("Publicacion", publicacion.toString()); //Log para ver si funciona
                    Toast.makeText(CrearPublicacion.this, "Everything okay Jonathan ;)", Toast.LENGTH_SHORT).show(); //Si se llego a este punto sin excepciones significa que todo esta bien.
                }
            }
        });
    }
}
