package com.meldrum.utility;

import java.io.IOException;
import java.util.ArrayList;

import com.meldrum.domain.shape.StandardQuestionWrapper;
import com.meldrum.utility.shape.PythagStandardQuestionCreator;

public class HomeworkCreator {

    public static StandardQuestionWrapper createQuestion(String topic, int numberOfQuestions) {
	ArrayList<StandardQuestionWrapper> questions = new ArrayList<StandardQuestionWrapper>();

	StandardQuestionWrapper question = new StandardQuestionWrapper();

	try {
	    question = PythagStandardQuestionCreator.pythagStandardQuestion(1);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return question;

    }

}
