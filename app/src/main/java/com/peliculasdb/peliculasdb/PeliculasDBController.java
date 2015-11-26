package com.peliculasdb.peliculasdb;

import android.content.Context;
import android.os.AsyncTask;


import com.peliculasdb.peliculasdb.json.ApiResult;
import com.peliculasdb.peliculasdb.json.Result;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasColumns;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasContentValues;
import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;
import com.peliculasdb.peliculasdb.provider.populares.PopularesContentValues;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by 47257165p on 04/11/15.
 */
interface PeliculasDBService {

    @GET("popular")
    Call<ApiResult> peliculasPopulares(
            @Query("api_key") String api_key,
            @Query("page") Integer page);
    @GET("top_rated")
    Call<ApiResult> peliculasValoradas(
            @Query("api_key") String api_key,
            @Query("page") Integer page);
}

public class PeliculasDBController extends AsyncTask {

    //Atributos necesarios para este objeto
    private final PeliculasDBService service;
    private final String MOVIES_BASE_URL = "http://api.themoviedb.org/3/movie/";
    private final String API_KEY = "4edd4e0c15c3af85bfd477a502187a00";
    private final Context context;



    //Objeto que nos crea el retrofit con la URL base y llama al a interfaz para rellenar con las preferencias deseadas.
    public PeliculasDBController(final Context context) {
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MOVIES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PeliculasDBService.class);
    }

    //Según la opción introducida nos crea un servicio de películas populares o un servicio de películas más valoradas
    public void updatePeliculasDB(int page) {
        execute(page);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        int page = (Integer) params[0];
        Call<ApiResult> callPopulares = service.peliculasPopulares(API_KEY, page);
        Call<ApiResult> callValoradas = service.peliculasValoradas(API_KEY, page);

        try {

            Response<ApiResult> responsePopulares = callPopulares.execute();
            Response<ApiResult> responseValoradas = callValoradas.execute();


            if (responsePopulares.isSuccess() && responseValoradas.isSuccess()) {
                ApiResult resultPopulares = responsePopulares.body();
                ApiResult resultValoradas = responseValoradas.body();

                for (Result result : resultPopulares.getResults()) {
                    PopularesContentValues valuesPopulares = new PopularesContentValues();
                    valuesPopulares.putMovieTitle(result.getTitle());
                    valuesPopulares.putMovieDescription(result.getOverview());
                    valuesPopulares.putMovieRelease(result.getReleaseDate());
                    valuesPopulares.putMoviePosterpath(result.getPosterPath());
                    valuesPopulares.putMoviePopularity(String.valueOf(result.getPopularity()));
                    context.getContentResolver().insert(PopularesColumns.CONTENT_URI, valuesPopulares.values());
                }
                for (Result result : resultValoradas.getResults()) {
                    MejorvaloradasContentValues valuesValoradas = new MejorvaloradasContentValues();
                    valuesValoradas.putMovieTitle(result.getTitle());
                    valuesValoradas.putMovieDescription(result.getOverview());
                    valuesValoradas.putMovieRelease(result.getReleaseDate());
                    valuesValoradas.putMoviePosterpath(result.getPosterPath());
                    valuesValoradas.putMoviePopularity(String.valueOf(result.getPopularity()));
                    context.getContentResolver().insert(MejorvaloradasColumns.CONTENT_URI, valuesValoradas.values());
                }
            }
            else
            {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}