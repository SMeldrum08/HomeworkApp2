package com.meldrum.utility;

public class Random {

    public static int randomInt(int min, int max) {

	int n = min + (int) (Math.random() * ((max - min) + 1));

	return n;

    }

}
