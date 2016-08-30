package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import controller.Command;

public class CLI {
	
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> commands;
	private View v;
	
	public CLI(BufferedReader i, PrintWriter o){
		
		this.in=i;
		this.out=o;
		this.commands=new HashMap<String,Command>();
		
	}
	
	public CLI(BufferedReader i, PrintWriter o,HashMap<String,Command> commands){
		
		this.in=i;
		this.out=o;
		this.commands=new HashMap<String,Command>(commands);
		
	}
	
	public void start() throws IOException{
		//create a new thread
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						//ask the user to enter command
						out.println("Please enter your command:");
						out.flush();

						// get the command
						String userCommand = in.readLine();
						Command commandInterface;

						while (!(userCommand.equals("exit"))) {
							// using "get" method to get the value that the hash map is mapping for specific key.
							commandInterface = commands.get(userCommand.split(" ")[0]);

							// if the value of the key "userCommand" in hash map is not empty
							if (commandInterface != null) {
								if (userCommand.split(" ").length > 1) {
									// check substring, the second part of the command from user.
									commandInterface.doCommand(userCommand.substring(userCommand.indexOf(' ') + 1));							
								} else {
									out.println("Invalit input");
									out.flush();
								}
							} else {
								out.println("this command does not exist. Enter new command");
								out.flush();
							}
							// if the value of the key "userCommand" in hash map is null
							out.println("Please enter new command");
							out.flush();
							userCommand = in.readLine();
						}

						commands.get("exit").doCommand("");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		thread.start();
		
	}
	
	//getter and setters for the private variables

	public HashMap<String, Command> getCommands() {
		return commands;
	}

	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}

}
