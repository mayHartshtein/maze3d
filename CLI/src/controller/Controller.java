package controller;

import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
import model.Model;
import view.View;

/**
 * @author may
 * This interface is incharge for passing orders between the
 * view and the model
 * 
 * 
 */

public interface Controller {
	
	public void setModel(Model m);
	public void setView(View v);
	
	
	public void C_displayMessage(String msg);
	public void C_displayCrossSectionByXYZ(String XYZ,String mazeName,int index);
	public void C_solve(String mazeName,String algorithm);
	public void C_saveMaze(String mazeName,String fileName);
	public void C_mazeSize(String mazeName);
	public void C_displayMaze(String mazeName);
	public void C_displayStringArray(String [] args);
	public void C_generate3dMaze(String mazeName,int x,int y, int z);
	public void C_loadMaze(String mazeName,String fileName) throws IOException;
	public void C_fileSize(String mazeName);
	public void C_displaySolution(String mazeName);
	public void C_exit();
	
	
	
	

}
