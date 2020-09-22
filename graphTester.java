package Grafo;

/**
 * Class graphTester
 * @author Camila Arena LU:121943.
 */


public class graphTester {
	public static void main(String[]arg) {

		Graph g = new Graph();
		
		//Inserto los nodos y arcos.
		for(int i = 0; i<=10; i++)
			g.addNode(i);
		
		for(int i = 0; i<10; i++)
			g.addEdge(i,i+1);
		
		
		//Remuevo nodos pertenecientes al grafo.
		for(int i = 0; i<=10; i++)
			g.removeNode(i);

		
		//Pruebo de eliminar nodos que no estan en el grafo.
		g.removeNode(11);
		g.removeNode(15);
		g.removeNode(20);
		
		
		//Remuevo todos los arcos.
		for(int i = 0; i<10; i++)
			g.removeEdge(i,i+1);
		
		//Pruebo de eliminar arcos que no estan en el grafo.
		g.removeEdge(1,2);
		g.removeEdge(0,1);
		g.removeEdge(3,5);
		g.removeEdge(0,1);	
		
	}
}
