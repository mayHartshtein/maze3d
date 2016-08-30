package model;

import java.io.IOException;

/**
 * @author may
 * This intefacec is incharge of all the algorithms actions
 *
 */

public interface Model {

	//search problem 
	//public void search(problem p);
	//for the protocol
	
	
	public void M_dir(String path);
	public void M_generate3dMaze(String mazeName,int x,int y,int z);//done
	public void M_display(String mazeName);
	public void M_displayCrossSectionByXYZ(String XYZ,String mazeName, int index);//done?
	public void M_saveMaze(String mazeName,String fileName);
	public void M_loadMaze(String mazeName,String fileName) throws IOException;
	public void M_mazeSize(String mazeName);
	public void M_fileSize(String fileName);
	public void M_solve(String mazeName,String algorithm);
	public void M_displaySolution(String mazeName);
	public void M_exit();
	
	
	
	
}
