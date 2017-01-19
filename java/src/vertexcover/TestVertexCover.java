package vertexcover;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVertexCover {
	
	public void printCover(Cover cover){
		
		if(!cover.isCoverable){
			System.out.println("No Instance");
			return;
		}
		System.out.println("Yes Instance");
		cover.printCover();
		
		
	}
	
	public Graph readGraph(Scanner sc){
		
		int v = sc.nextInt();//ignored!
		int e = sc.nextInt();
		
		Graph graph = new Graph();
		for(int i = 0;i <e;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.addEdge(a,b);
		}
		
		return graph;
	}
	
	@Test
	public void simpleTest() {	
		
		// 1--0--2
		//    |     {0,3} covers, not possible by 1 vertices
		//    3--4
		
		Graph graph = new Graph();
		
		graph.addEdge(0, 1);
		
		graph.addEdge(0,2);
		
		graph.addEdge(0, 3);
		
		graph.addEdge(3, 4);
		
		Cover cover = VertexCover.vertex_cover(graph, 2);
		printCover(cover);
	    assertEquals(true,cover.isCoverable);
	}
	
	@Test
	public void simpleTest2() {	
		
		// 1--0--2
		//    |     {0,3} covers, not possible by 1 vertices
		//    3--4
		
		Graph graph = new Graph();
		
		graph.addEdge(0, 1);
		
		graph.addEdge(0,2);
		
		graph.addEdge(0, 3);
		
		graph.addEdge(3, 4);
		
		Cover cover = VertexCover.vertex_cover(graph, 1);
		printCover(cover);
	    assertEquals(false,cover.isCoverable);
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
		
		Cover cover = VertexCover.vertex_cover(graph, 3);
		printCover(cover);
	    assertEquals(true,cover.isCoverable);
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
		
		Cover cover = VertexCover.vertex_cover(graph, 2);
		printCover(cover);
	    assertEquals(false,cover.isCoverable);
	}
	
	@Test
	public void bigTest1(){
		try{
			
			Scanner sc = new Scanner(new File("./tests/input1.txt"));
			Graph g = readGraph(sc);
			int k = sc.nextInt();
			sc.close();
			Cover cover = VertexCover.vertex_cover(g, k);
			printCover(cover);
		    assertEquals(true,cover.isCoverable);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
