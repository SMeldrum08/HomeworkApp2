package com.meldrum.utility;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class HomeworkCreator {

    public static String createImage(String topic, int numberOfQuestions) {
	BufferedImage image = null;
	String encodedImage = null;
	try {
	    URL url = new URL("http://localhost:8080/HomeworkPlus/Resources/Pythag1.png");
	    image = ImageIO.read(url);
	    image = process(image);

	    encodedImage = toByteArray(image);
	} catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	return encodedImage;

    }

    private static BufferedImage process(BufferedImage old) {
	int w = old.getWidth();
	int h = old.getHeight();
	BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2d = img.createGraphics();
	g2d.drawImage(old, 0, 0, null);
	g2d.setPaint(Color.black);
	g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	String s = "10cm";
	g2d.drawString(s, 148, 106);
	g2d.dispose();
	return img;
    }

    private static String toByteArray(BufferedImage image) throws IOException {

	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ImageIO.write(image, "png", baos);
	baos.flush();
	byte[] imageInByte = baos.toByteArray();
	baos.close();

	String encodedImage = Base64.encode(imageInByte);

	return encodedImage;

    }

}
