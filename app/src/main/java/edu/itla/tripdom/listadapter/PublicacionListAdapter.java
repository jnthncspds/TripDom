package edu.itla.tripdom.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Jonathan on 04/12/2017.
 */

public class PublicacionListAdapter extends BaseAdapter {
    private Activity context;
    private List<Publicacion> pub;

    public PublicacionListAdapter(Activity context, List<Publicacion> pub) {
        this.context = context;
        this.pub = pub;
    }



    @Override
    public int getCount() {
        return pub.size();
    }

    @Override
    public Object getItem(int i) {
        return pub.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.activity_lista_publicacion_row, null, true);
        }
        TextView lvNombre = view.findViewById(R.id.lvNombre);
        TextView lvCosto = view.findViewById(R.id.lvCosto);
        TextView lvDescripcion = view.findViewById(R.id.lvDescripcion);
        TextView lvEstado = view.findViewById(R.id.lvEstado);
        TextView lvCupo = view.findViewById((R.id.lvCupo));
        Publicacion publicacion = pub.get(i);
        //Usuario u = publicacion.getUser();

        lvNombre.setText(publicacion.getUser().getNombre());
        lvCosto.setText(String.valueOf(publicacion.getCosto()));
        lvDescripcion.setText(publicacion.getDescripcion());
        lvEstado.setText(publicacion.getEstado());
        lvCupo.setText(String.valueOf(publicacion.getCupo()));


        return view;
    }
}
