package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * This is the class that represent the maze 3D and its includs all the maze functions.
 * 
 *@author MayHartshtein
 *@version 1.0
 *
 */

public class Maze3d {
	
	
	/**
	 * @param
	 * 
	 * 
	 */
		private int [][][] maze3d;
		private int x;
		private int y;
		private int z;
		private Position startPosition;
		private Position goalPosition;
	
	/**
	 * This is the c'tor that initial the maze 3D parameters
	 * 
	 * @param x for floor - up or down
	 * @param y for rows-  forward or backward
	 * @param z for coals- left or right
	 * @return maze3d
	 */
		public Maze3d(int x, int y, int z) {
			this.x=x;
			this.y=y;
			this.z=z;
			this.maze3d=new int [x][y][z];
		}
		
	
	/**
	 * This is the c'tor that get the byte array and build a maze3d 
	 * 
	 */
		
		public Maze3d(byte [] bytes){
			
			ArrayList<Byte> byteArray=new ArrayList<Byte>();
			for(int i=0;i<bytes.length;i++){
				byteArray.add(bytes[i]);
			}
			
			//for first we buils the data member x,y,z for the size of the int [][][] maze
			this.setX(byteArray.get(0));
			this.setY(byteArray.get(1));
			this.setZ(byteArray.get(2));
			
			//here we add the start and the goal position and we create a 2 new position
			Position s=new Position(byteArray.get(3), byteArray.get(4), byteArray.get(5));
			Position g=new Position(byteArray.get(6), byteArray.get(7), byteArray.get(8));
			this.setStartPosition(s);
			this.setGoalPosition(g);
			
			//here we add the all maze data,the int [][][] maze3d array
			int num=9;
			for(int j=0;j<this.getX();j++){
				for(int k=0;k<this.getY();k++){
					for(int l=0;l<this.getZ();l++){
						
						this.setCell(j, k, l,byteArray.get(num));
						num++;
					}
				}
			}
		}

	/**
	 * Put a wall in the cell
	 * 
	 * @param p for the cell position 
	 * no return value
	 */
		public void wall(Position p){
			this.maze3d[p.getX()][p.getY()][p.getZ()]=1;
		
		}
		
	/**
	 * Put a free in a cell
	 * @param p for the cell position
	 * no return value
	 */
		public void free(Position p){
			this.maze3d[p.getX()][p.getY()][p.getZ()]=0;
			
		}
		
	/**
	 * The printin method that print the maze 3D
	 * no return value	
	 */
		public void printMaze3d(){
			
			for(int i=0;i<this.x;i++){
				for(int j=0;j<this.y;j++){
					for(int k=0;k<this.z;k++)
					{
						System.out.print(maze3d[i][j][k]+" ");
					}
					System.out.println();
				}
				System.out.println();
			}
			
			
		}
		
	/**
	 * Initialization the maze all the cells are 1
	 * 
	 * @param m the array size [][][] for the maze 3D
	 * no return value
	 */
		public void initMaze3d(int [][][] m)
		{
			for(int i=0;i<this.x;i++){
				for(int j=0;j<this.y;j++){
					for(int k=0;k<this.z;k++)
					{
						m[i][j][k]=1;
					}
				}
			}
		}
		
	/**
	 * The possible move of a cell in a string array
	 * 
	 * @param p for the current cell position
	 * @return strind []
	 */
		public String[] getPossibleMoves(Position p)
		{
			ArrayList<String> str=new ArrayList<String>();
			// for the floors
			if(((p.getX() + 1) < this.getX())&& (getCell(p.getX()+1, p.getY(), p.getZ())==0))
			{
				str.add("up");
			}
			
			if(((p.getX() - 1) >= 0) && (getCell(p.getX()-1, p.getY(), p.getZ())==0))
			
			{
				str.add("down");
			}
			
			//for the rows
			if(((p.getY() +1) < this.getY())&& (getCell(p.getX(), p.getY()+1, p.getZ())==0))
			{
				str.add("forward");
			}
			if(((p.getY() -1) >= 0) && (getCell(p.getX(), p.getY()-1, p.getZ())==0))
			{
				str.add("backward");
			}
			
			//for the coals
			if(((p.getZ() +1) < this.getZ()) && (getCell(p.getX(), p.getY(), p.getZ()+1)==0))
			{
				str.add("right");
			}
			if(((p.getZ() -1) >= 0 )&& (getCell(p.getX(), p.getY(), p.getZ()-1)==0))
			{
				str.add("left");
			}

			
			//building the string array
			String s1[]=new String[str.size()];
			//convert array to string
			str.toArray(s1);
			return s1;
			
		}
		
	/**
	 * The maze2d by X from the maze3d
	 * @param num for the section of the array 
	 * @return int [][]
	 * @throws IndexOutOfBoundsException
	 * 
	 */
		public int [][]getCrossSectionByX(int num)throws IndexOutOfBoundsException
		{
			//checking if there are exception
			if(num<0||num>=maze3d.length)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
			else
			{
				//create maze2d
				int[][] maze2dByX=new int[this.maze3d[0].length][this.maze3d[0][0].length];
				for (int i = 0; i < maze2dByX.length; i++) {
					for (int j = 0; j < maze2dByX[0].length; j++) {
						maze2dByX[i][j]=maze3d[num][i][j];
					}
				}
				return maze2dByX;
			}
		}
		
	/**
	 * The maze2d by y from the maze3d
	 *  
	 * @param num for the section of the array
	 * @return int [][]
	 * @throws IndexOutOfBoundsException
	 */
		public int[][] getCrossSectionByY(int num)throws IndexOutOfBoundsException   
		{
			//checking if there are exception
			if(num<0||num>=maze3d[0].length)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
			else
			{
				//create maze2d
				int[][] maze2dByY=new int[this.maze3d.length][this.maze3d[0][0].length];
				for (int i = 0; i < maze2dByY.length; i++) {
					for (int j = 0; j < maze2dByY[0].length; j++) {
						maze2dByY[i][j]=maze3d[i][num][j];
					}
				}
				return maze2dByY;
		
			}
		
		}
		
		
	/**
	 * The maze2d by Z from the maze3d 
	 * @param num for the section of the array
	 * @return int [][]
	 * @throws IndexOutOfBoundsException
	 */
		public int[][] getCrossSectionByZ(int num)throws IndexOutOfBoundsException   
			{
				//checking if there are exception
				if(num<0||num>=maze3d[0].length)
				throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
				else
				{
					//create maze2d
					int[][] maze2dByZ=new int[this.maze3d.length][this.maze3d[0].length];
					for (int i = 0; i < maze2dByZ.length; i++) {
						for (int j = 0; j < maze2dByZ[0].length; j++) {
							maze2dByZ[i][j]=maze3d[i][j][num];
						}
					}
					return maze2dByZ;
			
				}
			
			}
		
	/**
	 * The byteToArray methods that compress all the maze3d data
	 * to Array of bytes using in ArrayList to be easyer for start
	 * and at the end we convert it to byte array
	 * 
	 * first we add to the byte array the array [][][] size firt x ,y ,z
	 * then we add the start position (it takes 3 places in the array)
	 * and then the goal position (also takes 3 places in the array)
	 * and last we add the data of the int maze3d [][][];
	 * 
	 */
		
		public byte[] toByteArray(Maze3d maze){
			
			ArrayList<Byte> byteArray=new ArrayList<Byte>();
			
			//one by one we add all the date for the maze
			byteArray.add((byte) this.getX());
			byteArray.add((byte) this.getY());
			byteArray.add((byte) this.getZ());
			
			//we add the start and the goal position for the maze3d
			byteArray.add((byte) this.startPosition.getX());
			byteArray.add((byte) this.startPosition.getY());
			byteArray.add((byte) this.startPosition.getZ());
			byteArray.add((byte) this.goalPosition.getX());
			byteArray.add((byte) this.goalPosition.getY());
			byteArray.add((byte) this.goalPosition.getZ());
			
			//for last we add the int [][][] maze3d date one by one
			
			for(int i=0;i<this.getX();i++){
				for(int j=0;j<this.getY();j++){
					for(int k=0;k<this.getZ();k++){
						byteArray.add((byte) this.getCell(i, j, k));
					}
				}
			}
			
			
			//convert the arrayList to byte array
			byte [] bytes=new byte[byteArray.size()];
			
			for(int l=0;l<byteArray.size();l++){
				
				bytes[l]=byteArray.get(l);
			}
			
			return bytes;
			
		}
		
		public void print2dMaze(int [][] maze2d){
			for (int i = 0; i < maze2d[0].length; i++) {
				for (int j = 0; j < maze2d.length; j++) {
					System.out.print(maze2d[j][i]+" ");
				}
				System.out.println();
			}
			
		}
		
	/**
	 * All the getter and setters for the variables that represent the maze 3D
	 * return all the variables and getting them it the functions.
	 *
	 */
		public void setCell(int x,int y,int z,int num){
			this.maze3d[x][y][z]=num;
		}
		
		public int getCell(int x,int y,int z){
			
			return maze3d[x][y][z];
		}
			
		public int [][][] getMaze3d() {
			return maze3d;
		}
		public void setMaze3d(int [][][] maze3d) {
			this.maze3d = maze3d;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}
		public Position getStartPosition() {
			return startPosition;
		}
		public void setStartPosition(Position startPosition) {
			this.startPosition = startPosition;
		}
		public Position getGoalPosition() {
			return goalPosition;
		}
		public void setGoalPosition(Position goalPosition) {
			this.goalPosition = goalPosition;
		}
		
		
		
		
		

}
