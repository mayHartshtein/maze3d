package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * This is the class that build the maze3D by DFS algorithm
 * 
 * @author MayHartshtein
 * @version 1.0
 *
 */
public class MyMaze3dGenerator extends AbstructClass {
	
/**
 * The class represent a maze3d to buils a maze3D
 * @
 */
	private Random rnd = new Random();
	private Maze3d maze3d;
	
	//c'tor
	/*public MyMaze3dGenerator (Maze3d m)
	{
		this.maze3d=m;
	}*/
	
/**
 * This funttion choose the entry position random
 * 
 * @return Position
 */
	private Position randPosition(){
		
		int x = rnd.nextInt(maze3d.getX());
		while (x % 2 == 1)
			x = rnd.nextInt(maze3d.getX());
		
		int y = rnd.nextInt(maze3d.getY());
		while (y % 2 == 1)
			y = rnd.nextInt(maze3d.getY());
		
		int z = rnd.nextInt(maze3d.getZ());
		while (z % 2 == 1)
			z = rnd.nextInt(maze3d.getZ());
		
		
		return new Position(x,y,z);
	}

	@Override
	
/**
 * This is the function that the class extends from the interface and implemts it
 * 
 */
	public Maze3d generate(int x, int y, int z) {
		
		maze3d = new Maze3d(x,y,z);
		maze3d.initMaze3d(maze3d.getMaze3d());
		Position startP = randPosition();
		this.maze3d.setStartPosition(startP);
		DFS(startP);
		Position goalP=chooseEndPosition();
		this.maze3d.setGoalPosition(goalP);
		
		
		return maze3d;
	}
	
/**
 * This is the implement for the DFS alforithm that buils the Maze3d
 * @param p for the rundom position that choose in the start place of a cell
 * no return value
 */
	public void DFS(Position p){
		
		Integer [] rndDirection= RandomDirections();
		for (int i = 0; i < rndDirection.length; i++){
			switch (rndDirection[i]) {
			case 1:
			    if (p.getX() - 2 < 0)
	                 continue;
	             if (maze3d.getCell(p.getX() - 2,p.getY() ,p.getZ()) != 0) {
	                 maze3d.setCell(p.getX()-2,p.getY(),p.getZ(),0);
	                 maze3d.setCell(p.getX()-1,p.getY(),p.getZ(),0);
	                 Position newP=new Position(p.getX()-2, p.getY(), p.getZ());
	                 DFS(newP);
	             }
				break;
				
			case 2:
			    if (p.getY() + 2 >maze3d.getY()-1)
	                 continue;
	             if (maze3d.getCell(p.getX(),p.getY()+2,p.getZ())!= 0) {
	                 maze3d.setCell(p.getX(),p.getY()+2,p.getZ(), 0);
	                 maze3d.setCell(p.getX(),p.getY()+1,p.getZ(), 0);
	                 Position newP=new Position(p.getX(), p.getY()+2, p.getZ());
	                 DFS(newP);
	             }
				break;
				
			case 3:
			    if (p.getX() + 2 >maze3d.getX()-1)
	                 continue;
	             if (maze3d.getCell(p.getX()+2,p.getY(),p.getZ())!= 0) {
	                 maze3d.setCell(p.getX()+2,p.getY(),p.getZ(), 0);
	                 maze3d.setCell(p.getX()+1,p.getY(),p.getZ(), 0);
	                 Position newP=new Position(p.getX()+2, p.getY(), p.getZ());
	                 DFS(newP);
	             }
				break;
				
			case 4:
			    if (p.getY() - 2 <0)
	                 continue;
	             if (maze3d.getCell(p.getX(),p.getY()-2,p.getZ())!= 0) {
	                 maze3d.setCell(p.getX(),p.getY()-2,p.getZ(), 0);
	                 maze3d.setCell(p.getX(),p.getY()-1,p.getZ(), 0);
	                 Position newP=new Position(p.getX(), p.getY()-2, p.getZ());
	                 DFS(newP);
	             }
				break;
				
			case 5:
			    if (p.getZ() - 2 <0)
	                 continue;
	             if (maze3d.getCell(p.getX(),p.getY(),p.getZ()-2)!= 0) {
	                 maze3d.setCell(p.getX(),p.getY(),p.getZ()-2, 0);
	                 maze3d.setCell(p.getX(),p.getY(),p.getZ()-1, 0);
	                 Position newP=new Position(p.getX(), p.getY(), p.getZ()-2);
	                 DFS(newP);
	             }
				break;
				
			case 6:
			    if (p.getZ() + 2 > maze3d.getZ()-1)
	                 continue;
	             if (maze3d.getCell(p.getX(),p.getY(),p.getZ()+2)!= 0) {
	                 maze3d.setCell(p.getX(),p.getY(),p.getZ()+2, 0);
	                 maze3d.setCell(p.getX(),p.getY(),p.getZ()+1,0);
	                 Position newP=new Position(p.getX(), p.getY(), p.getZ()+2);
	                 DFS(newP);
	             }
				break;
				
				

			default:
				break;
			}
			
		}
		
		
		
	}
	
	
	private Position chooseEndPosition()
	{
		int floor=0,row=0, col=0;
		Random rand=new Random();
		do
		{
			floor=rand.nextInt(this.maze3d.getX());
			row=rand.nextInt(this.maze3d.getY());
			col=rand.nextInt(this.maze3d.getZ());
		}while(this.maze3d.getCell(floor, row, col)==1);
		
		return (new Position(floor, row, col));
		
	}
	
	
/**
 *  
 * @return
 */
	 public Integer[] RandomDirections() {
	      ArrayList<Integer> randoms = new ArrayList<Integer>();
	      for (int i = 0; i < 6; i++)
	           randoms.add(i + 1);
	      Collections.shuffle(randoms);
	 
	     return randoms.toArray(new Integer[6]);
	 }
	 
	 public void printMyMaze(){
		 this.maze3d.printMaze3d();
	 }

	
	//getters and setters
	public Random getRnd() {
		return rnd;
	}

	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}

	public Maze3d getMaze3d() {
		return maze3d;
	}

	public void setMaze3d(Maze3d maze3d) {
		this.maze3d = maze3d;
	}

}
