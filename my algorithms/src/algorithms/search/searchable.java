package algorithms.search;

import java.util.ArrayList;

public interface searchable <T> {
	
	public State<T> getInitialState();
	public State<T> getGoalStaete();
	public ArrayList<State<T>> getAllPossibleStates(State<T> s);
	
	

}
