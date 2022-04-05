package com.api.calendar;

import java.text.DecimalFormat;

public class MathStudy {

	public static void main(String[] args) {
		
		double[] arr = {3456.5324 , 577.26784 , 552.2987, -845.215, 324456.24497};
		String result = "" ;

		DecimalFormat df = new DecimalFormat("#.#");
		result += "1. [" + (df.format(Math.ceil(arr[0] * 10) / 10.0 )) + "]\n";
		
		df = new DecimalFormat("#.##");
		result += "2. [" + (df.format(Math.round(arr[1] * 100) / 100.0)) + "]\n";
		
		df = new DecimalFormat("#.###");
		result += "3. [" + (df.format(Math.ceil(arr[2] * 1000) / 1000.0)) + "]\n";
		
		df = new DecimalFormat("#.#");
		result += "4. [" + (df.format(Math.floor(arr[3] * 10) / 10.0 )) + "]\n";

		df = new DecimalFormat("#.##");
		result += "5. [" + (df.format(Math.ceil(arr[4] * 100) / 100.0 )) + "]\n";
		
		
		System.out.println(result);
		
		
	}

}
