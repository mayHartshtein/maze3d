package algorithms.mazeGenerators;
import java.util.Random;

public class SimpleMaze3dGenerator extends AbstructClass{
	
	private Maze3d maze3d;
	Random rnd = new Random();
	
	//c'tor
	/*public SimpleMaze3dGenerator(Maze3d m){
		this.maze3d= new Maze3d(m.getX(), m.getY(), m.getZ());
		
	}*/

	//@Override
	public Maze3d generate(int x, int y, int z) {
		this.maze3d = new Maze3d(x,y,z);
		Position startP = new Position(0, 0, 0);
		this.maze3d.setStartPosition(startP);
		
		Position goalP=new Position(0, 0, z);
		this.maze3d.setGoalPosition(goalP);
		
		createMaze3d(maze3d);
		
		return maze3d;
	}
	
	//the method that create the simple maze3d
	public void createMaze3d(Maze3d maze){
		
		int a;
		
		//restart the maze with 0 or 1 for free or wall
		for(int i=0;i<maze.getX();i++){
			
			for(int j=0;j<maze.getY();j++)
			{
				for(int k=0;k<maze.getZ();k++){
					a=rnd.nextInt(2);
					maze.setCell(i,j,k,a); 
					
					}
				}	
			}
		//Creating artificially path in the maze3d	
		for(int m=0;m<maze.getX();m++){
			for(int l=0;l<maze.getY();l++)
				if(maze.getCell(m,l,0)==1)
				{
					maze.setCell(m,l,0,0);
				}
				
			}
		}
		
	//Printing method
	public void printSimpleMaze(){
		this.maze3d.printMaze3d();
	}


	//getters and setters for the private variables 
	public Maze3d getMaze3d() {
		return maze3d;
	}

	public void setMaze3d(Maze3d maze3d) {
		this.maze3d = maze3d;
	}

}
