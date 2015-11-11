package com.peliculasdb.peliculasdb;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.peliculasdb.peliculasdb.json.Result;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment2 = inflater.inflate(R.layout.fragment_detail, container, false);
        Result pelicula = (Result) getActivity().getIntent().getExtras().get("pelicula");

        //Refereniamos los datos con el layout
        detailTitulo = (TextView) fragment2.findViewById(R.id.detailTitulo);
        detailPuntuacion = (TextView) fragment2.findViewById(R.id.detailPuntuacion);
        detailFecha = (TextView) fragment2.findViewById(R.id.detailFecha);
        detailDescripcion = (TextView) fragment2.findViewById(R.id.detailDescripcion);
        detailPoster = (ImageView) fragment2.findViewById(R.id.detailPoster);

        //utilizamos el objeto Result que habíamos enviado para extraer la información que queremos
        detailTitulo.setText("Título"+"\n"+pelicula.getTitle());
        detailPuntuacion.setText("Puntuación"+"\n"+ new DecimalFormat("#.##").format(pelicula.getPopularity()).toString()+"%");
        detailFecha.setText("Estreno"+"\n"+pelicula.getReleaseDate());
        detailDescripcion.setText("Descripción"+"\n"+pelicula.getOverview());

        //Finalmente utilizamos picasso para recuperar la información de los posters a través de la URL arriba definida.
        Picasso.with(getContext()).load(POSTER_BASE_URL + POSTER_SIZE_URL + pelicula.getPosterPath()).fit().into(detailPoster);

        return fragment2;
    }
}
