
public class ClientGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graphs g=new Graphs();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 10);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("D", "E", 2);
		g.addEdge("F", "G", 3);
		g.addEdge("E", "F", 3);
		g.addEdge("E", "G", 8);
		
		g.display();
		
		System.out.println("*******************");
////		g.removevertex("D");
//		g.display();
//		
//		
//		System.out.println(g.hasPath("A", "G"));
//		g.removeEdge("D", "E");
//		System.out.println(g.hasPath("A","G"));
		
		
		//August 02
//		g.printAllPaths("A", "G");
//		System.out.println("Shortest Path");
//		g.printShortestPath("A", "G");
//		g.printShortestPath2("A", "G");
//		System.out.println();
//		System.out.println("Multisolver");
//		
//		g.multiSolver("A", "G", 3, 40);
	
		
		//August 04
	g.bft();
	g.dft();
	System.out.println("Is Connected: "+g.isConnected());
	System.out.println("Is Cyclic: "+g.isCyclic());
	System.out.println("All Components: "+g.getConnectedComponents());
	System.out.println(g.IsBipartite());
	
	
	}

}
