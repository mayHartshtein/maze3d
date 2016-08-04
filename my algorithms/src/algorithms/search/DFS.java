package algorithms.search;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class represent the DFS algorithm search it is a generic class
 * @author mayHartshtein
 *
 * @param <T>
 */

public class DFS<T> extends commonSearcher<T> {
	
	
		private HashSet<State<T>> visitedStates = new HashSet<State<T>>();
		private Solution<T> solution;
		
		/**
		 * This method send the searchable object to the DFS algorithm
		 * search and calculate the solution for it
		 * @return solution<T> for the algorithm solution search
		 */
		public Solution<T> search(searchable<T> s) {
			
			dfs(s, s.getInitialState());		
			return solution;
		}
		
		
		/**
		 * This method woork with ArrayList for the all possible moves
		 * in the generic seacjable object and it work like the DFS
		 * original algorithm
		 * @param s for the searchable object
		 * @param state for the generic state that we are working with
		 */
		private void dfs(searchable<T> s, State<T> state) {
			
			if (state.equals(s.getGoalStaete())) {
				solution = backtrace(state);
				return;
				
			}
			//System.out.println(s.getGoalStaete());
			
			visitedStates.add(state);
			
			ArrayList<State<T>> actions = s.getAllPossibleStates(state);
			for(State<T> neighbor: actions)
			{
				if (!visitedStates.contains(neighbor)) {
					neighbor.setCameFrom(state);
					dfs(s, neighbor);					
				} 			
			}
			return;
		}

		
	}

