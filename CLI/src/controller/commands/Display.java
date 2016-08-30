package controller.commands;

import controller.Command;
import controller.Controller;
import controller.abstractCommand;
import model.Model;

public class Display extends abstractCommand {
	
	//c'tor
	public Display(Controller c){
		super(c);
	}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		if (tempArray.length != 2) {
			this.c.C_displayMessage("wromg input");
		} else {
			String mazeName = tempArray[1];
			this.c.C_displayMaze(mazeName);
		}


	}

}
