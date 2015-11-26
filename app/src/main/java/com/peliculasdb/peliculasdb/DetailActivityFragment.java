package com.peliculasdb.peliculasdb;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.peliculasdb.peliculasdb.json.Result;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasColumns;
import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    TextView detailTitulo;
    TextView detailPuntuacion;
    TextView detailFecha;
    TextView detailDescripcion;
    ImageView detailPoster;
    final String POSTER_BASE_URL="http://image.tmdb.org/t/p/";
    final String POSTER_SIZE_URL="w185";

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View detailFragment = inflater.inflate(R.layout.fragment_detail, container, false);
        //Refereniamos los datos con el layout
        detailTitulo = (TextView) detailFragment.findViewById(R.id.detailTitulo);
        detailPuntuacion = (TextView) detailFragment.findViewById(R.id.detailPuntuacion);
        detailFecha = (TextView) detailFragment.findViewById(R.id.detailFecha);
        detailDescripcion = (TextView) detailFragment.findViewById(R.id.detailDescripcion);
        detailPoster = (ImageView) detailFragment.findViewById(R.id.detailPoster);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        long id = getActivity().getIntent().getLongExtra("id", -1);

        if (preferences.getString("listaPeliculas", "0").equals("0"))
        {
            Cursor cursor = getContext().getContentResolver().query(
                    PopularesColumns.CONTENT_URI,
                    null,
                    PopularesColumns._ID + " =?",
                    new String[]{String.valueOf(id)},
                    "_id");
            cursor.moveToNext();
            detailTitulo.setText(cursor.getString(cursor.getColumnIndex(PopularesColumns.MOVIE_TITLE)));
            detailPuntuacion.setText(cursor.getString(cursor.getColumnIndex(PopularesColumns.MOVIE_POPULARITY)));
            detailFecha.setText(cursor.getString(cursor.getColumnIndex(PopularesColumns.MOVIE_RELEASE)));
            detailDescripcion.setText(cursor.getString(cursor.getColumnIndex(PopularesColumns.MOVIE_DESCRIPTION)));
            Picasso.with(getContext()).load(POSTER_BASE_URL + POSTER_SIZE_URL + cursor.getString(cursor.getColumnIndex(PopularesColumns.MOVIE_POSTERPATH))).fit().into(detailPoster);
        }
        else if (preferences.getString("listaPeliculas", "0").equals("1"))
        {
            Cursor cursor = getContext().getContentResolver().query(
                    MejorvaloradasColumns.CONTENT_URI,
                    null,
                    MejorvaloradasColumns._ID + " =?",
                    new String[]{String.valueOf(id)},
                    "_id");
            cursor.moveToNext();
            detailTitulo.setText(cursor.getString(cursor.getColumnIndex(MejorvaloradasColumns.MOVIE_TITLE)));
            detailPuntuacion.setText(cursor.getString(cursor.getColumnIndex(MejorvaloradasColumns.MOVIE_POPULARITY)));
            detailFecha.setText(cursor.getString(cursor.getColumnIndex(MejorvaloradasColumns.MOVIE_RELEASE)));
            detailDescripcion.setText(cursor.getString(cursor.getColumnIndex(MejorvaloradasColumns.MOVIE_DESCRIPTION)));
            Picasso.with(getContext()).load(POSTER_BASE_URL + POSTER_SIZE_URL + cursor.getString(cursor.getColumnIndex(MejorvaloradasColumns.MOVIE_POSTERPATH))).fit().into(detailPoster);
        }
        return detailFragment;
    }
}
