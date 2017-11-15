package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.itla.tripdom.Entity.Publicacion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtNombre = findViewById(R.id.txtNombre);
        Button btnGuardar = findViewById(R.id.btnGuardar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String nombre = txtNombre.getText().toString();
               String joao = "Joao Alvarez";
             /*  if (nombre.isEmpty()) {
                   Toast fallar = Toast.makeText(MainActivity.this, "Debe introducir un nombre", Toast.LENGTH_LONG);
                   fallar.show();
               }
               else{
                   Toast message = Toast.makeText(MainActivity.this, "Hola, " + nombre, Toast.LENGTH_LONG);
                   message.show();
               }*/
                Intent vista = new Intent(MainActivity.this, Visualizar.class);
                vista.putExtra("Nombre", nombre);
                vista.putExtra("Joao", joao);
                startActivity(vista);
            }
        });
    }
}
