package za.ac.cput.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ViewCustomersActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    CustomerDBHelper customerDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customers);
        listView = (ListView)findViewById(R.id.listView);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter );
        customerDBHelper = new CustomerDBHelper(getApplicationContext());
        sqLiteDatabase = customerDBHelper.getReadableDatabase();
        cursor = customerDBHelper.getCustomer(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do
            {

                String name,surname,IDnumber;
                name = cursor.getString(0);
                surname = cursor.getString(1);
                IDnumber = cursor.getString(2);

                DataAdapter dataAdapter = new DataAdapter(name,surname,IDnumber);

                listDataAdapter.add(dataAdapter);

            }while (cursor.moveToNext());
        }
    }



}
