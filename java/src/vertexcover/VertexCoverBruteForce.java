package vertexcover;

import java.util.Scanner;

public class VertexCoverBruteForce {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of vertices:");
		int v = sc.nextInt();// ignored!
		System.out.print("Enter no of edges:");
		int e = sc.nextInt();

		Graph graph = new Graph();

		System.out.println("Enter edges: ");
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.addEdge(a, b);
		}

		System.out.print("Enter k:");
		int k = sc.nextInt();
		if (vertex_cover_bf(graph, k).isCoverable) {
			System.out.println("Yes Instance");
		} else {
			System.out.println("No Instance");
		}

	}

	public static Cover vertex_cover_bf(Graph graph, int k) {
		int n = graph.size();
		//loop through all nCk possibilities.
		int[] vertices = new int[n];
		int index = 0;
		for( Integer node : graph.graph.keySet()){
			vertices[index++] = node.intValue();
		}
		int[] combination = new int[k];
	    return combinate(graph, vertices, combination, k, 0, 0);
			
		
	}
	
	public static Cover combinate(Graph g, int[] vertices, int[] combination, int k, int index, int i){
		if(index==k){
			return coverCheck(g,combination);
		}
		
		Cover cover = new Cover();
		if(i>=vertices.length){
			//end of array return;
			return cover;
		}
		
		//include exclude branching based on pascal's identity
		combination[index] = vertices[i];
		cover = combinate(g, vertices, combination, k, index+1, i+1);
		if(cover.isCoverable){
			return cover;
		}
		return combinate(g, vertices, combination, k, index, i+1);
		
	}

	private static Cover coverCheck(Graph g, int[] combination) {
		//for each edge check if one of the end point is in combination
		Cover cover = new Cover();
		for( Edge e : g.edges){
			boolean covered = false;
			for (int i = 0; i < combination.length; i++) {
				if(e.u==combination[i]||e.v==combination[i]){
					covered = true;
					break;
				}
			}
			if(covered) continue;
			//we've an uncovered edge!
			return cover;
		}
		//it's a cover!
		cover.isCoverable = true;
		for (int i = 0; i < combination.length; i++) {
			cover.nodes.add(combination[i]);
		}
		return cover;
	}

}
