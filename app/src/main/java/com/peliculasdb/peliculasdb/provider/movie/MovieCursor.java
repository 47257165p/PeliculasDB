package com.peliculasdb.peliculasdb.provider.movie;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.peliculasdb.peliculasdb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movie} table.
 */
public class MovieCursor extends AbstractCursor implements MovieModel {
    public MovieCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MovieColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code movie_title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieTitle() {
        String res = getStringOrNull(MovieColumns.MOVIE_TITLE);
        return res;
    }

    /**
     * Get the {@code movie_description} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieDescription() {
        String res = getStringOrNull(MovieColumns.MOVIE_DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code movie_release} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMovieRelease() {
        String res = getStringOrNull(MovieColumns.MOVIE_RELEASE);
        return res;
    }

    /**
     * Get the {@code movie_posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMoviePosterpath() {
        String res = getStringOrNull(MovieColumns.MOVIE_POSTERPATH);
        return res;
    }

    /**
     * Get the {@code movie_popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMoviePopularity() {
        String res = getStringOrNull(MovieColumns.MOVIE_POPULARITY);
        return res;
    }
}
