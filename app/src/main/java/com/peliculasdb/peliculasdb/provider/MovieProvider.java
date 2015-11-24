package com.peliculasdb.peliculasdb.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.peliculasdb.peliculasdb.BuildConfig;
import com.peliculasdb.peliculasdb.provider.base.BaseContentProvider;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasColumns;
import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;

public class MovieProvider extends BaseContentProvider {
    private static final String TAG = MovieProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "com.peliculasdb.peliculasdb.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_MEJORVALORADAS = 0;
    private static final int URI_TYPE_MEJORVALORADAS_ID = 1;

    private static final int URI_TYPE_POPULARES = 2;
    private static final int URI_TYPE_POPULARES_ID = 3;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, MejorvaloradasColumns.TABLE_NAME, URI_TYPE_MEJORVALORADAS);
        URI_MATCHER.addURI(AUTHORITY, MejorvaloradasColumns.TABLE_NAME + "/#", URI_TYPE_MEJORVALORADAS_ID);
        URI_MATCHER.addURI(AUTHORITY, PopularesColumns.TABLE_NAME, URI_TYPE_POPULARES);
        URI_MATCHER.addURI(AUTHORITY, PopularesColumns.TABLE_NAME + "/#", URI_TYPE_POPULARES_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return MovieSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_MEJORVALORADAS:
                return TYPE_CURSOR_DIR + MejorvaloradasColumns.TABLE_NAME;
            case URI_TYPE_MEJORVALORADAS_ID:
                return TYPE_CURSOR_ITEM + MejorvaloradasColumns.TABLE_NAME;

            case URI_TYPE_POPULARES:
                return TYPE_CURSOR_DIR + PopularesColumns.TABLE_NAME;
            case URI_TYPE_POPULARES_ID:
                return TYPE_CURSOR_ITEM + PopularesColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_MEJORVALORADAS:
            case URI_TYPE_MEJORVALORADAS_ID:
                res.table = MejorvaloradasColumns.TABLE_NAME;
                res.idColumn = MejorvaloradasColumns._ID;
                res.tablesWithJoins = MejorvaloradasColumns.TABLE_NAME;
                res.orderBy = MejorvaloradasColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_POPULARES:
            case URI_TYPE_POPULARES_ID:
                res.table = PopularesColumns.TABLE_NAME;
                res.idColumn = PopularesColumns._ID;
                res.tablesWithJoins = PopularesColumns.TABLE_NAME;
                res.orderBy = PopularesColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_MEJORVALORADAS_ID:
            case URI_TYPE_POPULARES_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "" + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "" + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
