package com.example.a803bo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

///****///****///***///
/*
ALERT!!!
This whole activity is a temporary measure to accommodate for the fact that the host/lobby activities aren't done yet!
This is NOT meant to be proper application flow!!
--BJD
 */
///****///****///***///


public class TempModeSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_mode_select);
        Button startButton=findViewById(R.id.startButton);
        final ToggleButton modeSelector=findViewById(R.id.modeSelector);
        final TextView modeDesc= findViewById(R.id.modeDesc);

        modeSelector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked)
                {
                    modeDesc.setText(R.string.timerMode);
                }
                else
                {
                    modeDesc.setText(R.string.completionMode);
                }
            }
    });


        startButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                    Intent intent = new Intent(TempModeSelectActivity.this, ItemActivity.class);

                    intent.putExtra("mode", modeSelector.isChecked());
                    startActivity(intent);

            }
    });
    }
}
