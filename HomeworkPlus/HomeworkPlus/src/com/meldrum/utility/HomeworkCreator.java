package com.meldrum.utility;

import java.io.IOException;
import java.util.ArrayList;

import com.meldrum.domain.shape.StandardQuestionWrapper;
import com.meldrum.utility.shape.PythagStandardQuestionCreator;

public class HomeworkCreator {

    public static ArrayList<StandardQuestionWrapper> createQuestion(String topic, int numberOfQuestions) {
	ArrayList<StandardQuestionWrapper> questions = new ArrayList<StandardQuestionWrapper>();

	StandardQuestionWrapper question = new StandardQuestionWrapper();

	try {
	    for (int n = 1; n < numberOfQuestions + 1; n++) {
		question = PythagStandardQuestionCreator.pythagStandardQuestion(n);
		questions.add(question);
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return questions;

    }

}
