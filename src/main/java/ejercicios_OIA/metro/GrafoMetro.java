package ejercicios_OIA.metro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrafoMetro {
	// La matriz no se usa en este ejercicio, queda para otros usos
	private int[][] matrizAdyacencia;
	private int cantNodos;
	private int cantTuneles;
	private int cantPuentes;
	private int padres[];
	private List<Camino> caminos;
	private int cantMinimaDePuentes;

	public GrafoMetro(int cantNodos) {
		this.cantNodos = cantNodos;
		this.matrizAdyacencia = new int[this.cantNodos][this.cantNodos];

		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				this.matrizAdyacencia[i][j] = 0;
			}
		}

		this.padres = new int[this.cantNodos];

		for (int i = 0; i < this.cantNodos; i++) {
			padres[i] = i;
		}

		this.caminos = new ArrayList<Camino>(this.cantNodos);
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantTuneles() {
		return cantTuneles;
	}

	public void setCantTuneles(int cantTuneles) {
		this.cantTuneles = cantTuneles;
	}

	public int getCantPuentes() {
		return cantPuentes;
	}

	public void setCantPuentes(int cantPuentes) {
		this.cantPuentes = cantPuentes;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void addTunel(int a, int b) {
		this.matrizAdyacencia[a - 1][b - 1] = 1;
		this.matrizAdyacencia[b - 1][a - 1] = 1;
		this.caminos.add(new Camino(a, 1, b));
	}

	public void addPuente(int a, int b) {
		this.matrizAdyacencia[a - 1][b - 1] = 2;
		this.matrizAdyacencia[b - 1][a - 1] = 2;
		this.caminos.add(new Camino(a, 2, b));
	}

	// x nodo origen, y nodo destino
	private void union(int x, int y) {
		int fx = find(x);
		int fy = find(y);

		padres[fx] = fy;
	}

	private int find(int x) {
		if (padres[x] == x) {
			return x;
		}

		return find(padres[x]);
	}

	public void Algoritmo_kruskal_mod() {
		if (this.cantPuentes == 0) {
			this.cantMinimaDePuentes = 0;
			return;
		}

		int cantAristas = 0; // debe ser cantNodos - 1

		Collections.sort(caminos, new Comparator<Camino>() {
			@Override
			public int compare(Camino c1, Camino c2) {
				return c1.getPeso() - c2.getPeso();
			}
		});

		int contador = 0;
		int pesoTotal = 0;

		while (cantAristas < this.cantNodos - 1) {
			int origen = caminos.get(contador).getOrigen() - 1;
			int peso = caminos.get(contador).getPeso();
			int destino = caminos.get(contador).getDestino() - 1;

			// union-find evita que cierre el ciclo
			if (find(origen) != find(destino)) {
				union(origen, destino);
				pesoTotal += peso;
				cantAristas++;
			}

			contador++;
		}

		// La cantidad minima se obtiene al restarle al peso total la cantidad de
		// tuneles cuyo peso defini como 1 luego se divide por el peso de los puentes
		// que defini como 2 para obtener la
		// cantidad minima para construir el metro
		this.cantMinimaDePuentes = (pesoTotal - this.cantTuneles) / 2;
	}

	public int getCantMinimaDePuentes() {
		return cantMinimaDePuentes;
	}
}
