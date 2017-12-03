package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.view.Publicaciones;
import edu.itla.tripdom.view.ListaUsuario;

public class MainActivity extends AppCompatActivity {
    UsuarioDbo userdb = new UsuarioDbo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnEventos = findViewById(R.id.btnEventos);
        Button btnListaUsuario = findViewById(R.id.btnListaUsuario);

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
