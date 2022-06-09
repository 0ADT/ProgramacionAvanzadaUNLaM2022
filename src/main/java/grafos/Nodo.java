package grafos;

public class Nodo {
	private int origen;
	private int peso;
	private int destino;
	
	public Nodo(int origen, int peso, int destino) {
		super();
		this.origen = origen;
		this.peso = peso;
		this.destino = destino;
	}

	public int getOrigen() {
		return origen;
	}

	public int getPeso() {
		return peso;
	}

	public int getDestino() {
		return destino;
	}
}
