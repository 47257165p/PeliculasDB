package com.peliculasdb.peliculasdb.provider.mejorvaloradas;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.peliculasdb.peliculasdb.provider.base.AbstractSelection;

/**
 * Selection for the {@code mejorvaloradas} table.
 */
public class MejorvaloradasSelection extends AbstractSelection<MejorvaloradasSelection> {
    @Override
    protected Uri baseUri() {
        return MejorvaloradasColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MejorvaloradasCursor} object, which is positioned before the first entry, or null.
     */
    public MejorvaloradasCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MejorvaloradasCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MejorvaloradasCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MejorvaloradasCursor} object, which is positioned before the first entry, or null.
     */
    public MejorvaloradasCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MejorvaloradasCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MejorvaloradasCursor query(Context context) {
        return query(context, null);
    }


    public MejorvaloradasSelection id(long... value) {
        addEquals("mejorvaloradas." + MejorvaloradasColumns._ID, toObjectArray(value));
        return this;
    }

    public MejorvaloradasSelection idNot(long... value) {
        addNotEquals("mejorvaloradas." + MejorvaloradasColumns._ID, toObjectArray(value));
        return this;
    }

    public MejorvaloradasSelection orderById(boolean desc) {
        orderBy("mejorvaloradas." + MejorvaloradasColumns._ID, desc);
        return this;
    }

    public MejorvaloradasSelection orderById() {
        return orderById(false);
    }

    public MejorvaloradasSelection movieTitle(String... value) {
        addEquals(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasSelection movieTitleNot(String... value) {
        addNotEquals(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasSelection movieTitleLike(String... value) {
        addLike(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasSelection movieTitleContains(String... value) {
        addContains(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasSelection movieTitleStartsWith(String... value) {
        addStartsWith(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasSelection movieTitleEndsWith(String... value) {
        addEndsWith(MejorvaloradasColumns.MOVIE_TITLE, value);
        return this;
    }

    public MejorvaloradasSelection orderByMovieTitle(boolean desc) {
        orderBy(MejorvaloradasColumns.MOVIE_TITLE, desc);
        return this;
    }

    public MejorvaloradasSelection orderByMovieTitle() {
        orderBy(MejorvaloradasColumns.MOVIE_TITLE, false);
        return this;
    }

    public MejorvaloradasSelection movieDescription(String... value) {
        addEquals(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasSelection movieDescriptionNot(String... value) {
        addNotEquals(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasSelection movieDescriptionLike(String... value) {
        addLike(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasSelection movieDescriptionContains(String... value) {
        addContains(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasSelection movieDescriptionStartsWith(String... value) {
        addStartsWith(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasSelection movieDescriptionEndsWith(String... value) {
        addEndsWith(MejorvaloradasColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MejorvaloradasSelection orderByMovieDescription(boolean desc) {
        orderBy(MejorvaloradasColumns.MOVIE_DESCRIPTION, desc);
        return this;
    }

    public MejorvaloradasSelection orderByMovieDescription() {
        orderBy(MejorvaloradasColumns.MOVIE_DESCRIPTION, false);
        return this;
    }

    public MejorvaloradasSelection movieRelease(String... value) {
        addEquals(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasSelection movieReleaseNot(String... value) {
        addNotEquals(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasSelection movieReleaseLike(String... value) {
        addLike(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasSelection movieReleaseContains(String... value) {
        addContains(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasSelection movieReleaseStartsWith(String... value) {
        addStartsWith(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasSelection movieReleaseEndsWith(String... value) {
        addEndsWith(MejorvaloradasColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MejorvaloradasSelection orderByMovieRelease(boolean desc) {
        orderBy(MejorvaloradasColumns.MOVIE_RELEASE, desc);
        return this;
    }

    public MejorvaloradasSelection orderByMovieRelease() {
        orderBy(MejorvaloradasColumns.MOVIE_RELEASE, false);
        return this;
    }

    public MejorvaloradasSelection moviePosterpath(String... value) {
        addEquals(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasSelection moviePosterpathNot(String... value) {
        addNotEquals(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasSelection moviePosterpathLike(String... value) {
        addLike(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasSelection moviePosterpathContains(String... value) {
        addContains(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasSelection moviePosterpathStartsWith(String... value) {
        addStartsWith(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasSelection moviePosterpathEndsWith(String... value) {
        addEndsWith(MejorvaloradasColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MejorvaloradasSelection orderByMoviePosterpath(boolean desc) {
        orderBy(MejorvaloradasColumns.MOVIE_POSTERPATH, desc);
        return this;
    }

    public MejorvaloradasSelection orderByMoviePosterpath() {
        orderBy(MejorvaloradasColumns.MOVIE_POSTERPATH, false);
        return this;
    }

    public MejorvaloradasSelection moviePopularity(String... value) {
        addEquals(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasSelection moviePopularityNot(String... value) {
        addNotEquals(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasSelection moviePopularityLike(String... value) {
        addLike(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasSelection moviePopularityContains(String... value) {
        addContains(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasSelection moviePopularityStartsWith(String... value) {
        addStartsWith(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasSelection moviePopularityEndsWith(String... value) {
        addEndsWith(MejorvaloradasColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MejorvaloradasSelection orderByMoviePopularity(boolean desc) {
        orderBy(MejorvaloradasColumns.MOVIE_POPULARITY, desc);
        return this;
    }

    public MejorvaloradasSelection orderByMoviePopularity() {
        orderBy(MejorvaloradasColumns.MOVIE_POPULARITY, false);
        return this;
    }
}
