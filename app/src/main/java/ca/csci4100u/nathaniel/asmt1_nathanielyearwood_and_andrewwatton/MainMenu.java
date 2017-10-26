package ca.csci4100u.nathaniel.asmt1_nathanielyearwood_and_andrewwatton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    public static int GET_RESPONSE_REQUEST = 4110;
    private int[] responses;
    public static int currentQuestion = 0;
    public static int numberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        numberOfQuestions = getResources().getStringArray(R.array.questions).length;
        responses = new int[numberOfQuestions];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void ask(View v) {

        Intent newAskIntent = new Intent(MainMenu.this, AskQuestion.class);
        newAskIntent.putExtra("question", getResources().getStringArray(R.array.questions)[currentQuestion]);
        startActivityForResult(newAskIntent, GET_RESPONSE_REQUEST);
    }

    public void summarize(View v){

        Intent newSummarizeIntent = new Intent(MainMenu.this, Summary.class);
        newSummarizeIntent.putExtra("responses", responses);
        startActivity(newSummarizeIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent resultIntent) {
        super.onActivityResult(requestCode, responseCode, resultIntent);

        // receive answer from AskQuestion activity and move on to the next question
        if (responseCode == RESULT_OK) {

            responses[currentQuestion] = resultIntent.getIntExtra("response", -1);
            currentQuestion++;
        }
        // if all questions have been answered, display summary. Otherwise ask the next question
        if (currentQuestion==responses.length){

            summarize(this.findViewById(R.id.startButton));
            currentQuestion=0;
        }else{

            ask(this.findViewById(R.id.startButton));
        }
    }
}
