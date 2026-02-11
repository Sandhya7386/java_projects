package com.gqt_java.java_gqt.project;
public class Question {
    String text;
    String[] options;
    int correctAnswer;
    String audiencePoll;

    public Question(String text, String[] options, int correctAnswer, String audiencePoll) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.audiencePoll = audiencePoll;
    }
}

