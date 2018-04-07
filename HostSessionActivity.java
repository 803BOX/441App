package com.example.a803bo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HostSessionActivity extends AppCompatActivity {

    EditText enterPassword;
    TextView passDisplay;
    Button createButton;
    Button cancelButton;
    CheckBox protectCheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_session);

        createButton= findViewById(R.id.createButton);
        cancelButton= findViewById(R.id.cancelButton);
        protectCheck= findViewById(R.id.protectCheck);
        passDisplay= findViewById(R.id.passDisplay);
        enterPassword= findViewById(R.id.enterPassword);


        //disable password box when the 'protect' check is empty
        protectCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            if (compoundButton.isChecked()) {
                passDisplay.setEnabled(true);
                enterPassword.setEnabled(true);
            } else {
                passDisplay.setEnabled(false);
                enterPassword.setEnabled(false);
            }
        }
        });


        createButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "You clicked a button!", Toast.LENGTH_SHORT);
                toast.show();
            }

    });
        cancelButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });




}

}
