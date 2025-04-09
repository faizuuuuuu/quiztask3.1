package com.example.task31quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizPage2 extends AppCompatActivity {


    TextView TextWithName, question1Text;
    Button CorrectAnswerButton, WrongAnswerButton, nextQuestionButton;
    ImageView DeakinImage;

    ProgressBar progressBarVal;
    TextView progressTextValue;



    boolean isAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page2);


        TextWithName = findViewById(R.id.TextWithName);
        question1Text = findViewById(R.id.question1Text);
        CorrectAnswerButton = findViewById(R.id.CorrectAnswerButton);
        WrongAnswerButton = findViewById(R.id.WrongAnswerButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        DeakinImage = findViewById(R.id.DeakinImage);

        progressBarVal = findViewById(R.id.progressBar);
        progressTextValue = findViewById(R.id.progressText);


        final int[] score = {0};


        int progress = 25;

        progressBarVal.setProgress(progress);
        progressTextValue.setText("Progress: " + progress + "% (" + "1" + " of " + "4" + ")");

        String name = getIntent().getStringExtra("user_name");


        //this would display message . i used intent
        String studentid = getIntent().getStringExtra("student_id");
        TextWithName.setText("Welcome " + name + "! Student ID: " + studentid);
        CorrectAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAnswered) {
                    CorrectAnswerButton.setBackgroundColor(Color.GREEN);
                    WrongAnswerButton.setBackgroundColor(Color.RED);
                    isAnswered = true;
                    score[0]++;
                }
            }
        });


        WrongAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isAnswered) {
                    WrongAnswerButton.setBackgroundColor(Color.RED);
                    CorrectAnswerButton.setBackgroundColor(Color.GREEN);
                    isAnswered = true;
                }
            }
        });


        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(QuizPage2.this, quiz_page3.class);
                intent.putExtra("user_name", name);
                intent.putExtra("student_id", studentid);
                intent.putExtra("score", score[0]);


                startActivity(intent);
            }
        });
    }
}