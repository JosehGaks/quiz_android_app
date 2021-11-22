package com.example.myapplication;

public class Question {
    String question;
    int id;
    String[] answers;
    String answer;


    public Question(int id, String question, String[] answers, String answer) {
        this.question = question;
        this.id = id;
        this.answers = answers;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
