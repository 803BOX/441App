package com.example.a803bo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    TextView showHint;
    EditText enterHint;
    Button itemCommit;
    Button addItemStart;
    String answerCorrect;
    int position;

    ArrayList<String[]> answerList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        showHint = findViewById(R.id.showHint);
        enterHint = findViewById(R.id.enterHint);
        itemCommit = findViewById(R.id.itemCommit);
        addItemStart = findViewById(R.id.addItemStart);
        position = 0;

        // answerCorrect ="caTs23";
        // showHint.setText(answerCorrect);

        answerList.add(0, new String[]{"cats are good", "cats are good"});
        answerList.add(1, new String[]{"bananaphone", "bananaphone"});
        answerList.add(2, new String[]{"glasses", "glasses"});
     /*   answerList.add(3, new String[]{"Xr394z", "Xr394z"});
        answerList.add(4, new String[]{"05101995", "05101995"});
        answerList.add(5, new String[]{"*sneak*", "*sneak*"});
        answerList.add(6, new String[]{"AC/DC", "AC/DC"});
        */

        // prob better way to do this?
        answerCorrect = (answerList.get(0))[0];
        showHint.setText(answerCorrect);


        itemCommit.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                String answerAttempt;

                if (enterHint == null) {
                    answerAttempt = " ";
                } else {
                    answerAttempt = enterHint.getText().toString().toUpperCase();
                }
                //aaa nemui naaaaa... mou sanji da zo...? mou neyou...?

                if (answerAttempt.equals(answerCorrect.toUpperCase())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct! Yay!", Toast.LENGTH_SHORT);
                    toast.show();


                    if(position<(answerList.size())-1)
                    {
                        position++;
                        answerCorrect = (answerList.get(position))[0];
                        enterHint.setText("");
                        showHint.setText(answerCorrect);
                    }


                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry, try again.", Toast.LENGTH_SHORT);
                    toast.show();


                }

            }

        });

        addItemStart.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                //eh? nande umaku ikanai no?

                //Intent intent= ;
                startActivityForResult(new Intent(ItemActivity.this, CreateListActivity.class), 0);

            }


        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 0 && resultCode == RESULT_OK)
            {
                answerList.add(answerList.size(),data.getStringArrayExtra("item"));
            }
        }}