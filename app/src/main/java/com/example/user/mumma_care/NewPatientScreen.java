package com.example.user.mumma_care;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


public class NewPatientScreen extends ActionBarActivity {

    EditText ContactName, ContactAge, ContactMobile, ContactHusband, ContactHMobile,ContactAddress, ContactPregnancy, ContactExpected, ContactDiseases;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient_screen);
        ContactName= (EditText) findViewById(R.id.contact_name);
        ContactAge= (EditText) findViewById(R.id.contact_age);
        ContactMobile=(EditText) findViewById(R.id.contact_mobile);
        ContactHusband=(EditText) findViewById(R.id.contact_husband);
        ContactHMobile= (EditText) findViewById(R.id.contact_h_mobile);
        ContactAddress=(EditText) findViewById(R.id.contact_address);
        ContactPregnancy= (EditText) findViewById(R.id.contact_pregnancy);
        ContactExpected=(EditText) findViewById(R.id.contact_expected);
        ContactDiseases=(EditText) findViewById(R.id.contact_diseases);
    }

    public void addContact (View view)
    {
        String name= ContactName.getText().toString();
        String age= ContactAge.getText().toString();
        String mob= ContactMobile.getText().toString();
        String husband= ContactHusband.getText().toString();
        String hmob= ContactHMobile.getText().toString();
        String address= ContactAddress.getText().toString();
        String preg = ContactPregnancy.getText().toString();
        String expect= ContactExpected.getText().toString();
        String diseases= ContactDiseases.getText().toString();
        userDbHelper= new UserDbHelper(context);
        sqLiteDatabase= userDbHelper.getWritableDatabase();
        userDbHelper.addInformations(name, age, mob, husband, hmob, address, preg, expect, diseases, sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_patient_screen, menu);
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
