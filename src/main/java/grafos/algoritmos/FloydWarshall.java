package grafos.algoritmos;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoDirigido;
import grafos.Nodo;

public class FloydWarshall {
	private int numNodos;
	private int[][] distancia; // Matriz de adyacencia, para almacenar los arcos del grafo
	private boolean[][] warshallC; // Matriz de Existencias de Caminos (Warshall - Path)

	public FloydWarshall(Grafo g) {
		numNodos = g.getCantidadNodos();
		warshallC = new boolean[numNodos][numNodos];
		distancia = g.getMatrizAdyacencia();

		if (g.getClass() == GrafoDirigido.class) {
			for (Arista a : g.getAristas()) {
				distancia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
			}
		} else {
			for (Arista a : g.getAristas()) {
				distancia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
				distancia[a.getDestino().getNumeroDeNodo()][a.getOrigen().getNumeroDeNodo()] = a.getPeso();
			}
		}
	}

	public void AlgoritmoFloydWarshall() {
		// Obtener la matriz de existencia de caminos
		for (int i = 0; i < numNodos; i++)
			for (int j = 0; j < numNodos; j++)
				warshallC[i][j] = (distancia[i][j] != Integer.MAX_VALUE);

		int valSum;

		// Iterar
		for (int k = 0; k < numNodos; k++) {
			for (int i = 0; i < numNodos; i++) {
				for (int j = 0; j < numNodos; j++) {
					warshallC[i][j] = (warshallC[i][j] || (warshallC[i][k] && warshallC[k][j]));

					// Para evitar que la suma de infinitos de un numero negativo se hace esta
					// pregunta. Si alguno de los valores es "infinito" se asigna otro "infinito",
					// caso contrario se procede a asignar la suma
					valSum = (distancia[i][k] == Integer.MAX_VALUE || distancia[k][j] == Integer.MAX_VALUE)
							? Integer.MAX_VALUE
							: (distancia[i][k] + distancia[k][j]);
					distancia[i][j] = Math.min(distancia[i][j], valSum);
				}
			}
		}
	}

	public int[][] getDistancias() {
		return distancia;
	}

	public boolean[][] getCaminos() {
		return warshallC;
	}

	public static void main(String[] args) {
		// Grafo del problema "metro" de la OIA
		GrafoDirigido g = new GrafoDirigido(6);
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

		FloydWarshall fw = new FloydWarshall(g);

		fw.AlgoritmoFloydWarshall();

		int[][] d = fw.getDistancias();
		boolean[][] c = fw.getCaminos();

		System.out.println("Distancias");

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (d[i][j] == Integer.MAX_VALUE)
					System.out.print("INF ");
				else
					System.out.print(d[i][j] + " ");
			}

			System.out.println();
		}

		System.out.println("Caminos");

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(c[i][j] + " ");
			}

			System.out.println();
		}
	}

}
