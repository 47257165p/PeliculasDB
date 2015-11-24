package com.peliculasdb.peliculasdb.provider.mejorvaloradas;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.peliculasdb.peliculasdb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code mejorvaloradas} table.
 */
public class MejorvaloradasContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MejorvaloradasColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MejorvaloradasSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MejorvaloradasSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MejorvaloradasContentValues putMovieTitle(@Nullable String value) {
        mContentValues.put(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasContentValues putMovieTitleNull() {
        mContentValues.putNull(MejorvaloradasColumns.MOVIE_TITLE);
        return this;
    }

    public MejorvaloradasContentValues putMovieDescription(@Nullable String value) {
        mContentValues.put(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasContentValues putMovieDescriptionNull() {
        mContentValues.putNull(MejorvaloradasColumns.MOVIE_DESCRIPTION);
        return this;
    }

    public MejorvaloradasContentValues putMovieRelease(@Nullable String value) {
        mContentValues.put(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasContentValues putMovieReleaseNull() {
        mContentValues.putNull(MejorvaloradasColumns.MOVIE_RELEASE);
        return this;
    }

    public MejorvaloradasContentValues putMoviePosterpath(@Nullable String value) {
        mContentValues.put(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasContentValues putMoviePosterpathNull() {
        mContentValues.putNull(MejorvaloradasColumns.MOVIE_POSTERPATH);
        return this;
    }

    public MejorvaloradasContentValues putMoviePopularity(@Nullable String value) {
        mContentValues.put(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasContentValues putMoviePopularityNull() {
        mContentValues.putNull(MejorvaloradasColumns.MOVIE_POPULARITY);
        return this;
    }
}
