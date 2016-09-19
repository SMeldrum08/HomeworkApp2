package com.meldrum.utility;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HomeworkCreator {

    public static BufferedImage createImage(String topic, int numberOfQuestions) {
	BufferedImage image = null;
	try {
	    image = ImageIO.read(new File("./HomeworkPlus/WebContent/Resources/Pythag1.png"));
	    Graphics g = image.getGraphics();
	    g.setFont(g.getFont().deriveFont(30f));
	    g.drawString("Hi there!", 10, 10);
	    g.dispose();
	} catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	return image;

    }

}
