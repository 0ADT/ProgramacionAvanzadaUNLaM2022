package ejercicios_OIA.metro;

public class GrafoMetro {
	private int[][] matrizAdyacencia;
	private int cantNodos;
	private int cantTuneles;
	private int cantPuentes;

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

	public GrafoMetro(int cantNodos) {
		this.cantNodos = cantNodos;
		this.matrizAdyacencia = new int[this.cantNodos][this.cantNodos];

		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = 0; j < this.cantNodos; j++) {
				this.matrizAdyacencia[i][j] = 0;
			}
		}
	}

	public void addTunel(int a, int b) {
		this.matrizAdyacencia[a - 1][b - 1] = 1;
		this.matrizAdyacencia[b - 1][a - 1] = 1;
	}

	public void addPuente(int a, int b) {
		this.matrizAdyacencia[a - 1][b - 1] = -1;
		this.matrizAdyacencia[b - 1][a - 1] = -1;
	}
}
