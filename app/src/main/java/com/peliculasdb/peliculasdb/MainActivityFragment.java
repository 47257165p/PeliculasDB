package com.peliculasdb.peliculasdb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.peliculasdb.peliculasdb.json.Result;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import retrofit.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    private ArrayList<Result> items;
    private PeliculasDBAdapter adapter;
    private GridView gVMain;
    final String APIKEY = "4edd4e0c15c3af85bfd477a502187a00";
    //FULL LINK POPULARS    http://api.themoviedb.org/3/movie/popular?api_key=4edd4e0c15c3af85bfd477a502187a00

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    public void onStart()
    {
        super.onStart();
        //refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creación de la vista del fragment.
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Sincronizando la listView mediante el fragment.
        gVMain = (GridView) rootView.findViewById(R.id.gVMain);


        //Insserción del String anterior dentro del ArrayList de items
        items = new ArrayList(Arrays.asList());

        //Creación del adapter mediante el ArrayList de items
        adapter = new PeliculasDBAdapter(getContext(), 0, items);
        //Al listView se le pasa el adapter cuyo contenido es el arrayList de items.
        gVMain.setAdapter(adapter);


        //A continuación tenemos un método que, al clicar en un objeto del Listview, nos abre una nueva activity que nos muestra dos detalles
        gVMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                //Creamos un objeto de tipo Result para poder pasárselo como información extra a la activity
                Result pelicula = (Result) parent.getItemAtPosition(position);
                Intent detail = new Intent(getContext(), DetailActivity.class);
                detail.putExtra("pelicula", pelicula);
                startActivity(detail);
            }
        });

        //Finalmente se hace un return del rootview para la actualización de la actividad.
        return rootView;

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            adapter.clear();
            //refresh();
            return true;
        }
        /*if (id == R.id.action_populares) {
            SharedPreferences.Editor spe = preferences.edit();
            spe.putInt("listaPeliculas", 0);
            spe.commit();
            adapter.clear();
            refresh();
            return true;
        }
        if (id == R.id.action_most_rated) {
            SharedPreferences.Editor spe = preferences.edit();
            spe.putInt("listaPeliculas", 1);
            spe.commit();
            adapter.clear();
            refresh();
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }
/*
    public void refresh ()
    {
        //El siguiente texto se utiliza para coger las preferencias de la aplicación y poder utilizarlas.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        PeliculasDBController pdb= new PeliculasDBController();
        if (preferences.getString("listaPeliculas", "0").equals("0"))
        {
            pdb.updatePeliculasDB(adapter, 0);
        }
        else if (preferences.getString("listaPeliculas", "0").equals("1"))
        {
            pdb.updatePeliculasDB(adapter, 1);
        }
    }
    */
}
