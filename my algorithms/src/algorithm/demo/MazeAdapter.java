package algorithm.demo;

import java.util.ArrayList;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.State;
import algorithms.search.searchable;

/**
 * The maze adapter class for the maze3d to 
 * be searchable spesific for maze3d
 * 
 * @author mayHartshtein
 *
 */
public class MazeAdapter implements searchable<Position> {

	private Maze3d maze3d;
	
	//c'tor
	public MazeAdapter(Maze3d maze){
		super();
		//Maze3d m=new Maze3d(maze.getX(), maze.getY(), maze.getZ());
		//this.maze3d=m;
		this.maze3d=maze;
		
	}
	
	//the start state/position
	@Override
	public State<Position> getInitialState() {
		State<Position> s=new State<Position>(this.maze3d.getStartPosition());
		s.setCameFrom(null);
		s.setCost(0);
		
		return s;
	}

	@Override
	public State<Position> getGoalStaete() {
		State<Position> s=new State<Position>(this.maze3d.getGoalPosition());
		
		return s;
	}

	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		ArrayList<State<Position>> positions=new ArrayList<State<Position>>();
		String[] moves= new String[6];//for all the moves
		Position P1=new Position(0, 0, 0);
		P1=s.getState();
		moves=this.maze3d.getPossibleMoves(P1);
		
		
		for(int i=0;i<moves.length;i++){
			State<Position> state=new State<Position>(new Position(0, 0, 0));
			switch(moves[i]){
			
			case "up":
				state.setCameFrom(s);
				state.getState().setX(s.getState().getX()+1);
				state.getState().setY(s.getState().getY());
				state.getState().setZ(s.getState().getZ());
				positions.add(state);
				break;
			case "down":
				state.setCameFrom(s);
				state.getState().setX(s.getState().getX()-1);
				state.getState().setY(s.getState().getY());
				state.getState().setZ(s.getState().getZ());
				positions.add(state);
				break;
			case "right":
				state.setCameFrom(s);
				state.getState().setX(s.getState().getX());
				state.getState().setY(s.getState().getY());
				state.getState().setZ(s.getState().getZ()+1);
				positions.add(state);
				break;
			case "left":
				state.setCameFrom(s);
				state.getState().setX(s.getState().getX());
				state.getState().setY(s.getState().getY());
				state.getState().setZ(s.getState().getZ()-1);
				positions.add(state);
				break;
			case "forward":
				state.setCameFrom(s);
				state.getState().setX(s.getState().getX());
				state.getState().setY(s.getState().getY()+1);
				state.getState().setZ(s.getState().getZ());
				positions.add(state);
				break;
			case "backward":
				state.setCameFrom(s);
				state.getState().setX(s.getState().getX());
				state.getState().setY(s.getState().getY()-1);
				state.getState().setZ(s.getState().getZ());
				positions.add(state);
				break;
			}
		}
		
		//return the array list	
		return positions;
		
	}

	
	//get and set for the private variable
	public Maze3d getMaze3d() {
		return maze3d;
	}

	public void setMaze3d(Maze3d maze3d) {
		this.maze3d = maze3d;
	}


}
