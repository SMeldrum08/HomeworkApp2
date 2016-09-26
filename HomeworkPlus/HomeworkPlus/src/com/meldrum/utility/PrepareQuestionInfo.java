package com.meldrum.utility;

import java.util.ArrayList;

public class PrepareQuestionInfo {

    public static String turnIntToStringWithSign(int n) {

	String result = "";

	if (n > 0) {
	    result = "+ " + n;
	}

	else if (n < 0) {
	    n = n * (-1);
	    result = "- " + n;
	}

	return result;

    }

    public static ArrayList<String> createViewedQuestionArray(int[] initial) {

	ArrayList<String> array = new ArrayList<String>();

	for (int n = 0; n < initial.length; n++) {
	    if (n == 0) {
		array.add("" + initial[n]);
	    } else {
		array.add(turnIntToStringWithSign(initial[n]));
	    }

	}

	return array;

    }

}
