package controller.commands;

import controller.Controller;
import controller.abstractCommand;

public class Generate3dMaze extends abstractCommand {

	
	//C'TOR
	public Generate3dMaze(Controller c){
		super(c);
	}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		if(tempArray.length == 4){
			
					int x, y, z;
					try{
						x = Integer.parseInt(tempArray[1]);
						y = Integer.parseInt(tempArray[2]);
						z = Integer.parseInt(tempArray[3]);
					this.c.C_generate3dMaze(tempArray[4], x, y, z);
					}
					catch (NumberFormatException e){
						this.c.C_displayMessage("wrong");
					}
				}
		else {
			this.c.C_displayMessage("wrong length");
		}
		

	}

}
