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

    public static PythagStandardQuestionWrapper pythagStandardQuestion() throws IOException {

	int VALUES_MIN = 1;
	int VALUES_MAX = 50;
	String[] pythagImages = { "Pythag1.png", "Pythag2.png", "Pythag3.png" };
	String xValue = "x";

	ImageLengthWrapper lengthLong = null;
	ImageLengthWrapper length2 = null;
	ImageLengthWrapper length3 = null;

	PythagStandardQuestionWrapper question = new PythagStandardQuestionWrapper();
	// int imageUsed = Random.randomInt(0, 2);
	int imageUsed = 0;

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

	if (imageUsed == 0) {
	    lengthLong = new ImageLengthWrapper(148, 106, values.get(0));
	    length2 = new ImageLengthWrapper(150, 255, values.get(1));
	    length3 = new ImageLengthWrapper(457, 129, values.get(2));
	}

	lengthList.add(lengthLong);
	lengthList.add(length2);
	lengthList.add(length3);

	String encodedImage = ImageCreator.processImageThenEncode(image, lengthList);

	question.setEncodedQuestionImage(encodedImage);

	return question;
    }

}
