package ca.csci4100u.nathaniel.asmt1_nathanielyearwood_and_andrewwatton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AskQuestion extends AppCompatActivity {

    String response = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);
    }

    public void SelectResponse(View v) {
        response = "button clicked"; //button.getText();        // ummmm idk wat I'm doing, make this get the text from whichever button was clicked???

        Intent resultIntent = new Intent(Intent.ACTION_PICK);
        resultIntent.putExtra("response", response);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

}
