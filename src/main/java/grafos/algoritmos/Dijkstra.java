package grafos.algoritmos;

import java.util.ArrayList;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoDirigido;
import grafos.Nodo;

public class Dijkstra {
	private int[] vectorCostosMinimos; // D
	private int[] vectorPredecesores; // P
	private int[][] matAdy;
	private ArrayList<Nodo> listaNodos;
	private Nodo nodoInicial;

	public Dijkstra(Grafo g, Nodo nodoInicial) {
		vectorCostosMinimos = new int[g.getCantidadNodos()];
		vectorPredecesores = new int[g.getCantidadNodos()];
		listaNodos = (ArrayList<Nodo>) g.getNodos();
		matAdy = g.getMatrizAdyacencia();
		this.nodoInicial = nodoInicial;
	}

	public int[] getVectorCostosMinimos() {
		return vectorCostosMinimos;
	}

	public int[] getVectorPredecesores() {
		return vectorPredecesores;
	}

	private ArrayList<Nodo> getSucesores(Nodo n) {
		ArrayList<Nodo> nodos = new ArrayList<Nodo>(n.getConexiones().size());

		for (Arista a : n.getConexiones()) {
			nodos.add(a.getDestino());
		}

		return nodos;
	}

	private int peso(Nodo ini, Nodo fin) {
		int peso = 0;

		for (Arista a : ini.getConexiones()) {
			if (a.getDestino().equals(fin))
				peso = a.getPeso();
		}

		return peso;
	}

	public void AlgoritmoDijkstra_SinCola() {
		ArrayList<Boolean> visitado = new ArrayList<Boolean>(listaNodos.size());
		int[] vectorCostosMinimos = new int[listaNodos.size()];

		for (int i = 0; i < listaNodos.size(); i++) {
			vectorCostosMinimos[i] = matAdy[nodoInicial.getNumeroDeNodo()][i];
		}

		vectorCostosMinimos[nodoInicial.getNumeroDeNodo()] = 0;
		visitado.set(nodoInicial.getNumeroDeNodo(), true);

		Nodo v = null;

		while (visitado.contains(false)) {
			// v = nodo de menor distancia a s que no fue visitado aun

			visitado.set(v.getNumeroDeNodo(), true);

			for (Nodo w : getSucesores(v)) {
				if (vectorCostosMinimos[w.getNumeroDeNodo()] > vectorCostosMinimos[v.getNumeroDeNodo()] + peso(w, v)) {
					vectorCostosMinimos[w.getNumeroDeNodo()] = vectorCostosMinimos[v.getNumeroDeNodo()] + peso(w, v);
					vectorPredecesores[w.getNumeroDeNodo()] = v.getNumeroDeNodo();
				}
			}
		}
	}

	public void AlgoritmoDijkstra_ConCola() {

	}

	public static void main(String[] args) {
		GrafoDirigido g = new GrafoDirigido(5);
		Nodo n1 = new Nodo(0);
		Nodo n2 = new Nodo(1);
		Nodo n3 = new Nodo(2);
		Nodo n4 = new Nodo(3);
		Nodo n5 = new Nodo(4);

		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);
		g.addNodo(n5);

		g.addArista(new Arista(n1, 1, n2));
		g.addArista(new Arista(n2, 1, n3));
		g.addArista(new Arista(n2, 2, n4));
		g.addArista(new Arista(n4, 2, n5));

		Dijkstra d = new Dijkstra(g, n1);
		int[] vecCostos = d.getVectorCostosMinimos();
		int[] vecPred = d.getVectorPredecesores();

		System.out.println("Costos minimos");

		for (int i = 0; i < 5; i++) {
			System.out.print(vecCostos[i] + " ");
		}

		System.out.println("Predecesores");

		for (int i = 0; i < 5; i++) {
			System.out.print(vecPred[i] + " ");
		}
	}
}
