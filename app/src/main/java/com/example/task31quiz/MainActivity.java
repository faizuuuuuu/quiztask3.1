package com.example.task31quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText nameInput , studentIdInput;
    Button startQuizBtn;

    double StudentId;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);


        nameInput = findViewById(R.id.Inputforname);
        studentIdInput = findViewById(R.id.InputforStudentId);
        startQuizBtn = findViewById(R.id.startQuiz);

        String Namegotback = getIntent().getStringExtra("user_name");
        String Studentidgotback = getIntent().getStringExtra("student_id");
        if (Namegotback != null &&  Studentidgotback != null) {
            nameInput.setText(Namegotback);
            studentIdInput.setText(Studentidgotback);
        }

        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameofstudent = nameInput.getText().toString().trim();
                String studentId = studentIdInput.getText().toString().trim();




                if (nameofstudent.isEmpty() || studentId.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter A NUMBER", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    Double.parseDouble(studentId);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Student ID must be a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                    Intent intent = new Intent(MainActivity.this, QuizPage2.class);
                    intent.putExtra("user_name", nameofstudent);
                    intent.putExtra("student_id", studentId);
                    startActivity(intent);
                }

        });

    }
}