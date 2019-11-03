package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*
   declaring the respective views to use as a reference for the xml views
    */
    private EditText answerOne;
    private CheckBox checkTrue, checkFalse;
    private TextView answerThree, feedback;
    private RadioGroup radioGroup;
    private Button submit;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /*
                referencing the views fom the xml file
     */
        answerOne = findViewById(R.id.question1_answer);
        checkTrue = findViewById(R.id.trueButton);
        checkFalse = findViewById(R.id.falseButton);
        answerThree = findViewById(R.id.question3_answer);
        radioGroup = findViewById(R.id.radio_group);
        feedback = findViewById(R.id.numberCorrectAnswers_view);
        submit = findViewById(R.id.submit);
        action();

    }

    /*
    A method to check the answers
     */
    public void checkAnswers() {
        int selectedRadio = radioGroup.getCheckedRadioButtonId();
        if (answerOne.getText().toString().compareTo("36")==0 && checkTrue.isChecked() && answerThree.getText().toString().compareTo("59")==0 && selectedRadio==R.id.liverpool ) {
            feedback.setText("all answers are correct");
        } else {
            feedback.setText("maybe some answers are blank or some are incorrect");
        }
    }

    /*
   A method to tell the buttons what to do
    */
    public void action() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
        checkTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFalse.setChecked(false);
            }
        });

        checkFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTrue.setChecked(false);
            }
        });
    }

    public void decrement(View view) {
        count = Integer.parseInt(answerThree.getText().toString());
        count--;
        answerThree.setText(String.valueOf(count));
    }

    public void increment(View view) {
        count = Integer.parseInt(answerThree.getText().toString());
        count++;
        answerThree.setText(String.valueOf(count));
    }
}
