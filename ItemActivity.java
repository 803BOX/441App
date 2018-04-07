package com.example.a803bo.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
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
    Boolean timerMode;
    CountDownTimer timer;

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
        timerMode=getIntent().getBooleanExtra("mode",false);
        final long startTime= SystemClock.elapsedRealtime();
        final Toast toast = Toast.makeText(getApplicationContext(), "Correct! Yay!", Toast.LENGTH_SHORT);


        answerList.add(0, new String[]{"string", "string"});
        answerList.add(1, new String[]{"str ing", "str ing"});
        answerList.add(2, new String[]{"Str1ng!", "Str1ng!"});

        // prob better way to do this?
        answerCorrect = (answerList.get(0))[0];
        showHint.setText(answerCorrect);

        if (timerMode)
        {
            timer =new CountDownTimer(30000, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    DialogFragment newFragment =TimeOutDialogFragment.newInstance(position);
                    newFragment.show(getSupportFragmentManager(), "timeOut");

                }
            };
            timer.start();
        }

        itemCommit.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                String answerAttempt;

                if (enterHint == null) {
                    answerAttempt = " ";
                } else {
                    answerAttempt = enterHint.getText().toString().toUpperCase();
                }

                    // handling for correct answer
                if (answerAttempt.equals(answerCorrect.toUpperCase())) {



                    // correct answer && !end of list
                    if(position<(answerList.size())-1)
                    {
                        toast.show();
                        position++;
                        answerCorrect = (answerList.get(position))[0];
                        enterHint.setText("");
                        showHint.setText(answerCorrect);
                    }

                    //correct answer && end of list
                    else{
                        long intervalTime=(SystemClock.elapsedRealtime()-startTime);

                      //  Toast toast2 = Toast.makeText(getApplicationContext(), "Time: "+String.valueOf(intervalTime)+" ms", Toast.LENGTH_SHORT);
                      //  toast2.show();

                        if(timerMode)
                        {
                            timer.cancel();
                        }

                        DialogFragment newFragment = CompleteDialogFragment.newInstance((int)(intervalTime/1000));
                        newFragment.show(getSupportFragmentManager(), "complete");

                    }


                }
                // incorrect answer
                else {
                    Toast toastIncorrect = Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT);
                    toastIncorrect.show();

                }

            }

        });

        addItemStart.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
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