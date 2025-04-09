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

public class quiz_page3 extends AppCompatActivity {


    TextView TextWithName, question2Text, progressTextValue;
    Button option1, option2, option3, nextQuestionButton;
    ImageView DeakinImage;
    ProgressBar progressBarVal;
    boolean isAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page3);

        TextWithName = findViewById(R.id.TextWithName);
        question2Text = findViewById(R.id.question2Text);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        DeakinImage = findViewById(R.id.DeakinImage);
        progressBarVal = findViewById(R.id.progressBar);
        progressTextValue = findViewById(R.id.progressText);

        int progress = 50;
        progressBarVal.setProgress(progress);
        progressTextValue.setText("Progress: " + progress + "% (2 of 4)");
        final int[] score = { getIntent().getIntExtra("score", 0) };


        String name = getIntent().getStringExtra("user_name");
        String studentid = getIntent().getStringExtra("student_id");

        TextWithName.setText("Welcome " + name + "! Student ID: " + studentid);

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnswered) return;

                if (view == option3) {
                    option3.setBackgroundColor(Color.GREEN); // Correct
                    option1.setBackgroundColor(Color.BLACK);
                    option2.setBackgroundColor(Color.BLACK);
                    score[0]++;

                } else {
                    view.setBackgroundColor(Color.RED);
                    option3.setBackgroundColor(Color.GREEN);
                }
                isAnswered = true;

            }
        };

        option1.setOnClickListener(answerClickListener);
        option2.setOnClickListener(answerClickListener);
        option3.setOnClickListener(answerClickListener);

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(quiz_page3.this, quiz_page4.class);
                intent.putExtra("user_name", name);
                intent.putExtra("score", score[0]);

                intent.putExtra("student_id", studentid);
                startActivity(intent);
            }
        });
    }
}