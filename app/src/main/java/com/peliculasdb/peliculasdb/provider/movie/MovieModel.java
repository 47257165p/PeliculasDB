package com.peliculasdb.peliculasdb.provider.movie;

import com.peliculasdb.peliculasdb.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A movie table
 */
public interface MovieModel extends BaseModel {

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
