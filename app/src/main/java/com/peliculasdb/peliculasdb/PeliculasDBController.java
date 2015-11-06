package com.peliculasdb.peliculasdb;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.peliculasdb.peliculasdb.json.ApiResult;

import java.io.IOException;
import java.util.ArrayList;

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
            @Query("api_key") String api_key);
}

public class PeliculasDBController {

    //Atributos necesarios para este objeto
    private final PeliculasDBService service;
    private final String MOVIES_BASE_URL = "http://api.themoviedb.org/3/movie/";
    private final String API_KEY = "4edd4e0c15c3af85bfd477a502187a00";


    //Objeto que nos crea el retrofit con la URL base y llama al a interfaz para rellenar con las preferencias deseadas.
    public PeliculasDBController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MOVIES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PeliculasDBService.class);
    }

    public void updatePeliculasDBPopulares(final ArrayAdapter<String> adapter) {
        Call<ApiResult> call = service.peliculasPopulares(API_KEY);
        call.enqueue(new Callback<ApiResult>() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onResponse(Response<ApiResult> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    ApiResult result = response.body();
                    ArrayList<String> peliculasStrings = new ArrayList<>();

                    for (int i = 0; i < result.getResults().size(); i++) {
                        peliculasStrings.add(result.getResults().get(i).getTitle());
                    }
                    adapter.addAll(peliculasStrings);
                }
                else {
                    try {
                        Log.e("Retrofit", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
