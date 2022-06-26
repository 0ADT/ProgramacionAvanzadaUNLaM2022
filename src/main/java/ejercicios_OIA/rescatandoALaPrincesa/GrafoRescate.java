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
		this.claroPrincesa = princesa - 1;
		this.claroPrincipe = principe - 1;
		this.distancia = new int[this.cantClaros];
		this.padres = new int[this.cantClaros];
		this.claroVisitado = new boolean[this.cantClaros];
		this.ubicacionDragones = new int[this.cantDragones];
		this.matrizAdyacencia = new int[this.cantClaros][];

		for (int i = 0; i < this.cantClaros; i++) {
			this.distancia[i] = Integer.MAX_VALUE;
			this.padres[i] = -1;
			this.claroVisitado[i] = false;
			this.matrizAdyacencia[i] = new int[i];
		}

		for (int i = 1; i < this.cantClaros; i++) {
			for (int j = 0; j < i; j++) {
				this.matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private boolean hayDragon(int inicio, int fin) {
		for (int i : ubicacionDragones) {
			if (i == inicio || i == fin)
				return true;
		}

		return false;
	}

	private boolean hayDragon(int indice) {
		for (int i : ubicacionDragones) {
			if (i == indice)
				return true;
		}

		return false;
	}

	public void agregarSendero(int inicio, int fin, int largo) {
		if (hayDragon(inicio, fin))
			this.matrizAdyacencia[Math.max(inicio, fin) - 1][Math.min(inicio, fin) - 1] = largo + 1000;
		else
			this.matrizAdyacencia[Math.max(inicio, fin) - 1][Math.min(inicio, fin) - 1] = largo;
	}

	public void agregarDragon(int dragon, int i) {
		this.ubicacionDragones[i] = dragon - 1;
	}

	private Integer ObtenerNumeroDeMatriz(int inicio, int fin) {
		return this.matrizAdyacencia[Math.max(inicio, fin)][Math.min(inicio, fin)];
	}

	public void ObtenerCaminos() {
		distancia[this.claroPrincipe] = 0;

		PriorityQueue<Integer> pila = new PriorityQueue<>();
		pila.add(distancia[this.claroPrincipe]);

		while (!pila.isEmpty()) {
			int u = pila.poll();
			claroVisitado[u] = true;

			for (int i = 1; i < cantClaros; i++) {
				if (!claroVisitado[i] && ObtenerNumeroDeMatriz(u, i) != Integer.MAX_VALUE
						&& distancia[i] > Math.abs(distancia[u] + ObtenerNumeroDeMatriz(u, i))) {
					distancia[i] = distancia[u] + ObtenerNumeroDeMatriz(u, i);
					padres[i] = u;
					pila.add(i);
				}
			}
		}

	}

	public String ObtenerRecorrido() {
		String res = "";
		boolean caminoRecorrido = false;
		int indice = claroPrincesa;

		while (!caminoRecorrido) {
			if (hayDragon(indice))
				return "INTERCEPTADO";

			if (padres[indice] != -1) {
				res += (indice + 1) + " ";
				indice = padres[indice];
			} else
				caminoRecorrido = true;
		}

		if (indice != claroPrincipe)
			return "NO HAY CAMINO";
		else
			res += (claroPrincipe + 1);

		return new StringBuilder(res).reverse().toString();
	}
}
