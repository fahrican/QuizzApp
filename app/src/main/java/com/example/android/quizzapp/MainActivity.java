package com.example.android.quizzapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numberOfPoints = 0;
    int questionThreePoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context currentContext = this;
        Button quizAnsweredButton = (Button) findViewById(R.id.submit_button);
        quizAnsweredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                Toast.makeText(currentContext, "TESTING", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void questionNumberOne(View v) {

        RadioButton decisionRadioButton = (RadioButton) findViewById(R.id.radio_2008);
        if (decisionRadioButton.isChecked()) {
            numberOfPoints++;
        }
        Log.v("MainActivity", "1.) Points: " + numberOfPoints);
    }

    public void questionNumberTwo(View v) {

        EditText answerQuestionTwo = (EditText) findViewById(R.id.answer_second_question);
        String answerQuestionTwoAsText = answerQuestionTwo.toString();
        String temp = answerQuestionTwoAsText.toLowerCase();
        Log.v("MainActivity", "The String: " + temp);

        if (temp.equals("satoshi nakamoto")) {
            numberOfPoints++;
        }
    }

    public void questionNumberThree(View v) {

        CheckBox optionCrypto = (CheckBox) findViewById(R.id.answer_crypto);
        if (optionCrypto.isChecked()) {
            questionThreePoints++;
        }

        CheckBox optionStockOptions = (CheckBox) findViewById(R.id.answer_stock_options);
        if (optionStockOptions.isChecked()) {
            decrementQuestionThreePoints(questionThreePoints);
        }

        CheckBox optionGoldCoin = (CheckBox) findViewById(R.id.answer_gold_coin);
        if (optionGoldCoin.isChecked()) {
            decrementQuestionThreePoints(questionThreePoints);
        }

        CheckBox optionPaymnetNetwork = (CheckBox) findViewById(R.id.answer_payment_network);
        if (optionPaymnetNetwork.isChecked()) {
            questionThreePoints++;
        }
    }

    public void decrementQuestionThreePoints(int question3) {

        if (question3 > 0) {
            question3--;
        }
    }

    public void questionNumberFour(View v) {

        EditText answerQuestionFour = (EditText) findViewById(R.id.answer_fourth_question);
        String answerQuestionFourAsText = answerQuestionFour.toString();
        String temp = answerQuestionFourAsText.toLowerCase();
        Log.v("MainActivity", "4.) The String: " + temp);

        if (temp.equals("cash book")) {
            numberOfPoints++;
        }
    }

    public void questionNumberFive(View v) {

        RadioButton decisionFiveRadioButton = (RadioButton) findViewById(R.id.radio_2140);
        if (decisionFiveRadioButton.isChecked()) {
            numberOfPoints++;
        }
        Log.v("MainActivity", "5.) Points: " + numberOfPoints);
    }

    public void evaluateInput () {

        
    }

}//end of class
