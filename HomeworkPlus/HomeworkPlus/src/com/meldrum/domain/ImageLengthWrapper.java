package com.meldrum.domain;

import com.meldrum.utility.Random;

public class ImageLengthWrapper {

    int x;
    int y;
    int number;
    String unit;

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public String getUnit() {
	return unit;
    }

    public void setUnit(String unit) {
	this.unit = unit;
    }

    public ImageLengthWrapper(int x, int y, int number) {

	this.x = x;
	this.y = y;
	this.number = number;

	String[] units = { "cm", "m", "km" };

	this.unit = units[Random.randomInt(0, units.length - 1)];

    }

}
