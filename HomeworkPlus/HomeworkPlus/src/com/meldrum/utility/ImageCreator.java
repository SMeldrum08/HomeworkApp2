package com.meldrum.utility;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.meldrum.domain.ImageLengthWrapper;

public class ImageCreator {

    public static BufferedImage process(BufferedImage old, ArrayList<ImageLengthWrapper> lengths) {
	int w = old.getWidth();
	int h = old.getHeight();
	BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2d = img.createGraphics();
	g2d.drawImage(old, 0, 0, null);
	g2d.setPaint(Color.black);
	g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	for (ImageLengthWrapper length : lengths) {
	    addLength(g2d, length);
	}

	g2d.dispose();
	return img;
    }

    public static void addLength(Graphics2D g2d, ImageLengthWrapper length) {
	String s = length.getNumber() + length.getUnit();
	g2d.drawString(s, length.getX(), length.getY());

    }

}
