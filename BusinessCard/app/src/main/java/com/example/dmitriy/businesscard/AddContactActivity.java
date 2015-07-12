package com.example.dmitriy.businesscard;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.example.dmitriy.businesscard.provider.ContactsTable;

/**
 * Created by Dmitriy on 06.07.2015.
 */
public class AddContactActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_layout);

    }

    public void acceptContact(View sender) {

        String name = ((EditText) findViewById(R.id.et_name)).getText().toString();

        String phone = ((EditText) findViewById(R.id.et_phone)).getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(ContactsTable.COLUMN_NAME, name);
        cv.put(ContactsTable.COLUMN_PHONE, phone);

        getContentResolver().insert(ContactsTable.CONTENT_URI, cv);

        finish();
    }
}

