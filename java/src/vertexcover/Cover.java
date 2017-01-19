package vertexcover;

import java.util.ArrayList;
import java.util.List;

//returned by vertex_cover algorithm.

public class Cover {
	
	public boolean isCoverable;
	public List<Integer> nodes;
	
	Cover(){
		nodes = new ArrayList<Integer>();
		isCoverable = false;
	}
	
	public void printCover(){
		System.out.print("Cover: { ");
		for (Integer node : nodes) {
			System.out.print(node+" ");
		}
		System.out.print("}\n");
	}
	
	
	

}
