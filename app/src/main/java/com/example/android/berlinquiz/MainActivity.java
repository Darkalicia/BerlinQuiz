package com.example.android.berlinquiz;

import android.content.Context;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.RenamingDelegatingContext;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This global variable represents the overall score at the start of the app.
     */
    int finalScore = 0;

    /*
    * This method is called once a user clicks the "Get my Score" button in the app.
     */

    public void calculateScore(View view) {

        /*
        * Calculate the final Score
         */

        finalScore = scoreQuestion1() + scoreQuestion2() + scoreQuestion3() + scoreQuestion4() + scoreQuestion5() + scoreQuestion6() + scoreQuestion7() + scoreQuestion8() + scoreQuestion9() + scoreQuestion10();

        /*
        * Check if the quizzer has filled out the nickname field.
         */

        if (quizzingPerson().isEmpty() == true) {
            Context context = getApplicationContext();
            CharSequence text = getResources().getText(R.string.name_error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {

            /*
            * Reveal the correct and false answers.
             */

            RadioButton question1answer1 = (RadioButton) findViewById(R.id.question1answer1);
            question1answer1.setTextColor(RED);

            RadioButton question1answer2 = (RadioButton) findViewById(R.id.question1answer2);
            question1answer2.setTextColor(RED);

            RadioButton question1answer3 = (RadioButton) findViewById(R.id.question1answer3);
            question1answer3.setTextColor(GREEN);

            RadioButton question1answer4 = (RadioButton) findViewById(R.id.question1answer4);
            question1answer4.setTextColor(RED);

            CheckBox question2answer1 = (CheckBox) findViewById(R.id.question2answer1);
            question2answer1.setTextColor(GREEN);

            CheckBox question2answer2 = (CheckBox) findViewById(R.id.question2answer2);
            question2answer2.setTextColor(GREEN);

            CheckBox question2answer3 = (CheckBox) findViewById(R.id.question2answer3);
            question2answer3.setTextColor(RED);

            CheckBox question2answer4 = (CheckBox) findViewById(R.id.question2answer4);
            question2answer4.setTextColor(GREEN);

            CheckBox question3answer1 = (CheckBox) findViewById(R.id.question3answer1);
            question3answer1.setTextColor(RED);

            CheckBox question3answer2 = (CheckBox) findViewById(R.id.question3answer2);
            question3answer2.setTextColor(GREEN);

            CheckBox question3answer3 = (CheckBox) findViewById(R.id.question3answer3);
            question3answer3.setTextColor(GREEN);

            CheckBox question3answer4 = (CheckBox) findViewById(R.id.question3answer4);
            question3answer4.setTextColor(GREEN);

            CheckBox question4answer1 = (CheckBox) findViewById(R.id.question4answer1);
            question4answer1.setTextColor(RED);

            CheckBox question4answer2 = (CheckBox) findViewById(R.id.question4answer2);
            question4answer2.setTextColor(GREEN);

            CheckBox question4answer3 = (CheckBox) findViewById(R.id.question4answer3);
            question4answer3.setTextColor(RED);

            CheckBox question4answer4 = (CheckBox) findViewById(R.id.question4answer4);
            question4answer4.setTextColor(RED);

            CheckBox question5answer1 = (CheckBox) findViewById(R.id.question5answer1);
            question5answer1.setTextColor(GREEN);

            CheckBox question5answer2 = (CheckBox) findViewById(R.id.question5answer2);
            question5answer2.setTextColor(GREEN);

            CheckBox question5answer3 = (CheckBox) findViewById(R.id.question5answer3);
            question5answer3.setTextColor(GREEN);

            CheckBox question5answer4 = (CheckBox) findViewById(R.id.question5answer4);
            question5answer4.setTextColor(RED);

            RadioButton question6answer1 = (RadioButton) findViewById(R.id.question6answer1);
            question6answer1.setTextColor(GREEN);

            RadioButton question6answer2 = (RadioButton) findViewById(R.id.question6answer2);
            question6answer2.setTextColor(RED);

            RadioButton question6answer3 = (RadioButton) findViewById(R.id.question6answer3);
            question6answer3.setTextColor(RED);

            RadioButton question6answer4 = (RadioButton) findViewById(R.id.question6answer4);
            question6answer4.setTextColor(RED);

            CheckBox question7answer1 = (CheckBox) findViewById(R.id.question7answer1);
            question7answer1.setTextColor(GREEN);

            CheckBox question7answer2 = (CheckBox) findViewById(R.id.question7answer2);
            question7answer2.setTextColor(GREEN);

            CheckBox question7answer3 = (CheckBox) findViewById(R.id.question7answer3);
            question7answer3.setTextColor(RED);

            CheckBox question7answer4 = (CheckBox) findViewById(R.id.question7answer4);
            question7answer4.setTextColor(GREEN);

            RadioButton question8answer1 = (RadioButton) findViewById(R.id.question8answer1);
            question8answer1.setTextColor(RED);

            RadioButton question8answer2 = (RadioButton) findViewById(R.id.question8answer2);
            question8answer2.setTextColor(GREEN);

            RadioButton question8answer3 = (RadioButton) findViewById(R.id.question8answer3);
            question8answer3.setTextColor(RED);

            RadioButton question8answer4 = (RadioButton) findViewById(R.id.question8answer4);
            question8answer4.setTextColor(RED);

            CheckBox question9answer1 = (CheckBox) findViewById(R.id.question9answer1);
            question9answer1.setTextColor(GREEN);

            CheckBox question9answer2 = (CheckBox) findViewById(R.id.question9answer2);
            question9answer2.setTextColor(GREEN);

            CheckBox question9answer3 = (CheckBox) findViewById(R.id.question9answer3);
            question9answer3.setTextColor(GREEN);

            CheckBox question9answer4 = (CheckBox) findViewById(R.id.question9answer4);
            question9answer4.setTextColor(GREEN);

            RadioButton question10answer1 = (RadioButton) findViewById(R.id.question10answer1);
            question10answer1.setTextColor(RED);

            RadioButton question10answer2 = (RadioButton) findViewById(R.id.question10answer2);
            question10answer2.setTextColor(RED);

            RadioButton question10answer3 = (RadioButton) findViewById(R.id.question10answer3);
            question10answer3.setTextColor(RED);

            RadioButton question10answer4 = (RadioButton) findViewById(R.id.question10answer4);
            question10answer4.setTextColor(GREEN);

            /*
            Compose the final score message by applying different answers based on the score.
             */

            String scoreMessage = "Hey, " + quizzingPerson() + "! \nYou have earned\n" + finalScore;

            if (finalScore == 1) {
                scoreMessage += " Point!\n";
            }

            else {
                scoreMessage += " Points!\n";
            }

            if (finalScore == 0) {
                scoreMessage += "\nAre you sure you took part in the quiz?";
            }

            else if (finalScore <= 5) {
                scoreMessage += "\nThere is still a lot to explore for you in Berlin. Come for a visit!";
            }

            else if (finalScore >= 6) {
                scoreMessage += "\nYou know a lot, but there is even more! Come for a visit!";
            }

            displayScoreMessage(scoreMessage);
        }



    }

    /**
     * This method reads the quizzers name from the text input view.
     */
    private String quizzingPerson() {
        EditText nameInput = (EditText) findViewById(R.id.name_text_input);
      //  String nameEntered = nameInput.getText().toString();
        return (nameInput.getText().toString());
    }

    /**
     * This method displays the final QuizScore message on the screen.
     */
    private void displayScoreMessage(String message) {
        TextView finalScoreTextView = (TextView) findViewById(R.id.finalScore);
        finalScoreTextView.setText(message);
    }

    /*
    * The following methods check if the individual questions were answered correctly. If so, they add a point to the overall score.
     */

    private int scoreQuestion1() {

        int scoreQuestion1 = 0;

        RadioButton question1answer3 = (RadioButton) findViewById(R.id.question1answer3);
        boolean valueAnswer3 = question1answer3.isChecked();

        if (valueAnswer3) {
            scoreQuestion1 =+ 1;
        }
        return scoreQuestion1;
    }

    private int scoreQuestion2() {

        int scoreQuestion2 = 0;

        CheckBox question2answer1 = (CheckBox) findViewById(R.id.question2answer1);
        boolean valueAnswer1 = question2answer1.isChecked();
        CheckBox question2answer3 = (CheckBox) findViewById(R.id.question2answer2);
        boolean valueAnswer3 = question2answer3.isChecked();
        CheckBox question2answer4 = (CheckBox) findViewById(R.id.question2answer4);
        boolean valueAnswer4 = question2answer4.isChecked();

        if (valueAnswer1 && valueAnswer3 && valueAnswer4) {
            scoreQuestion2 =+ 1;
        }
        return scoreQuestion2;
    }

    private int scoreQuestion3() {

        int scoreQuestion3 = 0;

        CheckBox question3answer2 = (CheckBox) findViewById(R.id.question3answer2);
        boolean valueAnswer2 = question3answer2.isChecked();
        CheckBox question3answer3 = (CheckBox) findViewById(R.id.question3answer3);
        boolean valueAnswer3 = question3answer3.isChecked();
        CheckBox question3answer4 = (CheckBox) findViewById(R.id.question3answer4);
        boolean valueAnswer4 = question3answer4.isChecked();

        if (valueAnswer2 && valueAnswer3 && valueAnswer4) {
            scoreQuestion3 =+ 1;
        }
        return scoreQuestion3;
    }

    private int scoreQuestion4() {

        int scoreQuestion4 = 0;

        CheckBox question4answer2 = (CheckBox) findViewById(R.id.question4answer2);
        boolean valueAnswer2 = question4answer2.isChecked();

        if (valueAnswer2 ) {
            scoreQuestion4 =+ 1;
        }
        return scoreQuestion4;
    }

    private int scoreQuestion5() {

        int scoreQuestion5 = 0;

        CheckBox question5answer1 = (CheckBox) findViewById(R.id.question5answer1);
        boolean valueAnswer1 = question5answer1.isChecked();
        CheckBox question5answer2 = (CheckBox) findViewById(R.id.question5answer2);
        boolean valueAnswer2 = question5answer2.isChecked();
        CheckBox question5answer3 = (CheckBox) findViewById(R.id.question5answer3);
        boolean valueAnswer3 = question5answer3.isChecked();

        if (valueAnswer1 && valueAnswer2 && valueAnswer3) {
            scoreQuestion5 =+ 1;
        }
        return scoreQuestion5;
    }

    private int scoreQuestion6() {

        int scoreQuestion6 = 0;

        RadioButton question6answer1 = (RadioButton) findViewById(R.id.question6answer1);
        boolean valueAnswer1 = question6answer1.isChecked();

        if (valueAnswer1) {
            scoreQuestion6 =+ 1;
        }
        return scoreQuestion6;
    }

    private int scoreQuestion7() {

        int scoreQuestion7 = 0;

        CheckBox question7answer1 = (CheckBox) findViewById(R.id.question7answer1);
        boolean valueAnswer1 = question7answer1.isChecked();
        CheckBox question7answer2 = (CheckBox) findViewById(R.id.question7answer2);
        boolean valueAnswer2 = question7answer2.isChecked();
        CheckBox question7answer4 = (CheckBox) findViewById(R.id.question7answer4);
        boolean valueAnswer4 = question7answer4.isChecked();

        if (valueAnswer1 && valueAnswer2 && valueAnswer4) {
            scoreQuestion7 =+ 1;
        }
        return scoreQuestion7;
    }

    private int scoreQuestion8() {

        int scoreQuestion8 = 0;

        RadioButton question8answer2 = (RadioButton) findViewById(R.id.question8answer2);
        boolean valueAnswer2 = question8answer2.isChecked();

        if (valueAnswer2) {
            scoreQuestion8 =+ 1;
        }
        return scoreQuestion8;
    }

    private int scoreQuestion9() {

        int scoreQuestion9 = 0;

        CheckBox question9answer1 = (CheckBox) findViewById(R.id.question9answer1);
        boolean valueAnswer1 = question9answer1.isChecked();
        CheckBox question9answer2 = (CheckBox) findViewById(R.id.question9answer2);
        boolean valueAnswer2 = question9answer2.isChecked();
        CheckBox question9answer3 = (CheckBox) findViewById(R.id.question9answer3);
        boolean valueAnswer3 = question9answer3.isChecked();
        CheckBox question9answer4 = (CheckBox) findViewById(R.id.question9answer4);
        boolean valueAnswer4 = question9answer4.isChecked();

        if (valueAnswer1 && valueAnswer2 && valueAnswer3 && valueAnswer4) {
            scoreQuestion9 =+ 1;
        }
        return scoreQuestion9;
    }

    private int scoreQuestion10() {

        int scoreQuestion10 = 0;

        RadioButton question10answer4 = (RadioButton) findViewById(R.id.question10answer4);
        boolean valueAnswer4 = question10answer4.isChecked();

        if (valueAnswer4) {
            scoreQuestion10 =+ 1;
        }
        return scoreQuestion10;
    }

}