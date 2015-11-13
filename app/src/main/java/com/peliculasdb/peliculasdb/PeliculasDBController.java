package com.peliculasdb.peliculasdb;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.peliculasdb.peliculasdb.json.ApiResult;
import com.peliculasdb.peliculasdb.json.Result;

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

public class PeliculasDBController {

    //Atributos necesarios para este objeto
    private final PeliculasDBService service;
    private final String MOVIES_BASE_URL = "http://api.themoviedb.org/3/movie/";
    private final String API_KEY = "4edd4e0c15c3af85bfd477a502187a00";
    private int PAGE=1;


    //Objeto que nos crea el retrofit con la URL base y llama al a interfaz para rellenar con las preferencias deseadas.
    public PeliculasDBController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MOVIES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PeliculasDBService.class);
    }

    //Según la opción introducida nos crea un servicio de películas populares o un servicio de películas más valoradas
    public void updatePeliculasDB(final ArrayAdapter<Result> adapter, final int opcion) {

        Call<ApiResult> call;

        switch (opcion)
        {
            case 0:
                call = service.peliculasPopulares(API_KEY, PAGE);
                break;
            case 1:
                call = service.peliculasValoradas(API_KEY, PAGE);
                break;
            default:
                call = service.peliculasPopulares(API_KEY, PAGE);
                break;
        }
        call.enqueue(new Callback<ApiResult>() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override

            //En caso de recibir respuesta nos hará el siguiente método
            public void onResponse(Response<ApiResult> response, Retrofit retrofit) {

                //Imoprtante. En caso de recibir respuesta, el succés nos comprobará que haya sido una respuesta válida
                if (response.isSuccess()){
                    ApiResult result = response.body();
                    adapter.addAll(result.getResults());
                    if (PAGE<3)
                    {
                        PAGE++;
                        updatePeliculasDB(adapter, opcion);
                    }
                }
                else {
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
}