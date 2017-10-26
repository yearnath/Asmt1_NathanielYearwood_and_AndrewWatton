package ca.csci4100u.nathaniel.asmt1_nathanielyearwood_and_andrewwatton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    public static int GET_RESPONSE_REQUEST = 4110;

    private int[] responses = new int[5];
    public static int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void ask(View v) {
        Intent newAskIntent = new Intent(MainMenu.this, AskQuestion.class);
        startActivityForResult(newAskIntent, GET_RESPONSE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent resultIntent) {
        super.onActivityResult(requestCode, responseCode, resultIntent);

        if (responseCode == RESULT_OK) {
            responses[currentQuestion] = resultIntent.getIntExtra("response", -1);
            currentQuestion++;
        }
        if (currentQuestion<=responses.length){
            this.ask(this.findViewById(R.id.button2));
        }
    }
}
