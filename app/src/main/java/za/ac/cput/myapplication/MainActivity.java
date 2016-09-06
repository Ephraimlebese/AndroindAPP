package za.ac.cput.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import za.ac.cput.myapplication.AddCustomer.AddCustomer;

public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void navigate(View view)
    {
        Intent addcustomer = new Intent(this, AddCustomer.class);
        startActivity(addcustomer);
    }

    public void viewCustomer(View view)
    {
        Intent viewCustomer = new Intent(this, ViewCustomersActivity.class);
        startActivity(viewCustomer);
    }
}
