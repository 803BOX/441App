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

                //this isn't really the right flow but I need to get from one thing to the next.
                //should properly lead to a lobby of sorts
                //but that's Travis's area so I don't have the code
                //--BJD

                Intent intent = new Intent(MainActivity.this, TempModeSelectActivity.class);
                startActivity(intent);


            }
        });

    }
}
