package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Command;

/**
 * @author may
 * This interface is incharge of the input from the user and his view
 * 
 */

public interface View {

	public void V_start() throws IOException;
	public void V_displayStringArray(String [] args);
	public void V_displayMessegae(String msg);
	public void V_sendCommands(HashMap<String, Command> commands);
	public void V_printMaze2d(int [][] maze2d);//done
	public <T> void V_printDisplaySolution(ArrayList<Solution<T>> posArray);
	public void V_printMazeSize(byte[] b);//done
	public void V_printAllMaze3d(Maze3d maze3d);
	public void V_printDir();
	public void V_exit();
}
