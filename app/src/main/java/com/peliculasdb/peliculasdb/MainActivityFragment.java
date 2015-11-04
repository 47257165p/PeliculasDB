package com.peliculasdb.peliculasdb;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    private ArrayList items;
    private ArrayAdapter <String> adapter;
    private ListView lv1;
    final String APIKEY = "4edd4e0c15c3af85bfd477a502187a00";
    //FULL LINK POPULARS    http://api.themoviedb.org/3/movie/popular?api_key=4edd4e0c15c3af85bfd477a502187a00

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creación de la vista del fragment.
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Sincronizando la listView mediante el fragment.
        lv1 = (ListView) rootView.findViewById(R.id.lv1);

        String [] defecto = {"Película por defecto 1", "Película por defecto 2", "Película por defecto 3", "Película por defecto 4", "Película por defecto 5", "Película por defecto 6"};

        //Insserción del String anterior dentro del ArrayList de items
        items = new ArrayList(Arrays.asList(defecto));

        //Creación del adapter mediante el ArrayList de items
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);

        //Al listView se le pasa el adapter cuyo contenido es el arrayList de items.
        lv1.setAdapter(adapter);

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
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void refresh ()
    {

    }
}
