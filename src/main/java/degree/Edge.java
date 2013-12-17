package degree;

public class Edge {
	
	private int from;
	private int to;
	
	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//TODO : Is there a better way?
		result = prime * result + from + to;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		
		// Edge is undirected. So edge A-B is same as edge B-A
		if(
				(from == other.from && to == other.to) ||
				(from == other.to && to == other.from)
				)
			return true;
		
		return false;
	}
	
	public int either() {
		return from;
	}
	
	public int other(int v) {
		if(from == v)
			return to;
		
		return from;
	}
	
	

}
