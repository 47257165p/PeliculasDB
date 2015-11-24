package com.peliculasdb.peliculasdb.provider.populares;

import com.peliculasdb.peliculasdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Peliculas populares
 */
public interface PopularesModel extends BaseModel {

    /**
     * Get the {@code movie_title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMovieTitle();

    /**
     * Get the {@code movie_description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMovieDescription();

    /**
     * Get the {@code movie_release} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMovieRelease();

    /**
     * Get the {@code movie_posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMoviePosterpath();

    /**
     * Get the {@code movie_popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMoviePopularity();
}
