package com.meldrum.utility.shape;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.meldrum.domain.ImageLengthWrapper;
import com.meldrum.domain.shape.PythagStandardQuestionWrapper;
import com.meldrum.utility.ImageCreator;
import com.meldrum.utility.Random;

public class PythagStandardQuestionCreator {

    public static PythagStandardQuestionWrapper pythagStandardQuestion() throws IOException {

	int VALUES_MIN = 1;
	int VALUES_MAX = 50;
	String[] pythagImages = { "pythag1.png", "pythag2.png", "pythag3.png" };
	String xValue = "x";

	PythagStandardQuestionWrapper question = new PythagStandardQuestionWrapper();
	// int imageUsed = Random.randomInt(0, 2);
	int imageUsed = 0;

	// URL url = new URL("http://localhost:8080/HomeworkPlus/Resources/" +
	// pythagImages[imageUsed]);
	URL url = new URL("http://localhost:8080/HomeworkPlus/Resources/Pythag1.png");
	BufferedImage image = ImageIO.read(url);

	ArrayList<ImageLengthWrapper> lengthList = new ArrayList<ImageLengthWrapper>();

	int value1 = Random.randomInt(VALUES_MIN, VALUES_MAX);
	int value2 = Random.randomInt(VALUES_MIN, VALUES_MAX);

	ImageLengthWrapper length1 = new ImageLengthWrapper(148, 106, value1);
	ImageLengthWrapper length2 = new ImageLengthWrapper(150, 255, value2);

	lengthList.add(length1);
	lengthList.add(length2);

	String encodedImage = ImageCreator.processImageThenEncode(image, lengthList);

	question.setEncodedQuestionImage(encodedImage);

	return question;
    }

}
