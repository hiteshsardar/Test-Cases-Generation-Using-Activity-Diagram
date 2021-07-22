import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NodeLink extends Variables{
	
    static NodeList listNodes = doc.getElementsByTagName(NODE);
    static NodeList listEdges = doc.getElementsByTagName(EDGE);
	
    static int totalNodes = listNodes.getLength();
    Map <String, Integer> mp = new HashMap<String, Integer>();
    static Map <Integer, String> result= new HashMap<Integer, String>();
    List<List<Integer> > addNode = new ArrayList<>();
    
    static int total_branch = 0;
    
	public void getDetails(){
	
		int totalEdges = listEdges.getLength();
		System.out.println("Total number of Nodes : " + totalNodes);
		System.out.println("Total number of Edges : " + totalEdges + "\n");
		
//		Adding all node data to the Map
		for (int i = 0; i < totalNodes; i++) {
	        
	            Element link = (Element) listNodes.item(i);
	            addNode.add(new ArrayList<>());
	            
//	            Adding values to the Map 
	            mp.put(link.getAttribute("xmi:id"), i);
	    		
	    		result.put(i, link.getAttribute("name").replaceAll("%20"," "));
	    		
	    		if(link.getAttribute("xmi:type").equals("uml:DecisionNode")) {
	    			total_branch += 2;
	    		}
	    }
		
		
//		Adding nodes to graph, that is 'Source' and 'Destination' node
		for (int i = 0; i < listEdges.getLength(); i++) {
			Element link = (Element) listEdges.item(i);
			
//			System.out.println(mp.get(link.getAttribute("source")) + " , " +  mp.get(link.getAttribute("target")));
			addNode.get(mp.get(link.getAttribute("source"))).add(mp.get(link.getAttribute("target")));
		}
		
//		System.out.println(addNode);
		System.out.println("The Followings are all different TestCases from " + result.get(0) + " to " + result.get(totalNodes - 1));
		Graph.findpaths(addNode,0,totalNodes - 1);
		
		System.out.println("\nPath Coverage is      : " + (1 * 100) / (Graph.max_path_coverage - 1) + "%");
		
	}
	
}
