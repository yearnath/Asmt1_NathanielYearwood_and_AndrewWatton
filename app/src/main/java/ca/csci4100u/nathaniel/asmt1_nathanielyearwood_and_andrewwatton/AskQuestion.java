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

        String[] questions = getResources().getStringArray(R.array.questions);

        TextView lblGreeting = (TextView)findViewById(R.id.lbl_question);
        lblGreeting.setText(questions[MainMenu.currentQuestion]);
    }

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
