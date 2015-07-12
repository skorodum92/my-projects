package com.example.dmitriy.businesscard.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Dmitriy on 06.07.2015.
 */
public class BusinessCardContentProvider extends ContentProvider {

    private BusinessCardDbHelper m_Helper;

    @Override
    public boolean onCreate() {
        m_Helper = new BusinessCardDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = m_Helper.getReadableDatabase();

        Cursor cursor = db.query(ContactsTable.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = m_Helper.getWritableDatabase();

        db.insert(ContactsTable.TABLE_NAME, null, values);

        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
