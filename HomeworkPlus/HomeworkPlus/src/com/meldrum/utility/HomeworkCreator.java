package com.meldrum.utility;

import java.io.IOException;
import java.util.ArrayList;

import com.meldrum.domain.shape.StandardQuestionWrapper;
import com.meldrum.utility.algebra.QuadraticFormulaStandardQuestionCreator;
import com.meldrum.utility.shape.PythagStandardQuestionCreator;

public class HomeworkCreator {

    public static ArrayList<StandardQuestionWrapper> createQuestion(String[] topic, int[] numberOfQuestions) {
	ArrayList<StandardQuestionWrapper> questions = new ArrayList<StandardQuestionWrapper>();
	StandardQuestionWrapper question = new StandardQuestionWrapper();

	int n = 1;

	for (int k = 0; k < topic.length; k++) {
	    int lastQ = n + numberOfQuestions[k];

	    if (topic[k].equals("pythagoras")) {

		try {
		    for (int m = n; m < lastQ; m++) {
			question = PythagStandardQuestionCreator.pythagStandardQuestion(m);
			questions.add(question);
			n = m;
		    }

		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    } else if (topic[k].equals("quadFormula")) {
		for (int m = n; m < lastQ; m++) {
		    question = QuadraticFormulaStandardQuestionCreator.quadraticFormulaStandardQuestion(m);
		    questions.add(question);
		    n = m;
		}

	    }
	    n = n + 1;
	}

	return questions;

    }

}
