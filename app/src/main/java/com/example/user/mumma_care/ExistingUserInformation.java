package com.example.user.mumma_care;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ExistingUserInformation extends ActionBarActivity {

    TextView ViewName, ViewPhone, ViewAddress, ViewPregnancy, ViewDelivery, ViewDiseases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user_information);
        TextView ViewName= (TextView) findViewById(R.id.existing_name);
        TextView ViewPhone= (TextView) findViewById(R.id.existing_mobile);
        TextView ViewAddress= (TextView) findViewById(R.id.existing_address);
        TextView ViewPregnancy= (TextView) findViewById(R.id.existing_pregnancy);
        TextView ViewDelivery= (TextView) findViewById(R.id.existing_delivery);
        TextView ViewDiseases= (TextView) findViewById(R.id.existing_diseases);
        ViewName.setText(getIntent().getExtras().getString("name"));
        ViewPhone.setText(getIntent().getExtras().getString("mob"));
        ViewAddress.setText(getIntent().getExtras().getString("address"));
        ViewPregnancy.setText(getIntent().getExtras().getString("pregnancy"));
        ViewDelivery.setText(getIntent().getExtras().getString("expected"));
        ViewDiseases.setText(getIntent().getExtras().getString("diseases"));
    }
    public void FirstVisitClicked (View view)
    {
        Intent i = new Intent(this, First_Visit.class);
        startActivity(i);
    }
    public void SecondVisitClicked (View view)
    {
        Intent i = new Intent(this, Second_Visit.class);
        startActivity(i);
    }
    public void ThirdVisitClicked (View view)
    {
        Intent i = new Intent(this,Third_Visit.class);
        startActivity(i);
    }
    public void FourthVisitClicked (View view)
    {
        Intent i = new Intent(this, Fourth_Visit.class);
        startActivity(i);
    }
    public void FifthVisitClicked (View view)
    {
        Intent i = new Intent(this, Fifth_Visit.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_existing_user_information, menu);
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
