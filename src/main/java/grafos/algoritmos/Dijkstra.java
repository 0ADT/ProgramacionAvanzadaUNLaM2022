package grafos.algoritmos;

import java.util.ArrayList;
import java.util.PriorityQueue;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoDirigido;
import grafos.GrafoNoDirigido;
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

	public void AlgoritmoDijkstra_SinCola() {
		for (int i = 0; i < listaNodos.size(); i++) {
			vectorCostosMinimos[i] = matAdy[nodoInicial.getNumeroDeNodo()][i];
		}

		vectorCostosMinimos[nodoInicial.getNumeroDeNodo()] = 0;
		nodoInicial.setVisitado(true);

		Nodo v = nodoInicial;
		int nodosVisitados = 1;

		while (nodosVisitados < listaNodos.size()) {
			// v = nodo de menor distancia a s que no fue visitado aun
			int menorDistancia = Integer.MAX_VALUE;

			for (Nodo n : listaNodos) {
				if (!n.isVisitado() && menorDistancia > vectorCostosMinimos[n.getNumeroDeNodo()]) {
					menorDistancia = vectorCostosMinimos[n.getNumeroDeNodo()];
					v = n;
				}
			}

			v.setVisitado(true);
			nodosVisitados++;

			for (Nodo w : getSucesores(v)) {
				if (vectorCostosMinimos[w.getNumeroDeNodo()] > vectorCostosMinimos[v.getNumeroDeNodo()]
						+ v.getPesoNodoDestino(w)) { // peso(v, w))
					vectorCostosMinimos[w.getNumeroDeNodo()] = vectorCostosMinimos[v.getNumeroDeNodo()]
							+ v.getPesoNodoDestino(w); // peso(v, w);
					vectorPredecesores[w.getNumeroDeNodo()] = v.getNumeroDeNodo();
				}
			}
		}
	}

	public void AlgoritmoDijkstra_ConCola() {
		vectorCostosMinimos[nodoInicial.getNumeroDeNodo()] = 0;

		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>(listaNodos.size(), (n1, n2) -> {
			return n1.getCosto() - n2.getCosto();
		});

		pq.add(new Nodo(nodoInicial, 0));

		while (!pq.isEmpty()) {
			Nodo u = pq.poll();

			u.setVisitado(true);

			for (Nodo v : u.getNodosConectados()) {
				if (!v.isVisitado()
						&& vectorCostosMinimos[v.getNumeroDeNodo()] > vectorCostosMinimos[u.getNumeroDeNodo()]
								+ u.getPesoNodoDestino(v)) { // peso(u, v))
					vectorCostosMinimos[v.getNumeroDeNodo()] = vectorCostosMinimos[u.getNumeroDeNodo()]
							+ u.getPesoNodoDestino(v); // peso(u, v);
					vectorPredecesores[v.getNumeroDeNodo()] = u.getNumeroDeNodo();
					pq.add(new Nodo(v, vectorCostosMinimos[v.getNumeroDeNodo()]));
				}
			}
		}
	}

	/**
	 * @brief Inicializa los vectores que se deben devolver como resultado y se
	 *        ponene los nodos como no visitados
	 **/
	public void inicializar() {
		// inicializacion
		for (int i = 0; i < listaNodos.size(); i++) {
			vectorCostosMinimos[i] = Integer.MAX_VALUE;
			vectorPredecesores[i] = 0;
			listaNodos.get(i).setVisitado(false);
		}
	}

	/**
	 * Este main contiene algunos ejemplos para probar que funciona el algoritmo
	 **/
	public static void main(String[] args) {
		int nodos = 5;
		GrafoDirigido g = new GrafoDirigido(nodos);
		Nodo n0 = new Nodo(0);
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);

		g.addNodo(n0);
		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);

		g.addArista(new Arista(n0, 1, n1));
		g.addArista(new Arista(n1, 1, n2));
		g.addArista(new Arista(n1, 2, n3));
		g.addArista(new Arista(n3, 3, n4));

		Dijkstra d = new Dijkstra(g, n1);

		d.inicializar();
		d.AlgoritmoDijkstra_SinCola();

		int[] vecCostos = d.getVectorCostosMinimos();
		int[] vecPred = d.getVectorPredecesores();

		System.out.println("SIN COLA DE PRIORIDAD");
		System.out.println("Costos minimos desde el nodo origen " + n1.getNumeroDeNodo());

		for (int i = 0; i < nodos; i++) {
			if (vecCostos[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(vecCostos[i] + " ");
		}

		System.out.println();
		System.out.println("Predecesores");

		for (int i = 0; i < nodos; i++) {
			System.out.print(vecPred[i] + " ");
		}

		d.inicializar();
		d.AlgoritmoDijkstra_ConCola();
		System.out.println();
		System.out.println("CON COLA DE PRIORIDAD");
		System.out.println("Costos minimos desde el nodo origen " + n1.getNumeroDeNodo());

		for (int i = 0; i < nodos; i++) {
			if (vecCostos[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(vecCostos[i] + " ");
		}

		System.out.println();
		System.out.println("Predecesores");

		for (int i = 0; i < nodos; i++) {
			System.out.print(vecPred[i] + " ");
		}

		// Nodos del ejercicio metro de la OIA
		System.out.println();
		System.out.println();
		System.out.println("------------------------");
		System.out.println("metro OIA");

		nodos = 6;

		GrafoDirigido gm = new GrafoDirigido(nodos);
		Nodo no0 = new Nodo(0);
		Nodo no1 = new Nodo(1);
		Nodo no2 = new Nodo(2);
		Nodo no3 = new Nodo(3);
		Nodo no4 = new Nodo(4);
		Nodo no5 = new Nodo(5);

		gm.addNodo(no0);
		gm.addNodo(no1);
		gm.addNodo(no2);
		gm.addNodo(no3);
		gm.addNodo(no4);
		gm.addNodo(no5);

		gm.addArista(new Arista(no0, 1, no1));
		gm.addArista(new Arista(no0, 2, no2));
		gm.addArista(new Arista(no1, 1, no2));
		gm.addArista(new Arista(no2, 2, no3));
		gm.addArista(new Arista(no3, 1, no4));
		gm.addArista(new Arista(no3, 2, no5));
		gm.addArista(new Arista(no4, 2, no5));

		Dijkstra di = new Dijkstra(gm, no0);

		di.inicializar();
		di.AlgoritmoDijkstra_SinCola();

		vecCostos = di.getVectorCostosMinimos();
		vecPred = di.getVectorPredecesores();

		System.out.println("SIN COLA DE PRIORIDAD");
		System.out.println("Costos minimos desde el nodo origen " + no0.getNumeroDeNodo());

		for (int i = 0; i < nodos; i++) {
			if (vecCostos[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(vecCostos[i] + " ");
		}

		System.out.println();
		System.out.println("Predecesores");

		for (int i = 0; i < nodos; i++) {
			System.out.print(vecPred[i] + " ");
		}

		di.inicializar();
		di.AlgoritmoDijkstra_ConCola();

		vecCostos = di.getVectorCostosMinimos();
		vecPred = di.getVectorPredecesores();

		System.out.println();
		System.out.println("CON COLA DE PRIORIDAD");
		System.out.println("Costos minimos desde el nodo origen " + no0.getNumeroDeNodo());

		for (int i = 0; i < nodos; i++) {
			if (vecCostos[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(vecCostos[i] + " ");
		}

		System.out.println();
		System.out.println("Predecesores");

		for (int i = 0; i < nodos; i++) {
			System.out.print(vecPred[i] + " ");
		}

		// Ejemplo del algoritmo de
		// https://es.wikipedia.org/wiki/Anexo:Ejemplo_de_Algoritmo_de_Dijkstra
		System.out.println();
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Ejemplo de WIKIPEDIA");
		nodos = 8;
		GrafoNoDirigido gndWiki = new GrafoNoDirigido(nodos);
		Nodo nodoW1 = new Nodo("a", 0);
		Nodo nodoW2 = new Nodo("b", 1);
		Nodo nodoW3 = new Nodo("c", 2);
		Nodo nodoW4 = new Nodo("d", 3);
		Nodo nodoW5 = new Nodo("e", 4);
		Nodo nodoW6 = new Nodo("f", 5);
		Nodo nodoW7 = new Nodo("g", 6);
		Nodo nodoW8 = new Nodo("z", 7);

		gndWiki.addNodo(nodoW1);
		gndWiki.addNodo(nodoW2);
		gndWiki.addNodo(nodoW3);
		gndWiki.addNodo(nodoW4);
		gndWiki.addNodo(nodoW5);
		gndWiki.addNodo(nodoW6);
		gndWiki.addNodo(nodoW7);
		gndWiki.addNodo(nodoW8);

		gndWiki.addArista(new Arista(nodoW1, 16, nodoW2)); // a - b
		gndWiki.addArista(new Arista(nodoW1, 10, nodoW3)); // a - c
		gndWiki.addArista(new Arista(nodoW1, 5, nodoW4)); // a - d
		gndWiki.addArista(new Arista(nodoW2, 2, nodoW3)); // b - c
		gndWiki.addArista(new Arista(nodoW2, 4, nodoW6)); // b - f
		gndWiki.addArista(new Arista(nodoW2, 6, nodoW7)); // b - g
		gndWiki.addArista(new Arista(nodoW3, 12, nodoW6)); // c - f
		gndWiki.addArista(new Arista(nodoW3, 10, nodoW5)); // c - e
		gndWiki.addArista(new Arista(nodoW3, 4, nodoW4)); // c - d
		gndWiki.addArista(new Arista(nodoW4, 15, nodoW5)); // d - e
		gndWiki.addArista(new Arista(nodoW5, 3, nodoW6)); // e - f
		gndWiki.addArista(new Arista(nodoW5, 5, nodoW8)); // e - z
		gndWiki.addArista(new Arista(nodoW6, 16, nodoW8)); // f - z
		gndWiki.addArista(new Arista(nodoW6, 8, nodoW7)); // f - g
		gndWiki.addArista(new Arista(nodoW7, 7, nodoW8)); // g - z

		Dijkstra diWiki = new Dijkstra(gndWiki, nodoW1);

		diWiki.inicializar();
		diWiki.AlgoritmoDijkstra_SinCola();

		vecCostos = diWiki.getVectorCostosMinimos();
		vecPred = diWiki.getVectorPredecesores();

		System.out.println("SIN COLA DE PRIORIDAD");
		System.out.println("El resultado es Camino: ADCBFEZ");
		System.out.println("El equivalente en el vector de predecesores es: 0 2 3 0 5 1 - 4");
		System.out.println("Distancia: 23 (0 11 9 5 18 15 17 23)");
		System.out.println("Costos minimos desde el nodo origen " + nodoW1.getEtiqueta());

		for (int i = 0; i < nodos; i++) {
			if (vecCostos[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(vecCostos[i] + " ");
		}

		System.out.println();
		System.out.println("Predecesores");

		for (int i = 0; i < nodos; i++) {
			System.out.print(vecPred[i] + " ");
		}

		diWiki.inicializar();
		diWiki.AlgoritmoDijkstra_ConCola();

		vecCostos = diWiki.getVectorCostosMinimos();
		vecPred = diWiki.getVectorPredecesores();

		System.out.println();
		System.out.println("CON COLA DE PRIORIDAD");
		System.out.println("El resultado es Camino: ADCBFEZ");
		System.out.println("El equivalente en el vector de predecesores es: 0 2 3 0 5 1 - 4");
		System.out.println("Distancia: 23 (0 11 9 5 18 15 17 23)");
		System.out.println("Costos minimos desde el nodo origen " + nodoW1.getEtiqueta());

		for (int i = 0; i < nodos; i++) {
			if (vecCostos[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(vecCostos[i] + " ");
		}

		System.out.println();
		System.out.println("Predecesores");

		for (int i = 0; i < nodos; i++) {
			System.out.print(vecPred[i] + " ");
		}
	}
}
