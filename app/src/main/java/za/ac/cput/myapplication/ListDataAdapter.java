package za.ac.cput.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thabo on 8/31/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
     public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView NAME,SURNAME,IDNUMBER;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;

        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView)row.findViewById(R.id.textName);
            layoutHandler.SURNAME = (TextView)row.findViewById(R.id.textSurname);
            layoutHandler.IDNUMBER = (TextView)row.findViewById(R.id.textIDnumber);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }

        DataAdapter dataAdapter = (DataAdapter) this.getItem(position);
        layoutHandler.NAME.setText(dataAdapter.getName());
        layoutHandler.SURNAME.setText(dataAdapter.getSurname());
        layoutHandler.IDNUMBER.setText(dataAdapter.getIDnumber());

        return row;
    }
}
