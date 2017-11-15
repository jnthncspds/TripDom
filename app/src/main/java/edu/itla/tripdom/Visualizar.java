package edu.itla.tripdom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Visualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        Bundle parametros = getIntent().getExtras();
        TextView texto = findViewById(R.id.txtname);
        texto.setText(parametros.getString("Joao"));
    }
}
