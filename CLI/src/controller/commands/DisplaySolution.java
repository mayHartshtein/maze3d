package controller.commands;


import controller.Controller;
import controller.abstractCommand;

public class DisplaySolution extends abstractCommand {
	
	//C'TOR
	public DisplaySolution(Controller c){
		super(c);
	}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		if (tempArray.length != 2) {
			this.c.C_displayMessage("wrong input");
		} else {
			String mazeName = tempArray[1];
			this.c.C_displaySolution(mazeName);
		}
	}

}
