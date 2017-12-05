package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.PublicacionDbo;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class CrearPublicacion extends AppCompatActivity {

    PublicacionDbo publicacionDbo = new PublicacionDbo(this);
    Publicacion publicacion = new Publicacion();
    Usuario user = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_publicacion);

        final EditText txtFecha = findViewById(R.id.txtFecha);
        final EditText txtDescripcion = findViewById(R.id.txtDescripcion);
        final EditText txtCosto = findViewById(R.id.txtCosto);
        final EditText txtEstado = findViewById(R.id.txtEstado);
        final EditText txtCupo = findViewById(R.id.txtCupo);
        final EditText txtOrigen = findViewById(R.id.txtOrigen);

        Button btnPub = findViewById(R.id.btnPub);

        btnPub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setNombre("PRUEBA");
                user.setEmail("Prueba@hotmail.com");
                user.setTipoDeUsuario(TipoUsuario.CLIENTE);
                user.setTelefono("8094656200");


                publicacion.setFecha(txtFecha.getText().toString());
                publicacion.setDescripcion(txtDescripcion.getText().toString());
                publicacion.setCosto(Double.parseDouble(txtCosto.getText().toString()));
                publicacion.setEstado(txtEstado.getText().toString());
                publicacion.setCupo(Integer.parseInt(txtCupo.getText().toString()));
                publicacion.setOrigen(txtOrigen.getText().toString());
                publicacion.setUser(user);
                Toast.makeText(CrearPublicacion.this, "Everything okay Jonathan ;)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
