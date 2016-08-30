package controller.commands;


import controller.Controller;
import controller.abstractCommand;


public class SaveMaze extends abstractCommand {

	
	//C'TOR
	public SaveMaze(Controller c){
		super(c);
	}

	@Override
	public void doCommand(String args) {
	
		String[] tempArray = args.split(" ");
		if(tempArray.length != 2){
			this.c.C_displayMessage("wrong");
		}
		else {
			String mazeName = tempArray[0];
			String fileName = tempArray[1];
			this.c.C_saveMaze(mazeName, fileName);
		}
	}

}
