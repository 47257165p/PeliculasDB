package com.peliculasdb.peliculasdb.provider.populares;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.peliculasdb.peliculasdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code populares} table.
 */
public class PopularesContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PopularesColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PopularesSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PopularesSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PopularesContentValues putMovieTitle(@Nullable String value) {
        mContentValues.put(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesContentValues putMovieTitleNull() {
        mContentValues.putNull(PopularesColumns.MOVIE_TITLE);
        return this;
    }

    public PopularesContentValues putMovieDescription(@Nullable String value) {
        mContentValues.put(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesContentValues putMovieDescriptionNull() {
        mContentValues.putNull(PopularesColumns.MOVIE_DESCRIPTION);
        return this;
    }

    public PopularesContentValues putMovieRelease(@Nullable String value) {
        mContentValues.put(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesContentValues putMovieReleaseNull() {
        mContentValues.putNull(PopularesColumns.MOVIE_RELEASE);
        return this;
    }

    public PopularesContentValues putMoviePosterpath(@Nullable String value) {
        mContentValues.put(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesContentValues putMoviePosterpathNull() {
        mContentValues.putNull(PopularesColumns.MOVIE_POSTERPATH);
        return this;
    }

    public PopularesContentValues putMoviePopularity(@Nullable String value) {
        mContentValues.put(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesContentValues putMoviePopularityNull() {
        mContentValues.putNull(PopularesColumns.MOVIE_POPULARITY);
        return this;
    }
}
