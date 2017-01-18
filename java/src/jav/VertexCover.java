package jav;


import java.util.*;
import java.util.Map.Entry;


public class VertexCover {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = sc.nextInt();
		Graph graph = new Graph();
		
		System.out.println("Enter edges: ");
		for(int i = 0;i <n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.addEdge(a,b);
		}
		
		System.out.print("Enter k:");
		int k = sc.nextInt();
		if(vertex_cover(graph,k)){
			System.out.println("Yes Instance");
		}else{
			System.out.println("No Instance");
		}
		
		
	}
	
	public static boolean vertex_cover(Graph graph, int k){
		try{
			
			if(k<0) return false;
			
			//redution one and two
			//remove degree zero vertices and those with degree > k
			int k_dash = k;
			Iterator<Entry<Integer, HashSet<Integer>>> iter = graph.iterator();
			
			while(iter.hasNext()){
				Entry<Integer, HashSet<Integer>> entry = iter.next();
				int node = entry.getKey();
				HashSet<Integer> neighbours = entry.getValue();
				if(neighbours.size()==0){
					graph.remove(node, neighbours, false);
					iter.remove();
				}
			}
			
			iter = graph.iterator();
			
			while(iter.hasNext()){
				Entry<Integer, HashSet<Integer>> entry = iter.next();
				int node = entry.getKey();
				HashSet<Integer> neighbours = entry.getValue();
				if(neighbours.size()>k){
					graph.remove(node, neighbours, false);
					iter.remove();
					k_dash--;
				}
			}
			
			if(k_dash<0||graph.edges.size()>k_dash*k_dash) return false;
				
			if(graph.edges.size()>0){
				//pick an edge and branch
				Iterator<Edge> it = graph.edges.iterator();
				Edge e = it.next();
				Graph g1 = (Graph) graph.clone();
					
				g1.remove(e.u,g1.graph.get(e.u),true);
				if(vertex_cover(g1, k_dash)){
					return true;
				}
	
				Graph g2 = (Graph) graph.clone();
				g2.remove(e.v, g2.graph.get(e.v), true);
				return  vertex_cover(g2, k_dash);
							
			}else{
				//no edge to cover
				return true;
			}
		
	  }catch(Exception e){
		  e.printStackTrace();
		  return false;
	  }

	}

}
