package com.example.user.mumma_care;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;


public class ExistingPatientScreen extends ActionBarActivity {

    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText InputName, InputPhoneNo;
    String search_name, search_phone_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_patient_screen);
        InputName= (EditText) findViewById(R.id.name_input);
        InputPhoneNo= (EditText) findViewById(R.id.phone_no_input);
    }

    public void Back2Clicked(View view)
    {
    Intent i= new Intent(this, FirstScreen.class);
        startActivity(i);
    }

    public void LogInClicked (View view)
    {
        search_name= InputName.getText().toString();
        search_phone_no= InputPhoneNo.getText().toString();
        userDbHelper= new UserDbHelper(getApplicationContext());
        sqLiteDatabase= userDbHelper.getReadableDatabase();
        Cursor cursor= userDbHelper.getInformations(search_name,sqLiteDatabase);

        if (cursor.moveToFirst())
        {
            Intent intent = new Intent(ExistingPatientScreen.this, ExistingUserInformation.class);
            intent.putExtra("name", cursor.getString(0).toString());
            intent.putExtra("mob",cursor.getString(1).toString());
            intent.putExtra("address",cursor.getString(2).toString());
            intent.putExtra("pregnancy", cursor.getString(3).toString());
            intent.putExtra("expected", cursor.getString(4).toString());
            intent.putExtra("diseases",cursor.getString(5).toString());
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Information Didn't Match!!!",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_existing_patient_screen, menu);
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
