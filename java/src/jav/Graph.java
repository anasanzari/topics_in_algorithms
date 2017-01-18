package jav;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class Graph implements Cloneable{
	
	public HashMap<Integer, HashSet<Integer>> graph;
	public HashSet<Edge> edges;
		
	Graph(){
			
		graph = new HashMap<Integer, HashSet<Integer>>();
		edges = new HashSet<Edge>();
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
	
	public void remove(int node,  HashSet<Integer> neighbours, boolean flag){
		//graph.remove(node);
		if(flag) graph.remove(node);
		Iterator<Integer> iter = neighbours.iterator();
		while(iter.hasNext()){
			int neighbour = iter.next();
			graph.get(neighbour).remove(node);
			System.out.println("before"+edges.size());
			System.out.println("e:"+node+":"+neighbour);
			edges.remove(new Edge(node, neighbour));
			System.out.println("after"+edges.size());
		}
	}
	
	public Iterator<Entry<Integer, HashSet<Integer>>> iterator(){
		Set<Entry<Integer, HashSet<Integer>>> set = graph.entrySet();
		Iterator<Entry<Integer, HashSet<Integer>>> iter = set.iterator();
		return iter;
	}
	
		
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();
	}
}
