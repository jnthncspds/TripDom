package edu.itla.tripdom.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {
    private static final String LOG_T = "RegistroUsuarioLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        Button btnSave = findViewById(R.id.btnSave );
        final EditText txtNombreUser = findViewById(R.id.txtUser);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtTelefono = findViewById(R.id.txtTelefono);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    Usuario user = new Usuario();
                    String userName = txtNombreUser.getText().toString();
                    String userEmail = txtEmail.getText().toString();
                    String userPhone = txtTelefono.getText().toString();
                    String[] email = null;
                    boolean checkCampos = true;

                    if (userName.equals("") || userEmail.equals("") | userPhone.equals("")) {
                        Toast message = Toast.makeText(RegistroUsuario.this, "Debes llenar los campos.", Toast.LENGTH_SHORT);
                        message.show();
                    } else {
                        if (checkCampos){
                            if (userPhone.length() < 10) {
                                Toast.makeText(RegistroUsuario.this, "Debe de introducir un número de teléfono válido.", Toast.LENGTH_SHORT).show();
                                checkCampos = false;
                            }
                            if ((userEmail.split("@").length > 0 ^ userEmail.split("@").length < 2)) {
                                email = userEmail.split("\\.");
                                if (email[1].contains(".")) {
                                    Toast.makeText(RegistroUsuario.this, "Correo Correcto", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(RegistroUsuario.this, "Correo Inválido, intente de nuevo.", Toast.LENGTH_SHORT).show();
                                checkCampos = false;
                            }
                        }
                        if (checkCampos) {
                            user.setNombre(txtNombreUser.getText().toString());
                            user.setEmail(txtEmail.getText().toString());
                            user.setTelefono(txtTelefono.getText().toString());
                            user.setTipoDeUsuario(TipoUsuario.CLIENTE);
                            Log.i(LOG_T, user.toString());
                            Toast.makeText(RegistroUsuario.this, "El registro se ha completado de forma exitosa.", Toast.LENGTH_SHORT).show();
                        }
                        }



                }
                catch (Exception e){
                    Toast.makeText(RegistroUsuario.this, "Hubo una excepción, contacte con el desarrollador. "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
