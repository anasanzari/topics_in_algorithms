package jav;

public class Edge {
	
	public int u;
	public int v;
	
	public Edge(int u, int v) {
		if(u>v){
			int t = u;
			u = v;
			v = u;
		}
		this.u = u;
		this.v = v;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u;
		result = prime * result + v;
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
		if (u != other.u)
			return false;
		if (v != other.v)
			return false;
		return true;
	}
	
	
	
	

}
