package com.peliculasdb.peliculasdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.peliculasdb.peliculasdb.json.Result;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {

    TextView detailTitulo;
    TextView detailPuntuacion;
    TextView detailFecha;
    TextView detailDescripcion;
    ImageView detailPoster;
    final String POSTER_BASE_URL="http://image.tmdb.org/t/p/";
    final String POSTER_SIZE_URL="w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Result pelicula = (Result) getIntent().getExtras().get("pelicula");

        //Refereniamos los datos con el layout
        detailTitulo = (TextView) findViewById(R.id.detailTitulo);
        detailPuntuacion = (TextView) findViewById(R.id.detailPuntuacion);
        detailFecha = (TextView) findViewById(R.id.detailFecha);
        detailDescripcion = (TextView) findViewById(R.id.detailDescripcion);
        detailPoster = (ImageView) findViewById(R.id.detailPoster);

        //utilizamos el objeto Result que habíamos enviado para extraer la información que queremos
        detailTitulo.setText("Título"+"\n"+pelicula.getTitle());
        detailPuntuacion.setText("Puntuación"+"\n"+ new DecimalFormat("#.##").format(pelicula.getPopularity()).toString()+"%");
        detailFecha.setText("Estreno"+"\n"+pelicula.getReleaseDate());
        detailDescripcion.setText("Descripción"+"\n"+pelicula.getOverview());

        //Finalmente utilizamos picasso para recuperar la información de los posters a través de la URL arriba definida.
        Picasso.with(this).load(POSTER_BASE_URL + POSTER_SIZE_URL + pelicula.getPosterPath()).fit().into(detailPoster);
    }
}
