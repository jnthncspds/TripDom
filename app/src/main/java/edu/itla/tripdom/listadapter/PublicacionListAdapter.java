package edu.itla.tripdom.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Publicacion;

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
        return null;
    }
}
