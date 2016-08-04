package algorithms.search;
import java.util.ArrayList;

/**
 * This class are return the solution of the algorithm search
 * @author mayHartshtein
 *
 * @param <T>
 */

public class Solution<T> {
	
	private ArrayList<State<T>> states;

	public ArrayList<State<T>> getStates() {
		return states;
	}

	public void setStates(ArrayList<State<T>> newStates2) {
		this.states = newStates2;
	}

/*	public String toString() {
		ArrayList<State<T>> S=new ArrayList<State<T>>();
		for(State<T> s : states){
			
		}
		
		return null;
	}*/

}
