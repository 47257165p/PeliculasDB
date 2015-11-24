package com.peliculasdb.peliculasdb;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;
import com.squareup.picasso.Picasso;

/**
 * Created by 47257165p on 09/11/15.
 */
public class PeliculasDBAdapter extends SimpleCursorAdapter {


    //La siguiente URL es la url en la que se encuentran los posters de las películas que queremos, cuyo path extraeremos de la clase Result.
    final String POSTER_BASE_URL="http://image.tmdb.org/t/p/";
    final String POSTER_SIZE_URL="w185";
    final Context context;
    String from[];


    public String[] getFrom() {
        return from;
    }

    public void setFrom(String[] from) {
        this.from = from;
    }

    public PeliculasDBAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {

        super(context, layout, c, from, to, flags);
        this.from=from;
        this.context = context;
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Cursor movies = getCursor();
            movies.moveToPosition(position);
            //Creamos un adapter en el que definimos la información que queremos añadir en cada posición del listView
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.gridview_item_layout, parent, false);
            }

            //El siguiente texto se encarga de utilizar el layout de listView_item_layout para utilizar ese formato a la hora de enseñar las imágenes
            TextView tVGrid = (TextView) convertView.findViewById(R.id.tVGrid);
            ImageView iVGrid = (ImageView) convertView.findViewById(R.id.iVGrid);

            tVGrid.setText(movies.getString(movies.getColumnIndex(from[0])));

            //Piscasso se encarga de extraer las imágenes de la página
            Picasso.with(context).load(POSTER_BASE_URL+POSTER_SIZE_URL+movies.getString(movies.getColumnIndex(from[1]))).fit().into(iVGrid);
            return convertView;
        }

}
