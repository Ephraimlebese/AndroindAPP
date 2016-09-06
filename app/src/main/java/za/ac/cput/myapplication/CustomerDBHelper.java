package za.ac.cput.myapplication;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Thabo on 8/31/2016.
 */
public class CustomerDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CUSTOMER.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
    "CREATE TABLE "+CustomerDetails.NewCustomer.TABLE_NAME+"("+CustomerDetails.NewCustomer.CUS_NAME+" TEXT,"+
            CustomerDetails.NewCustomer.CUS_SURNAME+" TEXT,"+ CustomerDetails.NewCustomer.CUS_ID+" TEXT);";

    public CustomerDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPARATIONS","Database created or open...");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPARATIONS","Table created...");
    }
    //insert data to the database
    public void insertCustomer(String name,String surname,String idNumber,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CustomerDetails.NewCustomer.CUS_NAME,name);
        contentValues.put(CustomerDetails.NewCustomer.CUS_SURNAME,surname);
        contentValues.put(CustomerDetails.NewCustomer.CUS_ID,idNumber);
        db.insert(CustomerDetails.NewCustomer.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPARATIONS","Customer inserted...");
    }

    //read data from the database

    public Cursor getCustomer(SQLiteDatabase db)
    {
        Cursor cursor;
        String [] columns = {CustomerDetails.NewCustomer.CUS_NAME,CustomerDetails.NewCustomer.CUS_SURNAME,CustomerDetails.NewCustomer.CUS_ID};
        //read and order by name
        cursor = db.query(CustomerDetails.NewCustomer.TABLE_NAME,columns,null,null,null,null,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
