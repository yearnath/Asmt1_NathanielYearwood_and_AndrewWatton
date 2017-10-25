package ca.csci4100u.nathaniel.asmt1_nathanielyearwood_and_andrewwatton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    public static int GET_RESPONSE_REQUEST = 4100001;

    String[] responses = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void getResponse(View v) {
        Intent newAskIntent = new Intent(MainMenu.this, AskQuestion.class);
        startActivityForResult(newAskIntent, GET_RESPONSE_REQUEST);
    }
}
