package com.example.task31quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage5 extends AppCompatActivity {

    TextView TextWithName, question1Text, progressTextValue;
    Button CorrectAnswerButton, WrongAnswerButton, nextQuestionButton;
    ImageView DeakinImage;
    ProgressBar progressBarVal;

    boolean isAnswered = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page5);

        TextWithName = findViewById(R.id.TextWithName);
        question1Text = findViewById(R.id.question1Text);
        CorrectAnswerButton = findViewById(R.id.CorrectAnswerButton);
        WrongAnswerButton = findViewById(R.id.WrongAnswerButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        DeakinImage = findViewById(R.id.DeakinImage);
        progressBarVal = findViewById(R.id.progressBar);
        progressTextValue = findViewById(R.id.progressText);

        String name = getIntent().getStringExtra("user_name");
        String studentid = getIntent().getStringExtra("student_id");
        final int[] score = { getIntent().getIntExtra("score", 0) };

        TextWithName.setText("Welcome " + name + "! Student ID: " + studentid);

        CorrectAnswerButton.setOnClickListener(view -> {
            if (!isAnswered) {
                CorrectAnswerButton.setBackgroundColor(Color.GREEN);
                WrongAnswerButton.setBackgroundColor(Color.BLACK);
                score[0]++;
                isAnswered = true;
            }
        });

        WrongAnswerButton.setOnClickListener(view -> {
            if (!isAnswered) {
                WrongAnswerButton.setBackgroundColor(Color.RED);
                CorrectAnswerButton.setBackgroundColor(Color.GREEN);
                isAnswered = true;
            }
        });

        nextQuestionButton.setOnClickListener(view -> {
            Intent intent = new Intent(QuizPage5.this, QuizResultActivity.class);
            intent.putExtra("user_name", name);
            intent.putExtra("student_id", studentid);
            intent.putExtra("score", score[0]);

            startActivity(intent);
        });
    }
}
