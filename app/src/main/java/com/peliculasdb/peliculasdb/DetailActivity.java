package com.peliculasdb.peliculasdb;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.peliculasdb.peliculasdb.json.Result;

public class DetailActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Result a = (Result) getIntent().getExtras().get("pelicula");
        toolbar.setTitle(a.getTitle());
        setSupportActionBar(toolbar);
    }

}
