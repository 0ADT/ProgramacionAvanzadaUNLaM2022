package ejercicios_OIA.rescatandoALaPrincesa;

import java.util.PriorityQueue;

public class GrafoRescate {
	private int cantClaros;
	private int cantSenderos;
	private int cantDragones;
	private int claroPrincipe;
	private int claroPrincesa;
	private int[] distancia;
	private int[] padres;
	private boolean[] claroVisitado;
	private int[] ubicacionDragones;
	private int[][] matrizAdyacencia;

	public GrafoRescate(int claros, int senderos, int dragones, int princesa, int principe) {
		this.cantClaros = claros;
		this.cantSenderos = senderos;
		this.cantDragones = dragones;
		this.claroPrincesa = princesa;
		this.claroPrincipe = principe;
		this.distancia = new int[this.cantClaros];
		this.padres = new int[this.cantClaros];
		this.claroVisitado = new boolean[this.cantClaros];
		this.ubicacionDragones = new int[this.cantClaros];
		this.matrizAdyacencia = new int[this.cantClaros][];

		for (int i = 0; i < this.cantClaros; i++) {
			this.distancia[i] = Integer.MAX_VALUE;
			this.padres[i] = -1;
			this.claroVisitado[i] = false;
		}
	}

	public void agregarSendero(int inicio, int fin, int largo) {
		this.matrizAdyacencia[Math.min(inicio, fin)][Math.max(inicio, fin)] = largo;
	}

	public void agregarDragon(int dragon, int i) {
		this.ubicacionDragones[i] = dragon;
	}

	public void ObtenerCaminos() {
		distancia[this.claroPrincipe] = 0;

		PriorityQueue<Integer> pila = new PriorityQueue<>();
		pila.add(distancia[this.claroPrincipe]);

		while (!pila.isEmpty()) {
			int u = pila.poll();
			claroVisitado[u] = true;

			for (int i = 1; i < cantClaros; i++) {
				if ((Integer) matrizAdyacencia[u][i] != 0) {
					if (distancia[i] > distancia[u] + (Integer) matrizAdyacencia[u][i]) {
						distancia[i] = distancia[u] + (Integer) matrizAdyacencia[u][i];
						padres[i] = u;
						pila.add(i);
					}
				}
			}
		}
	}
}
