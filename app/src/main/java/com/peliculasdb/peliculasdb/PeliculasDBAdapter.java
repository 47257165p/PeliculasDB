package com.peliculasdb.peliculasdb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.peliculasdb.peliculasdb.json.Result;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by 47257165p on 09/11/15.
 */
public class PeliculasDBAdapter extends ArrayAdapter<Result> {


    //La siguiente URL es la url en la que se encuentran los posters de las películas que queremos, cuyo path extraeremos de la clase Result.
    final String POSTER_BASE_URL="http://image.tmdb.org/t/p/";
    final String POSTER_SIZE_URL="w185";
    public PeliculasDBAdapter(Context context, int resource, List<Result> objects) {
        super(context, resource, objects);
    }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Creamos un adapter en el que definimos la información que queremos añadir en cada posición del listView
            Result pelicula = getItem(position);
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.gridview_item_layout, parent, false);
            }

            //El siguiente texto se encarga de utilizar el layout de listView_item_layout para utilizar ese formato a la hora de enseñar las imágenes
            TextView tVGrid = (TextView) convertView.findViewById(R.id.tVGrid);
            ImageView iVGrid = (ImageView) convertView.findViewById(R.id.iVGrid);

            tVGrid.setText(pelicula.getTitle());

            //Piscasso se encarga de extraer las imágenes de la página
            Picasso.with(getContext()).load(POSTER_BASE_URL+POSTER_SIZE_URL+pelicula.getPosterPath()).fit().into(iVGrid);
            return convertView;
        }

}
