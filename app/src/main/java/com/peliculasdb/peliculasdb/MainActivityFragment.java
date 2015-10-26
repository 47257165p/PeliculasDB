package com.peliculasdb.peliculasdb;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    private ArrayList items;
    private ArrayAdapter <String> adapter;
    private ListView lv1;
    private TextView tv1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        lv1 = (ListView) rootView.findViewById(R.id.lv1);
        tv1 = (TextView) rootView.findViewById(R.id.tv1);

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
