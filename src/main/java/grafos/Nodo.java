package grafos;

public class Nodo {
	private int grado;
	private String etiqueta = "";
	private int numeroDeNodo;

	public Nodo(String etiqueta, int numNodo) {
		this.etiqueta = etiqueta;
		this.grado = 0;
		this.numeroDeNodo = numNodo;
	}

	public Nodo(int numNodo) {
		this.grado = 0;
		this.numeroDeNodo = numNodo;
	}

	public int getNumeroDeNodo() {
		return this.numeroDeNodo;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	public int getGrado() {
		return this.grado;
	}

	public void incrementarGrado() {
		this.grado++;
	}
}
