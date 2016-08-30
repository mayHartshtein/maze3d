package controller.commands;

import controller.Controller;
import controller.abstractCommand;

public class Solve extends abstractCommand {
	

	//c'tor
	public Solve(Controller c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		if (tempArray.length != 2) {
			c.C_displayMessage("parameters error");
		} else {
			String mazeName = tempArray[0];
			String searchAlgorithm = tempArray[1];
			c.C_solve(mazeName, searchAlgorithm);
		}
	}

	}
