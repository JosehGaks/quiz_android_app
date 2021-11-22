package com.example.myapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter implements ListAdapter {
    ArrayList<Question> arrayList;
    Context context;
    public RadioButton radioButton;
    ArrayList<Integer> answersQuestions = new ArrayList<>();

    public int correctScore = 0;
    private int incorrectScore = 0;

    public CustomListAdapter(Context context, ArrayList<Question> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Question questionData = arrayList.get(position);
        if (view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_item,null);

            TextView question = view.findViewById(R.id.question);
            question.setText(questionData.question);

            RadioGroup answers = view.findViewById(R.id.answers);
            RadioButton answers1 = view.findViewById(R.id.answer1);
            answers1.setText(questionData.answers[0]);
            RadioButton answers2 = view.findViewById(R.id.answer2);
            answers2.setText(questionData.answers[1]);
            RadioButton answers3 = view.findViewById(R.id.answer3);
            answers3.setText(questionData.answers[2]);
            RadioButton answers4 = view.findViewById(R.id.answer4);
            answers4.setText(questionData.answers[3]);

            answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                    radioButton = radioGroup.findViewById(checkedId);
                    String radioValue = radioButton.getText().toString();

                    //This compares the answer from radiobutton with the answer in the database

                    if (radioValue.equals(questionData.answer) ){
                                correctScore += 1;


                    }
                    else{
                        if(radioValue.isEmpty()){
                            Toast.makeText(context, "please answer all questions", Toast.LENGTH_SHORT).show();
                        }
                        //Toast.makeText(context, questionData.answer, Toast.LENGTH_SHORT).show();
                        correctScore += 0;
                    }

                    }
            });




        }
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public int getCorrectScore() {
        return correctScore;
    }


}
