package com.peliculasdb.peliculasdb.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.peliculasdb.peliculasdb.BuildConfig;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasColumns;
import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;

public class MovieSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = MovieSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "movie.db";
    private static final int DATABASE_VERSION = 1;
    private static MovieSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final MovieSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_MEJORVALORADAS = "CREATE TABLE IF NOT EXISTS "
            + MejorvaloradasColumns.TABLE_NAME + " ( "
            + MejorvaloradasColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MejorvaloradasColumns.MOVIE_TITLE + " TEXT, "
            + MejorvaloradasColumns.MOVIE_DESCRIPTION + " TEXT, "
            + MejorvaloradasColumns.MOVIE_RELEASE + " TEXT, "
            + MejorvaloradasColumns.MOVIE_POSTERPATH + " TEXT, "
            + MejorvaloradasColumns.MOVIE_POPULARITY + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_POPULARES = "CREATE TABLE IF NOT EXISTS "
            + PopularesColumns.TABLE_NAME + " ( "
            + PopularesColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PopularesColumns.MOVIE_TITLE + " TEXT, "
            + PopularesColumns.MOVIE_DESCRIPTION + " TEXT, "
            + PopularesColumns.MOVIE_RELEASE + " TEXT, "
            + PopularesColumns.MOVIE_POSTERPATH + " TEXT, "
            + PopularesColumns.MOVIE_POPULARITY + " TEXT "
            + " );";

    // @formatter:on

    public static MovieSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static MovieSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static MovieSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new MovieSQLiteOpenHelper(context);
    }

    private MovieSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new MovieSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static MovieSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new MovieSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private MovieSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new MovieSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_MEJORVALORADAS);
        db.execSQL(SQL_CREATE_TABLE_POPULARES);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
