package algorithm.demo;

import algorithms.mazeGenerators.Maze3d;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.searcher;
import algorithms.search.Solution;

/**
 *The demo class for the maze solution by BFS and DFS algorithms 
 * 
 * @author mayHartshtein
 *
 */
public class Demo {

	public void run() {
		
		Maze3dGenerator mg=new MyMaze3dGenerator();
		//Maze3dGenerator mg1=new SimpleMaze3dGenerator();
		Maze3d maze=new Maze3d(10,10,10);
		maze=mg.generate(10, 10, 10);
		maze.printMaze3d();
		MazeAdapter mazeAd=new MazeAdapter(maze);
		System.out.println("The start position :");
		System.out.println(mazeAd.getMaze3d().getStartPosition());
		System.out.println("The goal position :");
		System.out.println(mazeAd.getMaze3d().getGoalPosition());
		
		
		searcher<Position> s1=new BFS<Position>();
		searcher<Position> s2=new DFS<Position>();
		Solution<Position> sol1=new Solution<Position>();
		Solution<Position> sol2=new Solution<Position>();
		
	
		sol1=s1.search(mazeAd);
		System.out.println("solution by BFS : ");
		
		for(int i=0;i<sol1.getStates().size();i++)
		{
			System.out.println(sol1.getStates().get(i).getState());
		}
		
		sol2=s2.search(mazeAd);
		System.out.println("solution by BFS : ");
		
		for(int i=0;i<sol2.getStates().size();i++)
		{
			System.out.println(sol2.getStates().get(i).getState());
		}
		
	}

}
		
