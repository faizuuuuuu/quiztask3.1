package com.example.task31quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_page4 extends AppCompatActivity {

    TextView TextWithName, question1Text, progressTextValue;
    Button option1, option2, option3, nextQuestionButton;
    ImageView DeakinImage;
    ProgressBar progressBarVal;

    boolean isAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page4);

        TextWithName = findViewById(R.id.TextWithName);
        question1Text = findViewById(R.id.question1Text);
        option1 = findViewById(R.id.option1); // 3
        option2 = findViewById(R.id.option2); // 4 (Correct)
        option3 = findViewById(R.id.option3); // 6
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        DeakinImage = findViewById(R.id.DeakinImage);
        progressBarVal = findViewById(R.id.progressBar);
        progressTextValue = findViewById(R.id.progressText);

        int progress = 75; // 3 out of 4
        progressBarVal.setProgress(progress);
        progressTextValue.setText("Progress: " + progress + "% (3 of 4)");

        String name = getIntent().getStringExtra("user_name");
        String studentid = getIntent().getStringExtra("student_id");
        final int[] score = { getIntent().getIntExtra("score", 0) };

        TextWithName.setText("Welcome " + name + "! Student ID: " + studentid);

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnswered) return;

                if (view == option2) {
                    option2.setBackgroundColor(Color.GREEN);
                    option1.setBackgroundColor(Color.BLACK);
                    option3.setBackgroundColor(Color.BLACK);
                    score[0]++;
                } else {
                    view.setBackgroundColor(Color.RED);
                    option2.setBackgroundColor(Color.GREEN);
                }

                isAnswered = true;
            }
        };

        option1.setOnClickListener(answerClickListener);
        option2.setOnClickListener(answerClickListener);
        option3.setOnClickListener(answerClickListener);

        nextQuestionButton.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_page4.this, QuizPage5.class);
            intent.putExtra("user_name", name);
            intent.putExtra("student_id", studentid);
            intent.putExtra("score", score[0]);


            startActivity(intent);
        });
    }
}