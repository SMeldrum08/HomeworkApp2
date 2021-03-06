package com.meldrum.domain.shape;

public class StandardQuestionWrapper {

    String questionNumber;
    String encodedQuestionImage;
    String notAccurate = "Diagram <b>NOT</b> accurately drawn";
    String centralEquation;
    String[] preImageLines;
    String[] postImageLines;
    String answerBox;
    String answer;

    public String getQuestionNumber() {
	return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
	this.questionNumber = questionNumber;
    }

    public String getEncodedQuestionImage() {
	return encodedQuestionImage;
    }

    public void setEncodedQuestionImage(String encodedQuestionImage) {
	this.encodedQuestionImage = encodedQuestionImage;
    }

    public String getNotAccurate() {
	return notAccurate;
    }

    public void setNotAccurate(String notAccurate) {
	this.notAccurate = notAccurate;
    }

    public String getCentralEquation() {
	return centralEquation;
    }

    public void setCentralEquation(String centralEquation) {
	this.centralEquation = centralEquation;
    }

    public String[] getPreImageLines() {
	return preImageLines;
    }

    public void setPreImageLines(String[] preImageLines) {
	this.preImageLines = preImageLines;
    }

    public String getAnswerBox() {
	return answerBox;
    }

    public void setAnswerBox(String answerBox) {
	this.answerBox = answerBox;
    }

    public String getAnswer() {
	return answer;
    }

    public void setAnswer(String answer) {
	this.answer = answer;
    }

    public String[] getPostImageLines() {
	return postImageLines;
    }

    public void setPostImageLines(String[] postImageLines) {
	this.postImageLines = postImageLines;
    }

}
