package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = findViewById(R.id.list);
        ArrayList<Question> arrayList = new ArrayList<Question>();

        arrayList.add(new Question(1,"1. What is the capital city of Poland?", new String[]{"Versailes", "Amsterdam", "Warsaw", "Germain"},"Warsaw"));
        arrayList.add(new Question(2,"2. What was the most downloaded app of the 2020?", new String[]{"Ticktock", "zoom", "Facebook", "Slack"},"Ticktock"));
        arrayList.add(new Question(3,"3. Europe is separated from Africa by which sea?", new String[]{"Atlantic", "pacific", "Mediterranean", "Red sea"},"Mediterranean"));
        arrayList.add(new Question(4,"4. Who is the only person in the Uk who is allowed to drive without a license?", new String[]{"The Prime minister", "The queen", "The Prince", "The King"},"The queen"));
        arrayList.add(new Question(5,"5. What is the color of a giraffes tongue?", new String[]{"pink", "green", "red", "blue"},"blue"));
        arrayList.add(new Question(6,"6. Which year was the premier league founded?", new String[]{"1990", "1992", "1994", "1800"},"1992"));

        CustomListAdapter customListAdapter = new CustomListAdapter(this,arrayList);
        list.setAdapter(customListAdapter);

        Button button = (Button) findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,results.class);
                intent.putExtra("score",customListAdapter.getCorrectScore());
                startActivity(intent);
            }
        });



    }

}