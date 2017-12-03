package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {
    private static final String LOG_T = "RegistroUsuarioLog";
    UsuarioDbo userdb = new UsuarioDbo(this);
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        Button btnLista = findViewById(R.id.btnListar);
        Button btnSave = findViewById(R.id.btnSave);
        final EditText txtNombreUser = findViewById(R.id.txtUser);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtTelefono = findViewById(R.id.txtTelefono);
        Bundle parametros = getIntent().getExtras();

        if ((parametros==null) ^ (parametros.containsKey("Usuario"))){
            user = (Usuario) parametros.getSerializable("Usuario");
            txtNombreUser.setText(user.getNombre());
            txtEmail.setText(user.getEmail());
            txtTelefono.setText(user.getTelefono());
        }

        btnLista.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               List<Usuario> usuarios = userdb.buscar();
               for (Usuario u: usuarios){
                   Log.i("ListUusuarios", u.toString());
               }
            }

        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (user==null){
                        user = new Usuario();
                    }
                    String userName = txtNombreUser.getText().toString();
                    String userEmail = txtEmail.getText().toString();
                    String userPhone = txtTelefono.getText().toString();
                    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                    Matcher matcher = pattern.matcher(userEmail);

                        if (matcher.find() ^ (userPhone.length() > 9 ^ userPhone.length()<11)) { //Se evalúa si el correo tiene un patrón válido y si el numero de telefono es valido.
                            user.setNombre(txtNombreUser.getText().toString());
                            user.setEmail(txtEmail.getText().toString());
                            user.setTelefono(txtTelefono.getText().toString());
                            user.setTipoDeUsuario(TipoUsuario.CLIENTE);
                            Log.i(LOG_T, user.toString());
                            userdb.guardar(user);
                            Toast.makeText(RegistroUsuario.this, "El registro se ha completado de forma exitosa.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(RegistroUsuario.this, "Correo o numero de telefono erroneo.", Toast.LENGTH_SHORT).show();
                        }



                } catch (Exception e) {
                    Toast.makeText(RegistroUsuario.this, "Hubo una excepción, contacte con el desarrollador. " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
