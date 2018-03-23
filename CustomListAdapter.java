package com.example.a803bo.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 803bo on 3/12/2018.
 */

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;


    //to store the list of countries
    private final String[] nameArray;


    public CustomListAdapter(Activity context, String[] nameArrayParam){

        super(context, R.layout.list_row , nameArrayParam);

        this.context=context;
        this.nameArray = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = rowView.findViewById(R.id.listItemName);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        return rowView;

    }


}
