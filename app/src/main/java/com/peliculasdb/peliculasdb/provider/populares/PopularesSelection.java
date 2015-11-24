package com.peliculasdb.peliculasdb.provider.populares;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.peliculasdb.peliculasdb.provider.base.AbstractSelection;

/**
 * Selection for the {@code populares} table.
 */
public class PopularesSelection extends AbstractSelection<PopularesSelection> {
    @Override
    protected Uri baseUri() {
        return PopularesColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PopularesCursor} object, which is positioned before the first entry, or null.
     */
    public PopularesCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PopularesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PopularesCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PopularesCursor} object, which is positioned before the first entry, or null.
     */
    public PopularesCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PopularesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PopularesCursor query(Context context) {
        return query(context, null);
    }


    public PopularesSelection id(long... value) {
        addEquals("populares." + PopularesColumns._ID, toObjectArray(value));
        return this;
    }

    public PopularesSelection idNot(long... value) {
        addNotEquals("populares." + PopularesColumns._ID, toObjectArray(value));
        return this;
    }

    public PopularesSelection orderById(boolean desc) {
        orderBy("populares." + PopularesColumns._ID, desc);
        return this;
    }

    public PopularesSelection orderById() {
        return orderById(false);
    }

    public PopularesSelection movieTitle(String... value) {
        addEquals(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesSelection movieTitleNot(String... value) {
        addNotEquals(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesSelection movieTitleLike(String... value) {
        addLike(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesSelection movieTitleContains(String... value) {
        addContains(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesSelection movieTitleStartsWith(String... value) {
        addStartsWith(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesSelection movieTitleEndsWith(String... value) {
        addEndsWith(PopularesColumns.MOVIE_TITLE, value);
        return this;
    }

    public PopularesSelection orderByMovieTitle(boolean desc) {
        orderBy(PopularesColumns.MOVIE_TITLE, desc);
        return this;
    }

    public PopularesSelection orderByMovieTitle() {
        orderBy(PopularesColumns.MOVIE_TITLE, false);
        return this;
    }

    public PopularesSelection movieDescription(String... value) {
        addEquals(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesSelection movieDescriptionNot(String... value) {
        addNotEquals(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesSelection movieDescriptionLike(String... value) {
        addLike(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesSelection movieDescriptionContains(String... value) {
        addContains(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesSelection movieDescriptionStartsWith(String... value) {
        addStartsWith(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesSelection movieDescriptionEndsWith(String... value) {
        addEndsWith(PopularesColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public PopularesSelection orderByMovieDescription(boolean desc) {
        orderBy(PopularesColumns.MOVIE_DESCRIPTION, desc);
        return this;
    }

    public PopularesSelection orderByMovieDescription() {
        orderBy(PopularesColumns.MOVIE_DESCRIPTION, false);
        return this;
    }

    public PopularesSelection movieRelease(String... value) {
        addEquals(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesSelection movieReleaseNot(String... value) {
        addNotEquals(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesSelection movieReleaseLike(String... value) {
        addLike(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesSelection movieReleaseContains(String... value) {
        addContains(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesSelection movieReleaseStartsWith(String... value) {
        addStartsWith(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesSelection movieReleaseEndsWith(String... value) {
        addEndsWith(PopularesColumns.MOVIE_RELEASE, value);
        return this;
    }

    public PopularesSelection orderByMovieRelease(boolean desc) {
        orderBy(PopularesColumns.MOVIE_RELEASE, desc);
        return this;
    }

    public PopularesSelection orderByMovieRelease() {
        orderBy(PopularesColumns.MOVIE_RELEASE, false);
        return this;
    }

    public PopularesSelection moviePosterpath(String... value) {
        addEquals(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesSelection moviePosterpathNot(String... value) {
        addNotEquals(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesSelection moviePosterpathLike(String... value) {
        addLike(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesSelection moviePosterpathContains(String... value) {
        addContains(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesSelection moviePosterpathStartsWith(String... value) {
        addStartsWith(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesSelection moviePosterpathEndsWith(String... value) {
        addEndsWith(PopularesColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public PopularesSelection orderByMoviePosterpath(boolean desc) {
        orderBy(PopularesColumns.MOVIE_POSTERPATH, desc);
        return this;
    }

    public PopularesSelection orderByMoviePosterpath() {
        orderBy(PopularesColumns.MOVIE_POSTERPATH, false);
        return this;
    }

    public PopularesSelection moviePopularity(String... value) {
        addEquals(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesSelection moviePopularityNot(String... value) {
        addNotEquals(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesSelection moviePopularityLike(String... value) {
        addLike(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesSelection moviePopularityContains(String... value) {
        addContains(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesSelection moviePopularityStartsWith(String... value) {
        addStartsWith(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesSelection moviePopularityEndsWith(String... value) {
        addEndsWith(PopularesColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public PopularesSelection orderByMoviePopularity(boolean desc) {
        orderBy(PopularesColumns.MOVIE_POPULARITY, desc);
        return this;
    }

    public PopularesSelection orderByMoviePopularity() {
        orderBy(PopularesColumns.MOVIE_POPULARITY, false);
        return this;
    }
}
