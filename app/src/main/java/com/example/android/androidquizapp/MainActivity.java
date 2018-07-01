package com.example.android.androidquizapp;

import android.os.Debug;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int total_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //question 1

    public void questionOne() {
        //which radioButton is selected
        RadioButton radioButton = (RadioButton) findViewById(R.id.second_choice);
        boolean isQuestionOneChecked = radioButton.isChecked();

        if (isQuestionOneChecked) {
            total_score += 1;
        }
    }

    //question 2
    public void questionTwo() {
        EditText answer2Field = (EditText) findViewById(R.id.answer_two_field);
        Editable nameEditable = answer2Field.getText();
        String name = nameEditable.toString();

        //check correct answer and add score
        if (name.trim().equalsIgnoreCase("android debug bridge")){
            total_score += 1;
        }
    }

    //question 3
    //which checkBox is selected
    public void questionThree() {
        CheckBox firstChoiceCheckBox = (CheckBox) findViewById(R.id.first_choice_checkbox);
        boolean q3FirstChoice = firstChoiceCheckBox.isChecked();

        CheckBox secondChoiceCheckBox = (CheckBox) findViewById(R.id.second_choice_checkbox);
        boolean q3SecondChoice = secondChoiceCheckBox.isChecked();

        CheckBox thirdChoiceCheckBox = (CheckBox) findViewById(R.id.third_choice_checkbox);
        boolean q3ThirdChoice = thirdChoiceCheckBox.isChecked();


        if (q3FirstChoice && q3SecondChoice && !q3ThirdChoice) {
            total_score += 1;

        }
    }

    //question 4
    //which radioButton is selected
    public void questionFour() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.third_option);
        boolean isQuestionFourChecked = radioButton.isChecked();

        if (isQuestionFourChecked) {
            total_score += 1;
        }
    }

    //question 5 text free answer
    public void questionFive(){
        EditText answer2Field = (EditText) findViewById(R.id.answer_five_field);
        Editable nameEditable = answer2Field.getText();
        String name2 = nameEditable.toString();

        if (name2.trim().equalsIgnoreCase("integrated development environment")){
            total_score += 1;
        }
    }



    //when grade button is clicked
    public void grading(View view) {
        //calling methods
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();

        //display score through toast message
        Toast.makeText(this, "Your score is: " + total_score, Toast.LENGTH_SHORT).show();
        total_score = 0;

    }

    //reset score button
    public void reset(View View) {
        total_score = 0;

        //display score through toast
        Toast.makeText(this, "Current Score is: " + total_score, Toast.LENGTH_SHORT).show();

    }
}
