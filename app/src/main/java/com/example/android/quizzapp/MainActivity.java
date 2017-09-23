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
import android.widget.RadioGroup;
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
                Toast.makeText(currentContext, "Number of Points: " + evaluateInput(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public int evaluateInput() {

        //first question
        RadioButton decisionRadioButton = (RadioButton) findViewById(R.id.radio_2008);
        if (decisionRadioButton.isChecked()) {
            numberOfPoints++;
        }
        Log.v("MainActivity", "1.) Points: " + numberOfPoints);

        //second question
        EditText answerQuestionTwo = (EditText) findViewById(R.id.answer_second_question);
        String answerQuestionTwoAsText = answerQuestionTwo.getText().toString();
        String answerQuestionTwoResult = answerQuestionTwoAsText.toLowerCase().trim();

        if (answerQuestionTwoResult.equals("satoshi nakamoto")) {
            numberOfPoints++;
        }
        Log.v("MainActivity", "2.) The String: " + answerQuestionTwoAsText);

        //third question
        CheckBox optionCrypto = (CheckBox) findViewById(R.id.answer_crypto);
        CheckBox optionStockOptions = (CheckBox) findViewById(R.id.answer_stock_options);
        CheckBox optionGoldCoin = (CheckBox) findViewById(R.id.answer_gold_coin);
        CheckBox optionPaymnetNetwork = (CheckBox) findViewById(R.id.answer_payment_network);

        if (optionCrypto.isChecked() && optionPaymnetNetwork.isChecked() && !(optionStockOptions.isChecked() || optionGoldCoin.isChecked())) {
            questionThreePoints++;
        }
        else {
            questionThreePoints = 0;
        }


        Log.v("MainActivity", "3.) Points: " + questionThreePoints);
        numberOfPoints += questionThreePoints;

        //fourth question
        EditText answerQuestionFour = (EditText) findViewById(R.id.answer_fourth_question);
        String answerQuestionFourAsText = answerQuestionFour.getText().toString();
        String tempQuestionFour = answerQuestionFourAsText.toLowerCase().trim();
        Log.v("MainActivity", "4.) The String: " + answerQuestionFourAsText);

        if (tempQuestionFour.equals("cash book")) {
            numberOfPoints++;
        }

        //fifth question
        RadioButton decisionFiveRadioButton = (RadioButton) findViewById(R.id.radio_2140);
        if (decisionFiveRadioButton.isChecked()) {
            numberOfPoints++;
        }
        Log.v("MainActivity", "5.) Points: " + numberOfPoints);

        return numberOfPoints;
    }

    public void resetInput(View v) {

        //first question input
        RadioGroup radiogrp = (RadioGroup) findViewById(R.id.radio_buttons_invented);
        radiogrp.clearCheck();

        //second question input
        EditText answerQuestionTwo = (EditText) findViewById(R.id.answer_second_question);
        answerQuestionTwo.setText(null);

        //third question input
        CheckBox optionCrypto = (CheckBox) findViewById(R.id.answer_crypto);
        CheckBox optionStockOptions = (CheckBox) findViewById(R.id.answer_stock_options);
        CheckBox optionGoldCoin = (CheckBox) findViewById(R.id.answer_gold_coin);
        CheckBox optionPaymnetNetwork = (CheckBox) findViewById(R.id.answer_payment_network);

        if (optionCrypto.isChecked()) {
            optionCrypto.setChecked(false);
        }
        if (optionStockOptions.isChecked()) {
            optionStockOptions.setChecked(false);
        }
        if (optionGoldCoin.isChecked()) {
            optionGoldCoin.setChecked(false);
        }
        if (optionPaymnetNetwork.isChecked()) {
            optionPaymnetNetwork.setChecked(false);
        }

        //four question input
        EditText answerQuestionFour = (EditText) findViewById(R.id.answer_fourth_question);
        answerQuestionFour.setText(null);

        //five question input
        RadioGroup mined = (RadioGroup) findViewById(R.id.radio_buttons_mined);
        mined.clearCheck();

        questionThreePoints = 0;
        numberOfPoints = 0;
    }

}//end of class
