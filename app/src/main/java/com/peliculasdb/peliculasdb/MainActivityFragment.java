package com.peliculasdb.peliculasdb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.peliculasdb.peliculasdb.json.Result;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    SharedPreferences preferences;
    private ArrayList<Result> items;
    private PeliculasDBAdapter adapter;
    private GridView gVMain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    public void onStart()
    {
        super.onStart();
        gVMain.setOnScrollListener(new EndlessScrollListener(1,1) {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                refresh(page);
                return false;
            }
        });
        refresh(1);
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
        if (id == R.id.action_populares) {
            preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            SharedPreferences.Editor spe = preferences.edit();
            spe.putString("listaPeliculas", "0");
            spe.apply();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Populares");
            adapter.clear();
            refresh(1);
            return true;
        }
        if (id == R.id.action_most_rated) {
            preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            SharedPreferences.Editor spe = preferences.edit();
            spe.putString("listaPeliculas", "1");
            spe.apply();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Mejor Valoradas");
            adapter.clear();
            refresh(1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void refresh (int page)
    {
        //El siguiente texto se utiliza para coger las preferencias de la aplicación y poder utilizarlas.
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        PeliculasDBController pdb= new PeliculasDBController();
        if (preferences.getString("listaPeliculas", "0").equals("0"))
        {
            pdb.updatePeliculasDB(adapter, 0, page);
        }
        else if (preferences.getString("listaPeliculas", "0").equals("1"))
        {
            pdb.updatePeliculasDB(adapter, 1, page);
        }
    }
}