package controller.commands;


import controller.Controller;
import controller.abstractCommand;

public class Exit extends abstractCommand {

	
	//C'TOR
	public Exit(Controller c){
		super(c);

	}

	@Override
	public void doCommand(String args) {
		this.c.C_exit();
	}

}
