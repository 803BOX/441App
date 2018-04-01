package com.example.a803bo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        final EditText hintEntry=findViewById(R.id.hintEntry);
        final EditText answerEntry=findViewById(R.id.answerEntry);

        Button addItemCommit= findViewById(R.id.addItemCommit);

        addItemCommit.setOnClickListener(new Button.OnClickListener(){
        @Override
        public void onClick(View view)
        {
            if ((hintEntry.getText().toString().equals(""))||(answerEntry.getText().toString().equals("")))
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Error: One or more fields empty", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                String hint=hintEntry.getText().toString();
                String answer=answerEntry.getText().toString();
                Intent intent= new Intent(CreateListActivity.this,ItemActivity.class);
                intent.putExtra("item",new String[]{hint,answer});
                setResult(RESULT_OK,intent);
                finish();
            }




        }
    });

    }
}
