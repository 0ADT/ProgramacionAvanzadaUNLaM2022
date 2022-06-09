package ejercicios_OIA.metro;

public class Camino {
	private int origen;
	private int destino;
	private int peso;

	public Camino(int origen, int peso, int destino) {
		this.origen = origen;
		this.peso = peso;
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public int getDestino() {
		return destino;
	}

	public int getOrigen() {
		return origen;
	}
}
