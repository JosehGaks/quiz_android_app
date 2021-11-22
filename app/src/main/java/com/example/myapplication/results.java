package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txt = (TextView) findViewById(R.id.txt);
        TextView score = (TextView) findViewById(R.id.score);
        TextView ranking = (TextView) findViewById(R.id.rank);
        Button retry = (Button) findViewById(R.id.retry);

        Intent intent = getIntent();

        int total_score = intent.getIntExtra("score",0);
        if (total_score >= 5){
            ranking.setText("Great work");
        }
        else if(total_score>2 && total_score<=4){
            ranking.setText("Good work");
        }
        else{
            ranking.setText("good trial");
        }
        String to ="You scored "+ total_score + "/6";

        score.setText(to);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(results.this,MainActivity.class));
            }
        });

    }
}