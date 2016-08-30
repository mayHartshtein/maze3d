package controller.commands;

import java.io.File;

import controller.Controller;
import controller.abstractCommand;


public class Dir extends abstractCommand {
	
	//C'TOR
	public Dir(Controller c){
		super(c);
		
	}
	
	@Override
	public void doCommand(String args) {	

		if(args == null)
			this.c.C_displayMessage("wrong input");
		else{
			try {
				File file = new File(args);
				if(file.list().length == 0)
					this.c.C_displayMessage("empty file error");
				else
					this.c.C_displayStringArray(file.list());
			}
			catch (NullPointerException e){
			this.c.C_displayMessage("wrong path");
		}
	}
	
	}
	
}
