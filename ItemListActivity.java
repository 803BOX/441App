package com.example.a803bo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemListActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        String[] nameArray={"Dodo Egg","Striped Paint","Long Weight","Skyhook","Flux Capacitor","Snake Oil"};



        listView = findViewById(R.id.itemListID);

       final CustomListAdapter lstAdapter = new CustomListAdapter(ItemListActivity.this, nameArray);
        listView.setAdapter(lstAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(ItemListActivity.this, ItemDetailActivity.class);

               intent.putExtra("name","details about item");

                startActivity(intent);

            }
        });

    }
}
