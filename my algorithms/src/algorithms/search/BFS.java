package algorithms.search;
import java.util.HashSet;

import java.util.ArrayList;
/**
 * This class represent the BFS algorithm search in a generic oobject
 * this calss is a generic class
 * @author mayHartshtein
 *
 * @param <T>
 */
public class BFS <T> extends commonSearcher<T> {

	/**
	 * This method build the solution in a BFS way and it use in a 
	 * hashSet and ArratList for the nones that we are used in.
	 * 
	 * @return solition <T> at the and
	 */
	@Override
	public Solution<T> search(searchable<T> s) {

		
		  openList.add(s.getInitialState());
		  HashSet<State<T>> closedSet=new HashSet<State<T>>();
		 
		 while(openList.size()>0){
		    State<T> n=null;
		    n=popOpenList();
		    closedSet.add(n);
	
		    if(n.equals(s.getGoalStaete())){
		    	//System.out.println("n goal:");
		    	//System.out.println(n.getState());
		    	return backtrace(n);
		    }
		    ArrayList<State<T>> successors=s.getAllPossibleStates(n);
		    for(State<T> state : successors){
		      if(!closedSet.contains(state) && ! openList.contains(state))
		      {
		        state.setCameFrom(n);
		        state.setCost(n.getCost()+calculateCost(n, state));
		     //   state.setCost(n.getCost()+state.getCost());
		        openList.add(state);
		      } 
		      else{
		    	  if (n.getCost()+calculateCost(n,state)<state.getCost()) 
		    	  {
						state.setCost(n.getCost()+calculateCost(n,state));
						state.setCameFrom(n);
						if (!openList.contains(state))
							openList.add(state);
						
						else{
								
							openList.remove(state);
							openList.add(state);							
						}
		    	  	}
		      	} 
		      }
		   }
		  // System.out.println(openList.size());
		  // System.out.println("nulllllll");
		   return null;

	
	}




}
