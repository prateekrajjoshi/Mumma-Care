package com.example.user.mumma_care;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class FirstScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }

    ///////////////////////////////////////When New Patient Button Is Clicked////////////////////
    public void NewPatientClicked( View view)
    {
        Intent i = new Intent(this, NewPatientScreen.class);
        startActivity(i);
        overridePendingTransition(R.anim.animation1, R.anim.animation2);
    }

    /////////////////////////////////When More Info TextView Is Clicked/////////////////////////////////////////////
    public void MoreInfoClicked (View view)
    {
        AlertDialog.Builder myAlert= new AlertDialog.Builder(this);
        myAlert.setMessage("Mumma-Care TM \n\nDeveloped and Designed By: \n\nPrateek Raj Joshi \nGyanendra Raj Joshi \nPrabal Bhusal \n\nThis app collects information,disseminates data  and sends reminders to ensure safe and effective maternal and child health care. ")
                .setTitle("Info")
                .setPositiveButton("OK!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        myAlert.show();

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////When Existing Patient Button Is Clicked/////////////////////////////////////////
    public void ExistingPatientClicked( View view)
    {
        Intent i = new Intent(this, ExistingPatientScreen.class);
        startActivity(i);
        overridePendingTransition(R.anim.animation1, R.anim.animation2);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    public void SendSMSClicked (View view)
    {
        Intent i =new Intent(this, SendSMS.class);
        startActivity(i);
        overridePendingTransition(R.anim.animation1, R.anim.animation2);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
