package com.peliculasdb.peliculasdb;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import com.peliculasdb.peliculasdb.json.ApiResult;
import com.peliculasdb.peliculasdb.json.Result;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasColumns;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasContentValues;
import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;
import com.peliculasdb.peliculasdb.provider.populares.PopularesContentValues;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
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

        Call<ApiResult> call;
        call = service.peliculasValoradas(API_KEY, page);

        call.enqueue(new Callback<ApiResult>() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            //En caso de recibir respuesta nos hará el siguiente método
            public void onResponse(Response<ApiResult> response, Retrofit retrofit) {

                //Imoprtante. En caso de recibir respuesta, el succés nos comprobará que haya sido una respuesta válida
                if (response.isSuccess()) {
                    ApiResult result = response.body();

                    for (int i = 0; i < result.getResults().size(); i++) {
                        MejorvaloradasContentValues valuesValoradas = new MejorvaloradasContentValues();
                        valuesValoradas.putMovieTitle(result.getResults().get(i).getTitle());
                        valuesValoradas.putMovieDescription(result.getResults().get(i).getOverview());
                        valuesValoradas.putMovieRelease(result.getResults().get(i).getReleaseDate());
                        valuesValoradas.putMoviePosterpath(result.getResults().get(i).getPosterPath());
                        valuesValoradas.putMoviePopularity(String.valueOf(result.getResults().get(i).getPopularity()));
                        context.getContentResolver().insert(MejorvaloradasColumns.CONTENT_URI, valuesValoradas.values());
                    }
                } else {
                    try {
                        Log.e("Retrofit", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            //En caso de fallar la llamada por cualquier motivo (falta de internet, permisos, etc) nos ejecutará el siguiente método
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        call = service.peliculasPopulares(API_KEY, page);

        call.enqueue(new Callback<ApiResult>() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            //En caso de recibir respuesta nos hará el siguiente método
            public void onResponse(Response<ApiResult> response, Retrofit retrofit) {

                //Imoprtante. En caso de recibir respuesta, el succés nos comprobará que haya sido una respuesta válida
                if (response.isSuccess()) {
                    ApiResult result = response.body();

                    for (int i = 0; i < result.getResults().size(); i++) {
                        PopularesContentValues valuesPopulares = new PopularesContentValues();
                        valuesPopulares.putMovieTitle(result.getResults().get(i).getTitle());
                        valuesPopulares.putMovieDescription(result.getResults().get(i).getOverview());
                        valuesPopulares.putMovieRelease(result.getResults().get(i).getReleaseDate());
                        valuesPopulares.putMoviePosterpath(result.getResults().get(i).getPosterPath());
                        valuesPopulares.putMoviePopularity(String.valueOf(result.getResults().get(i).getPopularity()));
                        context.getContentResolver().insert(PopularesColumns.CONTENT_URI, valuesPopulares.values());
                    }
                } else {
                    try {
                        Log.e("Retrofit", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            //En caso de fallar la llamada por cualquier motivo (falta de internet, permisos, etc) nos ejecutará el siguiente método
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
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

            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}