package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.PublicacionDbo;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.listadapter.PublicacionListAdapter;

public class ListaPublicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_publicacion);


        PublicacionDbo publicacionDbo = new PublicacionDbo(this);

            final ListView listView = findViewById(R.id.lvPub); //Se mapea el listview declarado en el activiti
            List<Publicacion> publicacions = publicacionDbo.buscar(); //Se declara una lista de tipo publicacion y se inicializa con un buscar
            listView.setAdapter(new PublicacionListAdapter(this, publicacions)); //Se muestran los datos por la lista.

    }
}
