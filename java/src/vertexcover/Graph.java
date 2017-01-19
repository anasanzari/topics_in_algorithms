package vertexcover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class Graph {
	
	public HashMap<Integer, HashSet<Integer>> graph;
	public HashSet<Edge> edges;
		
	Graph(){
			
		graph = new HashMap<Integer, HashSet<Integer>>();
		edges = new HashSet<Edge>();
	}
	
	public Graph copy(){
		Graph copy = new Graph();
		copy.graph = (HashMap<Integer, HashSet<Integer>>) this.graph.clone();
		copy.edges = (HashSet<Edge>) this.edges.clone();
		return copy;
	}
	
	public int size(){
		return graph.size();
	}
		
	public void addEdge(int a, int b){
		edges.add(new Edge(a, b));
		addVertex(a, b);
		addVertex(b, a);
	}
	
	public void addVertex(int a, int b){
		if(graph.containsKey(a)){
			graph.get(a).add(b);
		}else{				
			HashSet<Integer> l = new HashSet<Integer>();
			l.add(b);
			graph.put(a, l);
		}
			
	}
	
	public void remove(int node,  HashSet<Integer> neighbours){
		graph.remove(node);
		Iterator<Integer> iter = neighbours.iterator();
		while(iter.hasNext()){
			int neighbour = iter.next();
			graph.get(neighbour).remove(node);
			edges.remove(new Edge(node, neighbour));
		}
	}
	
}