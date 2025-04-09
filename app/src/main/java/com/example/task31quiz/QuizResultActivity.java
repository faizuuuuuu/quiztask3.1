package com.example.task31quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResultActivity extends AppCompatActivity {

    TextView resultText;
    Button restartQuizBtn, finishBtn;

    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        resultText = findViewById(R.id.resultText);
        restartQuizBtn = findViewById(R.id.restartQuizBtn);
        finishBtn = findViewById(R.id.finishBtn);
message = findViewById(R.id.MessageText);
        String studentid = getIntent().getStringExtra("student_id");
        String name = getIntent().getStringExtra("user_name");
        int score = getIntent().getIntExtra("score", 0);
        resultText.setText("Your score is: " + score + "/4");

        if(score <3 )
        {
message.setText("You should try again");
        }
        else {
            message.setText("Congratualations!");
        }
        restartQuizBtn.setOnClickListener(view -> {
            Intent intent = new Intent(QuizResultActivity.this, MainActivity.class);
            intent.putExtra("user_name", name);
            intent.putExtra("student_id", studentid);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        finishBtn.setOnClickListener(view -> {
            finishAffinity();
        });
    }
}
