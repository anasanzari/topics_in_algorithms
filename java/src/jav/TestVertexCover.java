package jav;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVertexCover {
	
	@Test
	public void simpleTest() {	
		
		Graph graph = new Graph();
		
		graph.addEdge(0, 1);
		
		graph.addEdge(0,2);
		
		graph.addEdge(0, 3);
		
		graph.addEdge(3, 4);
		

	    assertEquals(true,VertexCover.vertex_cover(graph, 2));
	}
	
	@Test
	public void simpleTest2() {	
		
		Graph graph = new Graph();
		
		graph.addEdge(0, 1);
		
		graph.addEdge(0,2);
		
		graph.addEdge(0, 3);
		
		graph.addEdge(3, 4);
		

	    assertEquals(false,VertexCover.vertex_cover(graph, 1));
	}

}
