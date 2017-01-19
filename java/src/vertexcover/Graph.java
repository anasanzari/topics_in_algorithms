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
		//deep copy problem.
		Graph copy = new Graph();
		copy.graph = new HashMap<Integer, HashSet<Integer>>();
		for( Entry<Integer, HashSet<Integer>> entry : graph.entrySet()){
			copy.graph.put(entry.getKey(), new HashSet<Integer>(entry.getValue()));
		}
		copy.edges = new HashSet<Edge>(edges);
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
	
	public void printGraph(){
		//System.out.println("x--------------x");
		for (Entry<Integer, HashSet<Integer>> entry : graph.entrySet()) {

			int node = entry.getKey();
			HashSet<Integer> neighbours = entry.getValue();
			
			System.out.print(node+":");
			for(Integer e : neighbours){
				System.out.print(e+" ");
			}
			System.out.println("");
		}
		//System.out.println("x--------------x");
	}
	
	public void remove(int node,  HashSet<Integer> neighbours){
		graph.remove(node);
		Iterator<Integer> iter = neighbours.iterator();
		while(iter.hasNext()){
			int neighbour = iter.next();
			if(graph.containsKey(neighbour)){
				//since we're working on a copy. Neighbours could be stale.
				graph.get(neighbour).remove(node);
			}
			edges.remove(new Edge(node, neighbour));
		}
	}
	
}
