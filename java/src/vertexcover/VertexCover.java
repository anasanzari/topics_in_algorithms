package vertexcover;


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
		if(vertex_cover(graph,k).isCoverable){
			System.out.println("Yes Instance");
		}else{
			System.out.println("No Instance");
		}
		
		
	}
	
	public static Cover vertex_cover(Graph graph, int k){

		Cover cover = new Cover();

		if (k < 0) {
			cover.isCoverable = false;
			return cover;
		}

		// redution one and two
		// remove degree zero vertices and those with degree > k
		int k_dash = k;
		Graph copy = graph.copy();

		for (Entry<Integer, HashSet<Integer>> entry : copy.graph.entrySet()) {

			int node = entry.getKey();
			HashSet<Integer> neighbours = entry.getValue();
			if (neighbours.size() == 0) {
				graph.remove(node, neighbours);
			} else if (neighbours.size() > k) {
				graph.remove(node, neighbours);
				cover.nodes.add(node);
				k_dash--;
			}
		}

		if (k_dash < 0 || graph.edges.size() > k_dash * k_dash) {
			cover.isCoverable = false;
			return cover;
		}

		if (graph.edges.size() > 0) {
			// pick an edge and branch
			Iterator<Edge> it = graph.edges.iterator();
			Edge e = it.next();

			Graph g1 = (Graph) graph.copy();
			g1.remove(e.u, g1.graph.get(e.u));
			Cover subcover = vertex_cover(g1, k_dash);
			if (subcover.isCoverable) {
				cover.isCoverable = true;
				cover.nodes.add(e.u);
				cover.nodes.addAll(subcover.nodes);
				return cover;
			}

			Graph g2 = graph.copy();
			g2.remove(e.v, g2.graph.get(e.v));
			subcover = vertex_cover(g2, k_dash);
			if (subcover.isCoverable) {
				cover.isCoverable = true;
				cover.nodes.add(e.v);
				cover.nodes.addAll(subcover.nodes);
				return cover;
			}

		} else {
			// no edge to cover
			cover.isCoverable = true;
		}

		return cover;

	}

}
