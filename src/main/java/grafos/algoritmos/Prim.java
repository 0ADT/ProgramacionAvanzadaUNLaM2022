package grafos.algoritmos;

import java.util.Iterator;
import java.util.PriorityQueue;

import grafos.Arista;
import grafos.GrafoNoDirigido;
import grafos.Nodo;

public class Prim {
	public static GrafoNoDirigido AlgoritmoPrim_Cola(GrafoNoDirigido gnd) {
		int verticesTotales = gnd.getCantidadNodos(); // Obtengo la cantidad total de vértices
		Nodo vOrigen = gnd.getNodos().get(0);

		if (vOrigen != null) {
			GrafoNoDirigido gNuevo = new GrafoNoDirigido(verticesTotales);
			gnd.getNodos().stream().forEach((v) -> {
				gNuevo.addNodo(new Nodo(v.getEtiqueta(), v.getNumeroDeNodo()));
			});

			// Para esta implementación, los pesos son números enteros.
			PriorityQueue<Arista> cola = new PriorityQueue<>(
					(Arista a1, Arista a2) -> Integer.compare(a1.getPeso(), a2.getPeso()));

			int cont = 0;

			while (cont < verticesTotales - 1) {
				for (Iterator<Arista> it = vOrigen.getConexiones().iterator(); it.hasNext();) {
					Arista arc = it.next();

					if (!arc.getDestino().isVisitado()) {
						cola.offer(arc);
					}
				}

				Arista arista = cola.poll();

				arista.getOrigen().setVisitado(true);

				if (!arista.getDestino().isVisitado()) {
					arista.getDestino().setVisitado(true);
					gNuevo.addArista(arista);
					cont++;
					vOrigen = arista.getDestino();
				}
			}

			return gNuevo;
		}

		return null;
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

		System.out.println(AlgoritmoPrim_Cola(g).getCosto());
	}
}
