/**
 * Created by Dmitriy on 20.06.2015.
 */

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
public class mybuisnessprovider extends ContentProvider {


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


    static final String AUTHORITY = "ru.startandroid.providers.AdressBook";


    static final String CONTACT_PATH = "contacts";


    public static final Uri CONTACT_CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + CONTACT_PATH);



    static final int URI_CONTACTS = 1;


    static final int URI_CONTACTS_ID = 2;


    DBHelper dbHelper;
    SQLiteDatabase db;

    public boolean onCreate() {
        Log.d(LOG_TAG, "onCreate");
        dbHelper = new DBHelper(getContext());
        return true;
    }


    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d(LOG_TAG, "query, " + uri.toString());
    }

    break;
}