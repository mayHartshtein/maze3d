package controller.commands;


import controller.Controller;
import controller.abstractCommand;


public class MazeSize extends abstractCommand {
	
	
	//C'TOR
	public MazeSize(Controller c){
		super(c);
		
	}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		if (tempArray.length != 2) {
			this.c.C_displayMessage("wrong input");
		} else {
			String nameMaze = tempArray[1];
			this.c.C_mazeSize(nameMaze);
		}

	}

}
