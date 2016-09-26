package com.meldrum.domain;

public class HomeworkWrapper {

    String[] questionType;
    int[] numberOfQuestions;

    public String[] getQuestionType() {
	return questionType;
    }

    public String getQuestionType(int n) {

	return this.questionType[n];
    }

    public void setQuestionType(String[] questionType) {
	this.questionType = questionType;
    }

    public int[] getNumberOfQuestions() {
	return numberOfQuestions;
    }

    public int getNumberOfQuestions(int n) {

	return this.numberOfQuestions[n];
    }

    public void setNumberOfQuestions(int[] numberOfQuestions) {
	this.numberOfQuestions = numberOfQuestions;
    }

}
