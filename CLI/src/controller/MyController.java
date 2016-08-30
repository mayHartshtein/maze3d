package controller;

import java.util.HashMap;


import controller.commands.Display;
import controller.commands.DisplayCrossSectionByXYZ;
import controller.commands.DisplaySolution;
import controller.commands.Exit;
import controller.commands.FileSize;
import controller.commands.Generate3dMaze;
import controller.commands.LoadMaze;
import controller.commands.MazeSize;
import controller.commands.SaveMaze;
import controller.commands.Solve;
import model.Model;
import view.View;

public class MyController implements Controller {
	
	private Model m;
	private View v;
	private HashMap<String, Command> commands;
	
	public MyController(Model m,View v){
		this.m=m;
		this.v=v;
				
	}

	@Override
	public void setModel(Model m) {
		this.m=m;
		
	}

	@Override
	public void setView(View v) {
		this.v=v;
		
	this.commands=new HashMap<String,Command>(null);
		
		this.commands.put("solve",new Solve(this));
		this.commands.put("display", new Display(this));
		this.commands.put("displayCrossSectionByXYZ", new DisplayCrossSectionByXYZ(this));
		this.commands.put("displaySolution", new DisplaySolution(this));
		this.commands.put("exit", new Exit(this));
		this.commands.put("fileSize", new FileSize(this));
		this.commands.put("generate3dMaze", new Generate3dMaze(this));
		this.commands.put("loadMaze", new LoadMaze(this));
		this.commands.put("mazeSize", new MazeSize(this));
		this.commands.put("saveMaze", new SaveMaze(this));
		this.commands.put("solve", new Solve(this));
		v.V_sendCommands(commands);
		
	}

	@Override
	public void C_displayMessage(String msg) {
		v.V_displayMessegae(msg);
		
	}

	@Override
	public void C_displayCrossSectionByXYZ(String XYZ,String mazeName,int index) {
		this.m.M_displayCrossSectionByXYZ(XYZ, mazeName, index);
		
	}


	@Override
	public void C_displayMaze(String mazeName) {
		this.m.M_display(mazeName);
		
	}

	@Override
	public void C_solve(String mazeName, String algorithm) {
		m.M_solve(mazeName, algorithm);
		
	}

	@Override
	public void C_displayStringArray(String[] args) {
		this.v.V_displayStringArray(args);
		
	}

	@Override
	public void C_generate3dMaze(String mazeName, int x, int y, int z) {
		this.m.M_generate3dMaze(mazeName, x, y, z);
		
	}

	@Override
	public void C_saveMaze(String mazeName, String fileName) {
		this.m.M_saveMaze(mazeName, fileName);
		
	}

	@Override
	public void C_mazeSize(String mazeName) {
		this.m.M_mazeSize(mazeName);
		
	}

	@Override
	public void C_exit() {
		v.V_exit();
		m.M_exit();
		
	}

	@Override
	public void C_displaySolution(String mazeName) {
		m.M_displaySolution(mazeName);
		
	}

	@Override
	public void C_fileSize(String fileName) {
		this.m.M_fileSize(fileName);
		
	}

	@Override
	public void C_loadMaze(String mazeName, String fileName){
		//this.m.M_loadMaze(mazeName, fileName);
		
	}

}
