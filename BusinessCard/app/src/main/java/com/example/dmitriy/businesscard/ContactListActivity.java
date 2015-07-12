package com.example.dmitriy.businesscard;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.dmitriy.businesscard.provider.ContactsTable;


public class ContactListActivity extends ActionBarActivity {

    private ListView m_ContacsListView;

    private Cursor m_Cursor;

    private SimpleCursorAdapter m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        m_ContacsListView = (ListView) findViewById(R.id.contactsListView);

        m_Cursor = getContentResolver().query(ContactsTable.CONTENT_URI, null, null, null, null);

        String[] from = {ContactsTable.COLUMN_NAME, ContactsTable.COLUMN_PHONE};
        int[] to = {R.id.tvContactName, R.id.tvContactPhone};

        m_Adapter = new SimpleCursorAdapter(this, R.layout.contacts_list_item, m_Cursor, from, to, 0);

        m_ContacsListView.setAdapter(m_Adapter);

        Button bAddContact = (Button) findViewById(R.id.bAddContact);
        bAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddContactActivity.class));
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        m_Cursor = getContentResolver().query(ContactsTable.CONTENT_URI, null, null, null, null);

        m_Adapter.changeCursor(m_Cursor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
