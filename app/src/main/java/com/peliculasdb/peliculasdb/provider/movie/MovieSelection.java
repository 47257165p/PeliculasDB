package com.peliculasdb.peliculasdb.provider.movie;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.peliculasdb.peliculasdb.provider.base.AbstractSelection;

/**
 * Selection for the {@code movie} table.
 */
public class MovieSelection extends AbstractSelection<MovieSelection> {
    @Override
    protected Uri baseUri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MovieCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MovieCursor query(Context context) {
        return query(context, null);
    }


    public MovieSelection id(long... value) {
        addEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection idNot(long... value) {
        addNotEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection orderById(boolean desc) {
        orderBy("movie." + MovieColumns._ID, desc);
        return this;
    }

    public MovieSelection orderById() {
        return orderById(false);
    }

    public MovieSelection movieTitle(String... value) {
        addEquals(MovieColumns.MOVIE_TITLE, value);
        return this;
    }

    public MovieSelection movieTitleNot(String... value) {
        addNotEquals(MovieColumns.MOVIE_TITLE, value);
        return this;
    }

    public MovieSelection movieTitleLike(String... value) {
        addLike(MovieColumns.MOVIE_TITLE, value);
        return this;
    }

    public MovieSelection movieTitleContains(String... value) {
        addContains(MovieColumns.MOVIE_TITLE, value);
        return this;
    }

    public MovieSelection movieTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.MOVIE_TITLE, value);
        return this;
    }

    public MovieSelection movieTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.MOVIE_TITLE, value);
        return this;
    }

    public MovieSelection orderByMovieTitle(boolean desc) {
        orderBy(MovieColumns.MOVIE_TITLE, desc);
        return this;
    }

    public MovieSelection orderByMovieTitle() {
        orderBy(MovieColumns.MOVIE_TITLE, false);
        return this;
    }

    public MovieSelection movieDescription(String... value) {
        addEquals(MovieColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MovieSelection movieDescriptionNot(String... value) {
        addNotEquals(MovieColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MovieSelection movieDescriptionLike(String... value) {
        addLike(MovieColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MovieSelection movieDescriptionContains(String... value) {
        addContains(MovieColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MovieSelection movieDescriptionStartsWith(String... value) {
        addStartsWith(MovieColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MovieSelection movieDescriptionEndsWith(String... value) {
        addEndsWith(MovieColumns.MOVIE_DESCRIPTION, value);
        return this;
    }

    public MovieSelection orderByMovieDescription(boolean desc) {
        orderBy(MovieColumns.MOVIE_DESCRIPTION, desc);
        return this;
    }

    public MovieSelection orderByMovieDescription() {
        orderBy(MovieColumns.MOVIE_DESCRIPTION, false);
        return this;
    }

    public MovieSelection movieRelease(String... value) {
        addEquals(MovieColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MovieSelection movieReleaseNot(String... value) {
        addNotEquals(MovieColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MovieSelection movieReleaseLike(String... value) {
        addLike(MovieColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MovieSelection movieReleaseContains(String... value) {
        addContains(MovieColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MovieSelection movieReleaseStartsWith(String... value) {
        addStartsWith(MovieColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MovieSelection movieReleaseEndsWith(String... value) {
        addEndsWith(MovieColumns.MOVIE_RELEASE, value);
        return this;
    }

    public MovieSelection orderByMovieRelease(boolean desc) {
        orderBy(MovieColumns.MOVIE_RELEASE, desc);
        return this;
    }

    public MovieSelection orderByMovieRelease() {
        orderBy(MovieColumns.MOVIE_RELEASE, false);
        return this;
    }

    public MovieSelection moviePosterpath(String... value) {
        addEquals(MovieColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MovieSelection moviePosterpathNot(String... value) {
        addNotEquals(MovieColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MovieSelection moviePosterpathLike(String... value) {
        addLike(MovieColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MovieSelection moviePosterpathContains(String... value) {
        addContains(MovieColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MovieSelection moviePosterpathStartsWith(String... value) {
        addStartsWith(MovieColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MovieSelection moviePosterpathEndsWith(String... value) {
        addEndsWith(MovieColumns.MOVIE_POSTERPATH, value);
        return this;
    }

    public MovieSelection orderByMoviePosterpath(boolean desc) {
        orderBy(MovieColumns.MOVIE_POSTERPATH, desc);
        return this;
    }

    public MovieSelection orderByMoviePosterpath() {
        orderBy(MovieColumns.MOVIE_POSTERPATH, false);
        return this;
    }

    public MovieSelection moviePopularity(String... value) {
        addEquals(MovieColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MovieSelection moviePopularityNot(String... value) {
        addNotEquals(MovieColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MovieSelection moviePopularityLike(String... value) {
        addLike(MovieColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MovieSelection moviePopularityContains(String... value) {
        addContains(MovieColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MovieSelection moviePopularityStartsWith(String... value) {
        addStartsWith(MovieColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MovieSelection moviePopularityEndsWith(String... value) {
        addEndsWith(MovieColumns.MOVIE_POPULARITY, value);
        return this;
    }

    public MovieSelection orderByMoviePopularity(boolean desc) {
        orderBy(MovieColumns.MOVIE_POPULARITY, desc);
        return this;
    }

    public MovieSelection orderByMoviePopularity() {
        orderBy(MovieColumns.MOVIE_POPULARITY, false);
        return this;
    }
}
