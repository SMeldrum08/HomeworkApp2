package com.meldrum.utility.shape;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

import com.meldrum.domain.ImageLengthWrapper;
import com.meldrum.domain.shape.PythagStandardQuestionWrapper;
import com.meldrum.utility.ImageCreator;
import com.meldrum.utility.Random;

public class PythagStandardQuestionCreator {

    static String xValue = "x";

    public static PythagStandardQuestionWrapper pythagStandardQuestion() throws IOException {

	int VALUES_MIN = 1;
	int VALUES_MAX = 50;
	String[] pythagImages = { "Pythag1.png", "Pythag2.png", "Pythag3.png" };

	ImageLengthWrapper lengthLong = null;
	ImageLengthWrapper length2 = null;
	ImageLengthWrapper length3 = null;

	PythagStandardQuestionWrapper question = new PythagStandardQuestionWrapper();
	int imageUsed = Random.randomInt(0, 2);
	// int imageUsed = 0;

	URL url = new URL("http://localhost:8080/HomeworkPlus/Resources/" + pythagImages[imageUsed]);
	BufferedImage image = ImageIO.read(url);

	ArrayList<ImageLengthWrapper> lengthList = new ArrayList<ImageLengthWrapper>();

	int value1 = Random.randomInt(VALUES_MIN, VALUES_MAX);
	int value2 = Random.randomInt(VALUES_MIN, VALUES_MAX);
	String value1AsString = "" + value1;
	String value2AsString = "" + value2;

	ArrayList<String> values = new ArrayList<String>();
	values.add(value1AsString);
	values.add(value2AsString);
	values.add(xValue);
	Collections.shuffle(values);
	values = checkLargestNumberIsLongestSide(values);
	double answer = workOutAnswer(values);

	if (imageUsed == 0) {
	    lengthLong = new ImageLengthWrapper(148, 106, values.get(0));
	    length2 = new ImageLengthWrapper(150, 255, values.get(1));
	    length3 = new ImageLengthWrapper(457, 129, values.get(2));
	} // (192,261) (116,124)(364,135)
	if (imageUsed == 1) {
	    lengthLong = new ImageLengthWrapper(192, 261, values.get(0));
	    length2 = new ImageLengthWrapper(116, 124, values.get(1));
	    length3 = new ImageLengthWrapper(364, 135, values.get(2));
	} // Pythag3: (140,127) (105,266) (7,138)
	if (imageUsed == 2) {
	    lengthLong = new ImageLengthWrapper(140, 127, values.get(0));
	    length2 = new ImageLengthWrapper(105, 266, values.get(1));
	    length3 = new ImageLengthWrapper(7, 138, values.get(2));
	}

	lengthList.add(lengthLong);
	lengthList.add(length2);
	lengthList.add(length3);

	String encodedImage = ImageCreator.processImageThenEncode(image, lengthList);

	question.setEncodedQuestionImage(encodedImage);
	question.setAnswer("The answer is " + answer);

	return question;
    }

    public static ArrayList<String> checkLargestNumberIsLongestSide(ArrayList<String> values) {
	if (!values.get(0).equals(xValue)) {
	    if (values.get(1).equals(xValue)) {
		int v1 = Integer.parseInt(values.get(0));
		int v2 = Integer.parseInt(values.get(2));
		if (v2 > v1) {
		    values.set(0, "" + v2);
		    values.set(2, "" + v1);
		}
	    }
	    if (values.get(2).equals(xValue)) {
		int v1 = Integer.parseInt(values.get(0));
		int v2 = Integer.parseInt(values.get(1));
		if (v2 > v1) {
		    values.set(0, "" + v2);
		    values.set(1, "" + v1);
		}
	    }

	}
	return values;
    }

    public static double workOutAnswer(ArrayList<String> values) {
	double answer = 0;
	int v1 = 0;
	int v2 = 0;
	if (values.get(0).equals(xValue)) {
	    v1 = Integer.parseInt(values.get(1));
	    v2 = Integer.parseInt(values.get(2));

	    answer = Math.sqrt(v1 * v1 + v2 * v2);
	} else {
	    if (values.get(1).equals(xValue)) {
		v1 = Integer.parseInt(values.get(0));
		v2 = Integer.parseInt(values.get(2));
	    } else if (values.get(2).equals(xValue)) {
		v1 = Integer.parseInt(values.get(0));
		v2 = Integer.parseInt(values.get(1));
	    }
	    answer = Math.sqrt(v1 * v1 - v2 * v2);
	}

	return answer;

    }

}
