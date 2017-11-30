package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.view.Publicaciones;
import edu.itla.tripdom.view.RegistroUsuario;

public class MainActivity extends AppCompatActivity {
    UsuarioDbo userdb = new UsuarioDbo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtEmail = findViewById(R.id.txtEmailLogin);
        final EditText txtNumero = findViewById(R.id.txtNumero);
        Button btnIniciarSesion = findViewById(R.id.btnInicioSesion);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        final String email = txtEmail.getText().toString();

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Usuario> usuarios = userdb.buscar();
                for(Usuario u: usuarios) {
                    if((u.getEmail().equals(txtEmail.getText().toString()))^(u.getTelefono().equals(txtNumero.getText().toString()))) {
                        Intent vista = new Intent(MainActivity.this, Publicaciones.class);
                        startActivity(vista);
                        finish();
                        break;
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No se encontró el email en la base de datos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vista = new Intent(MainActivity.this, RegistroUsuario.class);
                startActivity(vista);

            }
        });
    }
}
