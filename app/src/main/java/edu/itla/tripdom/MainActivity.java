package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import edu.itla.tripdom.dao.PublicacionDbo;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.view.CrearPublicacion;
import edu.itla.tripdom.view.ListaPublicacion;
import edu.itla.tripdom.view.Publicaciones;
import edu.itla.tripdom.view.ListaUsuario;

public class MainActivity extends AppCompatActivity {
    UsuarioDbo userdb = new UsuarioDbo(this);
    PublicacionDbo p = new PublicacionDbo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListarEventos = findViewById(R.id.btnListaEventos);
        Button btnEventos = findViewById(R.id.btnEventos);
        Button btnListaUsuario = findViewById(R.id.btnListaUsuario);
        Button btnCrearEventos = findViewById(R.id.btnCrearEvento);
        Button btnListaEventos = findViewById(R.id.btnListaEventos);

        btnListarEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Publicacion> usuarios = p.buscar();
                for (Publicacion u: usuarios){
                    Log.i("ListUusuarios", u.toString());
                    Toast.makeText(MainActivity.this, ""+u.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnListaEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent listaEventos = new Intent(MainActivity.this, ListaPublicacion.class);
                    startActivity(listaEventos);
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Excepcion: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCrearEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crearEventos = new Intent(MainActivity.this, CrearPublicacion.class);
                startActivity(crearEventos);
            }
        });

        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vista = new Intent(MainActivity.this, Publicaciones.class);
                startActivity(vista);
                //finish();
            }
        });


        btnListaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vista = new Intent(MainActivity.this, ListaUsuario.class);
                startActivity(vista);

            }
        });
    }
}
