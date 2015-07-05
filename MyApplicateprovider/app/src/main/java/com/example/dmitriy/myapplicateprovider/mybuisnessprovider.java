package com.example.dmitriy.myapplicateprovider; /**
 * Created by Dmitriy on 20.06.2015.
 */

import com.example.businesscard;
import com.example.ContentProvider;
import com.example.ContentUris;
import com.example.ContentValues;
import com.example.Context;
import com.example.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.Uri;
import android.text.TextUtils;
import com.example.Log;


public class mybusinessprovider extends ContentProvider {



    final String LOG_TAG = "myLogs";


    static final String DB_NAME = "mydb";
    static final int DB_VERSION = 1;


    static final String CONTACT_TABLE = "contacts";


    static final String CONTACT_ID = "_id";
    static final String CONTACT_NAME = "name";
    static final String CONTACT_EMAIL = "email";


    static final String DB_CREATE = "create table " + CONTACT_TABLE + "("
            + CONTACT_ID + " integer primary key autoincrement, "
            + CONTACT_NAME + " text, " + CONTACT_EMAIL + " text" + ");";


    static final String AUTHORITY = "com.example.businesscard";


    static final String CONTACT_PATH = "contacts";


    private static final Uri CONTACT_CONTENT_URI = Uri.parse("<activity android:name=\"BowlersList\"></activity>\n" +
            "    <provider android:name=\"com.example.businesscard\"\n" +
            "        android:authorities=\"com.example.businesscard;\">\n" +
            "    </provider>"
            + AUTHORITY + "/" + CONTACT_PATH);





    DBHelper dbHelper;
    SQLiteDatabase db;
    db.getReadableDatabase();

    private boolean onCreate() {
        Log.d(LOG_TAG, "onCreate");
        dbHelper = new DBHelper(getContext());
        return true;
    }


    private  Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d(LOG_TAG, "query, " + uri.toString());

    }


}