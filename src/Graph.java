import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Element;


class Graph{
	 
//	Printing all nodes from 'Source' to 'Destination'
	static int max_path_coverage = 1;
	private static void printPath(List<Integer> path) {
		
		int size = path.size();
		int node_count = 0, branch_count = 0;
		System.out.print("Test Cases " + max_path_coverage + " :: ");
		for(Integer i : path) {
			
			Element link = (Element) NodeLink.listNodes.item(i);
			
			if(NodeLink.result.get(i).equals("JoinNode") || NodeLink.result.get(i).equals("ForkNode")
				|| NodeLink.result.get(i).equals("DecisionNode")) {
				
				continue;
				
			} else {
				if(i != 0)
					System.out.print(" ==>> ");
				node_count++;
				if(link.getAttribute("xmi:type").equals("uml:DecisionNode")) 
					branch_count++;
				System.out.print(NodeLink.result.get(i));
			}
			
    		
		}
		
		System.out.println("\nStatement Coverage is : " + (node_count * 100) / NodeLink.totalNodes + "%");
		System.out.println("Branch Coverage is    : " + (branch_count * 100) / NodeLink.total_branch + "%");
		System.out.println("\n");
		max_path_coverage++;
	}

	// Utility function to check if current vertex is already present in path or not
	private static boolean isNotVisited(int x, List<Integer> path)
	{
	    int size = path.size();
	    for(int i = 0; i < size; i++)
	        if (path.get(i) == x)
	            return false;
	             
	    return true;
	}
	 
	// Utility function for finding paths in graph from source to destination
	public static void findpaths(List<List<Integer> > g, int src, int dst)
	{
	     
	    // Create a queue which stores the path
	    Queue<List<Integer> > queue = new LinkedList<>();
	 
//	    System.out.println(g);
	    // Path is store the current path
	    List<Integer> path = new ArrayList<>();
	    path.add(src);
	    queue.offer(path);
	    
	    
	    while (!queue.isEmpty())
	    {
	        path = queue.poll();
//	        System.out.println(path);
	        int last = path.get(path.size() - 1);
	        
//	        System.out.println(last);
	        // If last vertex is the desired destination, then print the path
	        if (last == dst)
	        {
	            printPath(path);
	        }
	 
	        // Traverse to all the nodes connected to
	        List<Integer> lastNode = g.get(last);
	        
	        for(int i = 0; i < lastNode.size(); i++)
	        {
//	        	System.out.println(lastNode.get(i) + " , " + path);
	            if (isNotVisited(lastNode.get(i), path))
	            {
	                List<Integer> newpath = new ArrayList<>(path);
	                newpath.add(lastNode.get(i));
	                queue.offer(newpath);
	            }
	        }
	    }
	}
}
