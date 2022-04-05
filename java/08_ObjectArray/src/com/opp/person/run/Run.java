package com.opp.person.run;

import com.opp.person.controller.PersonController;

public class Run {

	public static void main(String[] args) {
		PersonController pc = new PersonController();
		pc.inputData();
		pc.printData();
		pc.avrDate();
	}

}
