package com.biryanistudio.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        int score = 0;
        if (((RadioGroup) findViewById(R.id.author_radiogroup))
                .getCheckedRadioButtonId() == R.id.douglas_adams)
            score++;
        if (Integer.parseInt(((EditText) findViewById(R.id.answer_to_everything))
                .getText().toString()) == 42)
            score++;
        LinearLayout bookNameHolder = (LinearLayout) findViewById(R.id.book_name_holder);
        if (((CheckBox) bookNameHolder.getChildAt(0)).isChecked() &&
                ((CheckBox) bookNameHolder.getChildAt(1)).isChecked() &&
                ((CheckBox) bookNameHolder.getChildAt(2)).isChecked() &&
                !((CheckBox) bookNameHolder.getChildAt(3)).isChecked())
            score++;
        if (Integer.parseInt(((EditText) findViewById(R.id.ascii_value))
                .getText().toString()) == 42)
            score++;
        if (score == 4)
            Toast.makeText(this, "Awesome! You scored " + score + "! Every answer is right!",
                    Toast.LENGTH_SHORT).show();
        else if (score == 0)
            Toast.makeText(this, "You score nothing!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "You scored " + score + "!", Toast.LENGTH_SHORT).show();
    }
}
