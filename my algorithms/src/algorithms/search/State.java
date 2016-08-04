package algorithms.search;
/**
 * This class is preffer to the state in our case is 
 * that the class represent a node but this is a generic class
 * @author mayHartshtein
 *
 * @param <T>
 */

public class State<T> implements Comparable<State<T>>{
	private T state;
	private double cost;
	private State<T> cameFrom;
	private boolean visited;
	
	//c'tor
	public State(T state)
	{
		this.state=state;
	}
	/**
	 * this method initialieze the variable to be visited
	 * 
	 * @param b for the boolean variable
	 */
	public void setVisited(boolean b) {
		this.visited=b;
		
	}
	
	/**
	 * this method return if the node is visited or not
	 * @return boolean
	 */
	public boolean isVisited() {
		return this.visited;
	}

	/**
	 * this method check if the objects are the same or not
	 * @return boolean
	 */
	
	@Override
	public boolean equals(Object arg0) {
		State<T> state = (State<T>)arg0;
		return (this.state.equals(state.getState()));
	}

	/**
	 * this method comper between the objects
	 * @return int 
	 */
	@Override
	public int compareTo(State<T> s) {
		return (int)(this.cost - s.cost);
		
	}
	
	/**
	 * this methods are for the hashSet
	 * 
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	
	@Override
	public String toString()
	{
		
		return this.getState().toString();
		
	}
	
	//getters and setters 
	public T getState(){
		return this.state;
	}
	
	public void setState(T S){
	
		this.state=S;
	}
	
	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public State<T> getCameFrom() {
		return cameFrom;
	}


	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}

	
}
