package za.ac.cput.myapplication.AddCustomer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import za.ac.cput.myapplication.CustomerDBHelper;
import za.ac.cput.myapplication.R;

public class AddCustomer extends AppCompatActivity
{
    EditText CusName, CusSurname,IdNumber;

    Context context = this;
    CustomerDBHelper customerDBHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        CusName = (EditText) findViewById(R.id.editText);
        CusSurname = (EditText) findViewById(R.id.editText2);
        IdNumber = (EditText) findViewById(R.id.editText3);
    }

    public void addCustomer(View view)
    {
        String name = CusName.getText().toString();
        String surname = CusSurname.getText().toString();
        String idNumber = IdNumber.getText().toString();

       if(name.equals("") )
       {
           CusName.requestFocus();
           CusName.setError("Cannot be empty.");
       }else if(surname.equals(""))
       {
           CusSurname.requestFocus();
           CusSurname.setError("Cannot be empty.");
       }
       else if( idNumber.equals(""))
       {

           IdNumber.requestFocus();
           IdNumber.setError("Cannot be empty.");
       }
       else
       {
           customerDBHelper = new CustomerDBHelper(context);
           sqLiteDatabase = customerDBHelper.getWritableDatabase();
           customerDBHelper.insertCustomer(name,surname,idNumber,sqLiteDatabase);
           Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_LONG).show();
           customerDBHelper.close();
           CusSurname.setText("");
           CusName.setText("");
           IdNumber.setText("");
       }
    }
}
