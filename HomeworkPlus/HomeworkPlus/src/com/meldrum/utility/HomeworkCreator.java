package com.meldrum.utility;

import java.io.IOException;

import com.meldrum.domain.shape.PythagStandardQuestionWrapper;
import com.meldrum.utility.shape.PythagStandardQuestionCreator;

public class HomeworkCreator {

    public static PythagStandardQuestionWrapper createQuestion(String topic, int numberOfQuestions) {
	PythagStandardQuestionWrapper question = new PythagStandardQuestionWrapper();
	try {

	    question = PythagStandardQuestionCreator.pythagStandardQuestion(1);

	} catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	return question;

    }

}
