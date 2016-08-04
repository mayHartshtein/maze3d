package algorithms.mazeGenerators;

/**
 * This is a abstract class that implements the Maze3dGenerator that fullfil
 * the functions in the interface Maze3dGenerators
 * 
 * @author MayHartshtein
 * @version 1.0
 *
 */

public abstract class AbstructClass implements Maze3dGenerator {

	public abstract Maze3d generate(int x, int y, int z);
	public String measureAlgorithmTime(int x,int y,int z) {
		long startTime = System.currentTimeMillis();
		generate(x,y,z);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		return String.valueOf(duration);
	}

}
