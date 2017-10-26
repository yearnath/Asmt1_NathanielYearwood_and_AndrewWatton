package ca.csci4100u.nathaniel.asmt1_nathanielyearwood_and_andrewwatton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AskQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        // print "Question i/total" and the current question
        String question = getIntent().getStringExtra("question");
        TextView questionTitle = (TextView)findViewById(R.id.questionTitle);
        int q = MainMenu.currentQuestion+1;
        questionTitle.setText("Question " + q + "/" + MainMenu.numberOfQuestions);
        TextView questionText = (TextView)findViewById(R.id.questionText);
        questionText.setText(question);
    }


    // return 1 for "yes" answer an 0 for "no" answer
    public void onClickYes(View v) {
        Intent resultIntent = new Intent(Intent.ACTION_PICK);
        resultIntent.putExtra("response", 1);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void onClickNo(View v) {
        Intent resultIntent = new Intent(Intent.ACTION_PICK);
        resultIntent.putExtra("response", 0);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

}
