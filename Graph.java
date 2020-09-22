package Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Graph
 * @author Camila Arena LU:121943.
 */

public class Graph {
	
	//Atributos
	
	private List<Integer> nodos;
	private List<String> arcos;
	private static Logger logger;
	
	
	//Constructor
	
	public Graph() {
		
		nodos = new ArrayList<Integer>();
		arcos = new ArrayList<String>();
		
		if(logger == null) {
			
			logger= Logger.getLogger(Graph.class.getName());
			
			Handler hnd=new ConsoleHandler();
			hnd.setLevel(Level.INFO);
			
			logger.addHandler(hnd);
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger=logger.getParent();
			
			for(Handler h : rootLogger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}
	
	
	//Metodos
	
	public void addNode(int node) {
		
		logger.info("Se desea ingresar el nodo "+node+" al grafo");
		
		if(!nodos.contains(node)) {
			nodos.add(node);
			logger.info("El nodo "+node+" fue ingresado con exito en el grafo");
		}
		else {
			logger.warning("El nodo "+node+" ya se encuentra en el grafo");
		}
		
	}

	
	public void addEdge(int node1, int node2) {
		
		logger.info("Se desea ingresar un arco que una a los nodos "+node1+" y "+node2+" al grafo");
		
		if(nodos.contains(node1) && nodos.contains(node2)) {
			arcos.add(node1+","+node2);
			logger.info("El arco fue ingresado con exito en el grafo");
		}
		else {
			
			if(!nodos.contains(node1) && !nodos.contains(node2))
				logger.warning("Los nodos "+node1+" y "+node2+" no se encuentran en el grafo");
			
			else {
				if(!nodos.contains(node1))
					logger.warning("El nodo "+node1+"no fue encontrado en el grafo");
				else
					logger.warning("El nodo "+node2+" no fue encontrado en el grafo");
			}
		}	
	}
	
	public void removeNode(int node) {
		
		logger.info("Se desea remover el nodo "+node+" del grafo");
		int indice;
		
		if(nodos.contains(node)) {
			
			indice = nodos.indexOf(node);
			nodos.remove(indice);

			logger.info("El nodo "+node+" fue removido con exito del grafo");
		}
		else
			logger.warning("El nodo "+node+" a remover no se encuentra en el grafo");
	}

	
	public void removeEdge(int node1, int node2) {
		int i;
		logger.info("Se desea remover el arco de los nodos "+node1+","+node2+" del grafo");
		
		if(arcos.contains(node1+","+node2)) {
			i = arcos.indexOf(node1+","+node2);
			arcos.remove(i);
			logger.info("el arco del "+node1+" al "+node2+" fue removido con exito");
		}
		else
			logger.warning("el arco no pertenecia al grafo");
			
	}
}
