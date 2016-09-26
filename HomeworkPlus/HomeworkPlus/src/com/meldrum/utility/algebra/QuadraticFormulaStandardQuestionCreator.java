package com.meldrum.utility.algebra;

import java.util.ArrayList;

import com.meldrum.domain.shape.StandardQuestionWrapper;
import com.meldrum.utility.PrepareQuestionInfo;
import com.meldrum.utility.Random;

public class QuadraticFormulaStandardQuestionCreator {

    public static StandardQuestionWrapper quadraticFormulaStandardQuestion(int questionNumber) {

	StandardQuestionWrapper question = new StandardQuestionWrapper();

	/*
	 * This works but need to prepare for unanswerable questions by using
	 * discriminant check
	 *
	 */
	int[] coefs = { Random.randomInt(1, 8), Random.randomNonZeroInt(-8, 10), Random.randomNonZeroInt(-8, 10) };

	ArrayList<String> coefsStr = PrepareQuestionInfo.createViewedQuestionArray(coefs);

	String quadEquation = coefsStr.get(0) + "<i>x</i><sup>2</sup> " + coefsStr.get(1) + "<i>x</i> "
		+ coefsStr.get(2) + " = 0";

	String[] preImageLines = { "Solve the equation" };
	String[] postImageLines = { "Give your solutions correct to 2 decimal places" };

	question.setQuestionNumber("<b>" + questionNumber + ".</b>");
	question.setPreImageLines(preImageLines);
	question.setCentralEquation(quadEquation);
	question.setPostImageLines(postImageLines);
	question.setAnswerBox("<i>x</i> = ...................  or <i>x</i> = ...................");

	return question;

    }

    private static double[] workOutAnswer(int[] coefficients) {

	int a = coefficients[0];
	int b = coefficients[1];
	int c = coefficients[2];

	double positiveAnswer = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
	double negativeAnswer = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

	double[] answers = { positiveAnswer, negativeAnswer };

	return answers;

    }
}
