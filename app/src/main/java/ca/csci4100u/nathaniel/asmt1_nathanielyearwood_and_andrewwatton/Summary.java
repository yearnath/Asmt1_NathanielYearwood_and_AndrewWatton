package ca.csci4100u.nathaniel.asmt1_nathanielyearwood_and_andrewwatton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int numYes=0;
        int numNo=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        //get answers from MainMenu activity
        TextView summaryText = (TextView)findViewById(R.id.summaryText);
        int[] data= getIntent().getIntArrayExtra("responses");

        // count # of each answer before printing
        for (int i=0; i<data.length; i++){
            if (data[i] == 0){
                numNo++;
            }else if(data[i]==1 ){
                numYes++;
            }
        }

        summaryText.setText("Yes:"+ numYes + "\n\nNo:" + numNo );
    }
}
