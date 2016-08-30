package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;

public class MyView implements View {
	
	
	private CLI cli;
	private Controller c;
	protected BufferedReader in;
	protected PrintWriter out;

	protected HashMap<String,Command> commands;

	public MyView(BufferedReader in, PrintWriter out) {
		this.in=in;
		this.out=out;
		///this.setCommands(this.commands);
		
	}

	public MyView(Controller c2) {
		this.setC(c2);
	}

	@Override
	public void V_start() throws IOException {
		
		cli.start();
		
	}


	@Override
	public void V_displayMessegae(String msg){
		out.write(msg);
		out.flush();
		
	}


	@Override
	public void V_sendCommands(HashMap<String, Command> commands) {
		
		this.cli = new CLI(in, out, commands);
		
	}


	
	@Override
	public void V_printMaze2d(int[][] maze2d) {
		
		for (int i = 0; i < maze2d[0].length; i++) {
			for (int j = 0; j < maze2d.length; j++) {
				System.out.print(maze2d[j][i]+" ");
			}
			System.out.println();
		}
		
	}


	@Override
	public void V_printAllMaze3d(Maze3d maze3d) {
		maze3d.printMaze3d();
		
	}


	@Override
	public void V_printDir() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void V_printMazeSize(byte[] b) {
		out.println(b);
		out.flush();
	}


	@Override
	public <T> void V_printDisplaySolution(ArrayList<Solution<T>> posArray) {
		
		if(posArray != null){
			for(int i=0; i< posArray.size();i++)
				out.println(posArray.get(i) + " ");
			out.flush();
		}
		else{
			out.print("The arrayList is empty");
			out.flush();
		}
		
	}

	@Override
	public void V_displayStringArray(String[] args) {
		if(args != null){
			out.println("the path is : ");
			out.flush();
			for(int i=0; i< args.length;i++)
				out.println(args[i] + " ");
			out.flush();
		}
		else{
			out.print("this array is empty.");
			out.flush();
		}
		
	}

	@Override
	public void V_exit() {
		out.println("good bye");
		out.flush();
	}

	public Controller getC() {
		return c;
	}

	public void setC(Controller c) {
		this.c = c;
	}

	public HashMap<String, Command> getCommands() {
		return commands;
	}

	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}

	

}
