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
	
	@Test
	public void simpleTest3() {	
		
		// 6--4--5--1
		//    |  | /   {4,2,1} covers, but not possible by 2 vertices
		//    3--2
		
		Graph graph = new Graph();
		
		graph.addEdge(4,6);
		graph.addEdge(4,5);
		graph.addEdge(1,5);
		graph.addEdge(3,4);
		graph.addEdge(2,3);
		graph.addEdge(2,5);
		graph.addEdge(2,1);
		

	    assertEquals(true,VertexCover.vertex_cover(graph, 3));
	}
	
	@Test
	public void simpleTest4() {	
		
		// 6--4--5--1
		//    |  | /   {4,2,1} covers, but not possible by 2 vertices
		//    3--2
		
		Graph graph = new Graph();
		
		graph.addEdge(4,6);
		graph.addEdge(4,5);
		graph.addEdge(1,5);
		graph.addEdge(3,4);
		graph.addEdge(2,3);
		graph.addEdge(2,5);
		graph.addEdge(2,1);
		

	    assertEquals(false,VertexCover.vertex_cover(graph, 2));
	}

}
