package grafos;

import java.util.ArrayList;

public class GrafoNoDirigido extends Grafo {
	private int costo;

	public GrafoNoDirigido(int cantNodos) {
		this.nodos = new ArrayList<Nodo>(cantNodos);
		this.cantidadNodos = cantNodos;
		this.matrizAdyacencia = new int[this.cantidadNodos][];

		for (int i = 1; i < cantidadNodos; i++) {{
				this.matrizAdyacencia[i] = new int[i];
			}
		}
		
		costo = 0;
	}

	@Override
	public void addArista(Arista a) {
		aristas.add(a);
		this.cantidadAristas++;
		this.matrizAdyacencia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
		costo += a.getPeso();
	}

	public int getCosto() {
		return this.costo;
	}
}
