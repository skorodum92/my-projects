package com.example.dmitriy.businesscard.provider;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Dmitriy on 06.07.2015.
 */
public class ContactsTable implements BaseColumns {

    public static String AUTHORITY = "com.example.dmitriy.businesscard.provider.BusinessCardContentProvider";

    public static String TABLE_NAME = "contacts";

    public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    public static String COLUMN_NAME = "name";
    public static String COLUMN_PHONE = "phone";

}
