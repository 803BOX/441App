package com.example.a803bo.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hostButton = findViewById(R.id.hostButton);
        Button joinButton = findViewById(R.id.joinButton);

        hostButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HostSessionActivity.class);
            startActivity(intent);
            }
        });

        joinButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
               // Toast toast = Toast.makeText(getApplicationContext(), "You clicked a button!", Toast.LENGTH_SHORT);
               // toast.show();

                //well, this really isn't how this should work buuut.......
                //I need to get to the list screen ^^;

                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);


            }
        });

    }
}
