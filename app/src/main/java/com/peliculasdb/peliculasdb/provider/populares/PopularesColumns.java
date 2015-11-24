package com.peliculasdb.peliculasdb.provider.populares;

import android.net.Uri;
import android.provider.BaseColumns;

import com.peliculasdb.peliculasdb.provider.MovieProvider;
import com.peliculasdb.peliculasdb.provider.mejorvaloradas.MejorvaloradasColumns;
import com.peliculasdb.peliculasdb.provider.populares.PopularesColumns;

/**
 * Peliculas populares
 */
public class PopularesColumns implements BaseColumns {
    public static final String TABLE_NAME = "populares";
    public static final Uri CONTENT_URI = Uri.parse(MovieProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String MOVIE_TITLE = "movie_Title";

    public static final String MOVIE_DESCRIPTION = "movie_Description";

    public static final String MOVIE_RELEASE = "movie_Release";

    public static final String MOVIE_POSTERPATH = "movie_Posterpath";

    public static final String MOVIE_POPULARITY = "movie_Popularity";


    public static final String DEFAULT_ORDER = TABLE_NAME + "" +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_TITLE,
            MOVIE_DESCRIPTION,
            MOVIE_RELEASE,
            MOVIE_POSTERPATH,
            MOVIE_POPULARITY
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_TITLE) || c.contains("" + MOVIE_TITLE)) return true;
            if (c.equals(MOVIE_DESCRIPTION) || c.contains("" + MOVIE_DESCRIPTION)) return true;
            if (c.equals(MOVIE_RELEASE) || c.contains("" + MOVIE_RELEASE)) return true;
            if (c.equals(MOVIE_POSTERPATH) || c.contains("" + MOVIE_POSTERPATH)) return true;
            if (c.equals(MOVIE_POPULARITY) || c.contains("" + MOVIE_POPULARITY)) return true;
        }
        return false;
    }

}
