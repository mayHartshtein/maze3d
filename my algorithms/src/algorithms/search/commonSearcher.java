package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class commonSearcher<T> implements searcher<T> {
	
	protected PriorityQueue <State <T>> openList;
	private int evaluationNodes;
	
	public commonSearcher() {
		openList=new PriorityQueue<State<T>>();
		this.evaluationNodes=0;
	}
	
	protected State<T> popOpenList(){
		this.evaluationNodes++;
		return this.openList.poll();
		
	}
	

	@Override
	public abstract Solution <T>search(searchable<T> s);
	
	@Override
	public int getNumberOfNodesEvaluated() {
		
		return this.evaluationNodes;
	}
	
	//get and set for the private variable
	public int getEvaluationNodes() {
		return evaluationNodes;
	}
	public void setEvaluationNodes(int evaluationNodes) {
		this.evaluationNodes = evaluationNodes;
	}
	
	//the private method that calculate the cost between two states
	public double calculateCost(State<T> s1,State<T> s2){
			return 1;
		}
	
	protected Solution<T> backtrace(State<T> state) {
		State<T> s = state;
		ArrayList<State<T>> states = new ArrayList<State<T>>();
		while (s != null) {
			states.add(0, s);	
			s = s.getCameFrom();
		}
		Solution<T> solution = new Solution<T>();
		solution.setStates(states);
		return solution;
	}
}
