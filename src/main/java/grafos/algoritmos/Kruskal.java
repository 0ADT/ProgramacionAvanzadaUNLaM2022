package grafos.algoritmos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import grafos.Arista;
import grafos.GrafoNoDirigido;
import grafos.Nodo;

public class Kruskal {
	private static int padres[];

	private static void union(int x, int y) {
		int fx = find(x);
		int fy = find(y);

		padres[fx] = fy;
	}

	private static int find(int x) {
		if (padres[x] == x) {
			return x;
		}

		return find(padres[x]);
	}

	public static GrafoNoDirigido AlgoritmoKruskal(GrafoNoDirigido gnd) {
		int cantNodos = gnd.getCantidadNodos();

		if (cantNodos <= 0)
			return null;

		padres = new int[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			padres[i] = i;
		}

		List<Arista> aristas = gnd.getAristas();

		Collections.sort(aristas, new Comparator<Arista>() {
			@Override
			public int compare(Arista a1, Arista a2) {
				return a1.getPeso() - a2.getPeso();
			}
		});

		int contador = 0;
		GrafoNoDirigido aacm = new GrafoNoDirigido(gnd.getCantidadNodos()); // arbol abarcador de costo minimo

		while (aacm.getCantidadAristas() < cantNodos - 1) {
			Nodo origen = aristas.get(contador).getOrigen();
			int peso = aristas.get(contador).getPeso();
			Nodo destino = aristas.get(contador).getDestino();

			// union-find evita que cierre el ciclo
			if (find(origen.getNumeroDeNodo()) != find(destino.getNumeroDeNodo())) {
				union(origen.getNumeroDeNodo(), destino.getNumeroDeNodo());
				aacm.addNodo(origen);
				aacm.addNodo(destino);
				aacm.addArista(new Arista(origen, peso, destino));
			}

			contador++;
		}

		return aacm;
	}

	public static void main(String[] args) {
		// Grafo del problema "metro" de la OIA
		GrafoNoDirigido g = new GrafoNoDirigido(6);
		Nodo n1 = new Nodo(0);
		Nodo n2 = new Nodo(1);
		Nodo n3 = new Nodo(2);
		Nodo n4 = new Nodo(3);
		Nodo n5 = new Nodo(4);
		Nodo n6 = new Nodo(5);

		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);
		g.addNodo(n5);
		g.addNodo(n6);

		g.addArista(new Arista(n1, 1, n2));
		g.addArista(new Arista(n1, 2, n3));
		g.addArista(new Arista(n2, 1, n3));
		g.addArista(new Arista(n3, 2, n4));
		g.addArista(new Arista(n4, 1, n5));
		g.addArista(new Arista(n4, 2, n6));
		g.addArista(new Arista(n5, 2, n6));

		System.out.println(AlgoritmoKruskal(g).getCosto());
	}
}
