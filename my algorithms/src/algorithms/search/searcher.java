package algorithms.search;

public interface searcher <T> {
	
	public Solution<T> search(searchable <T> s);
	public int getNumberOfNodesEvaluated();
	
	

}
