package model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Solution;
import algorithms.search.searchable;
import algorithms.search.searcher;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
/**
 * @author may
 * @param 
 *
 *
 */
public class MyModel implements Model {
	
	private Controller c;
	//for all the user mazes
	private HashMap<String, Maze3d> mazes;
	//for the maze solutions
	private HashMap<String,Solution<Position>> solutions;
	//for all the open threads
	private ArrayList<Thread> threads;
	//for all the open files 
	private ArrayList<File> files ;
	
	
	
	//c'tor
	public MyModel() {
		this.mazes=new HashMap<String, Maze3d>();
		this.solutions=new  HashMap<String,Solution<Position>>();
		this.threads = new ArrayList<Thread>();
		this.files= new ArrayList<File>();
	}
	

	@Override
	public void M_dir(String path) {
	
		File file=new File(path.toString());
		if(file.isFile())
			c.C_displayMessage(file.toString());	

		else{
				for (File f : file.listFiles())
				{
					c.C_displayMessage(f.toString());
				}
		
			}
	}

	/**
	 * 
	 * @param mazeName
	 * @param x
	 * @param y
	 * @param z
	 */
	@Override
	public void M_generate3dMaze(String mazeName, int x, int y, int z) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//create the maze3d
				MyMaze3dGenerator mg=new MyMaze3dGenerator();
				Maze3d maze=mg.generate(x, y, z);
				//add the maze to the hashMap for the all mazes
				mazes.put(mazeName,maze);
				c.C_displayMessage("maze "+ mazeName+" is ready");
				
			}
		}) ;
		thread.start();	
		threads.add(thread);
}

		

	/**
	 * this methos print the maze
	 * @param mazeName
	 */

	@Override
	public void M_display(String mazeName) {
		
		if(!mazes.containsKey(mazeName))
			{
			c.C_displayMessage("there is no such maze in this name");
		
			}	
		else{
			Maze3d maze= mazes.get(mazeName);
			//this.c.C_displayMessage(maze.printMaze3d(););
		
		}
	}

	@Override
	public void M_displayCrossSectionByXYZ(String XYZ,String mazeName, int index) {
		if(!mazes.containsKey(mazeName))
		{
			c.C_displayMessage("there is no such maze in this name");
		}
		else{	
			
			Maze3d maze=mazes.get(mazeName);
			int[][] maze2d;
			if(XYZ.equals("X") || XYZ.equals("x")){
				maze2d=maze.getCrossSectionByX(index);
				}
			else if(XYZ.equals("Y") || XYZ.equals("y")){
				maze2d=maze.getCrossSectionByY(index);
			}
			else if(XYZ.equals("Z") || XYZ.equals("z")){
				maze2d=maze.getCrossSectionByZ(index);
			}
			else{
				this.c.C_displayMessage("wrong input of XYZ");
			}
			
			//not finished
			this.c.C_displayMessage("print the maze2d the new one");
		
		}
		
		
	}


	@Override
	public void M_saveMaze(String mazeName, String fileName) {
		
		if(!mazes.containsKey(mazeName)){
			c.C_displayMessage("there is no such maze in this name ");
		}
		else{
			try{
			// writing the maze by byteArray into file.
			Maze3d maze= mazes.get(mazeName); 
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
			out.write(maze.toByreArray(maze));
			out.close();
			this.c.C_displayMessage("Maze " + mazeName + " is saved successfully in the file " + fileName);
			// handle exceptions.
		} catch (FileNotFoundException e) {
			this.c.C_displayMessage("The " + fileName + " isn't exist");
		} catch (IOException e) {
			this.c.C_displayMessage("this maze isn't success to save");
		}
			
		}
	}

	@Override
	public void M_loadMaze(String mazeName, String fileName) throws IOException {


		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			int size = in.read();
			size *= 255;
			size += in.read();
			byte[] b =new byte[size];
			in.read(b);
			in.close();
			Maze3d maze=new Maze3d(b);
			mazes.put(mazeName, maze);
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void M_mazeSize(String mazeName) {
	
		if(!mazes.containsKey(mazeName)){
			c.C_displayMessage("there is no such maze in this name");
		}
		else{
			Maze3d maze=mazes.get(mazeName);
			int sizeX = 4 * maze.getX();
			int sizeY = 4 * maze.getY();
			int sizeZ = 4 * maze.getZ();
			int allMazeSize = sizeX + sizeY + sizeZ + 36;
			
			this.c.C_displayMessage("The size of " + mazeName + " is: " + allMazeSize);	
			
		}
	}

	@Override
	public void M_fileSize(String mazeName) {
		Maze3d maze3d = mazes.get(mazeName);
		if (maze3d == null)
			this.c.C_displayMessage("there is no such maze");
		else {
			// local variables output stream
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			MyCompressorOutputStream out = new MyCompressorOutputStream(byteArrayOut);
			try {
				out.write(maze3d.toByreArray(maze3d));
				this.c.C_displayMessage("The size of " + mazeName + "  in file is: " + byteArrayOut.size());
			} catch (IOException e) {
				this.c.C_displayMessage("Couldn't write the " + mazeName + " maze to file");
			}
		}
		
	}

	@Override
	public void M_solve(String mazeName, String algorithm) {
		Thread thread=new Thread(new Runnable() {

			@Override
			public void run() {
				// get the maze from hashMap
				Maze3d maze3d = mazes.get(mazeName);
				if (maze3d == null)
					c.C_displayMessage("there is no such maze in the hashmap");
				else {
					// local variables
					searcher<Position> myAlgorithm;
					//searchable<Position> mazeSearch = new MazeSearch(maze3d);

					// switch & case for solution maze.
					switch (algorithm) {
					case "BFS":
						myAlgorithm = new BFS<Position>();
						break;
					case "DFS":
						myAlgorithm = new DFS<Position>();
						break;
		
					default:
						c.C_displayMessage("there is no such algorithm");
						return;
					}

					// put solution in hashMap.
					//solutions.put(mazeName, myAlgorithm.search(mazeSearch));
					c.C_displayMessage("Solution for" + mazeName + " is ready");
				}
			}
		});
		
		
	}

	@Override
	public void M_displaySolution(String mazeName) {
		if(!solutions.containsKey(mazeName))
		{
			c.C_displayMessage("The solution not found");
		}
		else
		{
			
		}
		
		//not finished

	}

	@Override
	public void M_exit() {		
		//to remove and close all the open threads and files ?
		for(int i=0;i<this.threads.size();i++){
			if(this.threads.get(i)!=null){
				this.threads.get(i);
			}
				
		}
		
		for(int j=0;j<this.files.size();j++){
			if(this.files.get(j)!=null){
				this.files.get(j);
				
			}
		}
		
	}


	
	//getters and setters for the private data members
	
	

	public Controller getC() {
		return c;
	}


	public void setC(Controller c) {
		this.c = c;
	}


	public HashMap<String, Maze3d> getMazes() {
		return mazes;
	}


	public void setMazes(HashMap<String, Maze3d> mazes) {
		this.mazes = mazes;
	}


	public HashMap<String, Solution<Position>> getSolutions() {
		return solutions;
	}


	public void setSolutions(HashMap<String, Solution<Position>> solutions) {
		this.solutions = solutions;
	}


	public ArrayList<Thread> getThreads() {
		return threads;
	}


	public void setThreads(ArrayList<Thread> threads) {
		this.threads = threads;
	}


	public ArrayList<File> getFiles() {
		return files;
	}


	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
	



}
