package grafos;

import java.util.ArrayList;
import java.util.List;

public abstract class Grafo {
	protected int[][] matrizAdyacencia;
	protected List<Nodo> nodos;
	protected List<Arista> aristas;
	protected int cantidadNodos;
	protected int cantidadAristas;

	public Grafo() {
		this.aristas = new ArrayList<Arista>();
		this.cantidadAristas = 0;
	}
	
	public Grafo(int cantNodos) {
		this.nodos = new ArrayList<Nodo>(cantNodos);
		this.aristas = new ArrayList<Arista>();
		this.cantidadNodos = cantNodos;
		this.cantidadAristas = 0;
		this.matrizAdyacencia = new int[this.cantidadNodos][this.cantidadNodos];

		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				this.matrizAdyacencia[i][j] = 0;
			}
		}
	}

	public void addNodo(Nodo n) {
		nodos.add(n);
	}

	public void addArista(Arista a) {
		aristas.add(a);
		this.cantidadAristas++;
		this.matrizAdyacencia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}

	public int getCantidadAristas() {
		return cantidadAristas;
	}
}
