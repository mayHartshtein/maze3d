package algorithms.mazeGenerators;

/**
 * This is an interface that represent the maze3DGenerators for creating the maze3D
 * 
 * @author MayHartshtein
 * @version 1.0
 *
 */

public interface Maze3dGenerator {

/**
 * This function is going to build the maze3D
 * @param x for the floor
 * @param y for the rows
 * @param z for the coals
 * @return Maze3d
 */
	public Maze3d generate(int x,int y,int z);
	
/**
 * This function is going to measure time for building the Maze3d
 * @param x for the floor 
 * @param y for the rows 
 * @param z for the coals
 * @return string 
 */
	public String measureAlgorithmTime(int x,int y,int z);

}
