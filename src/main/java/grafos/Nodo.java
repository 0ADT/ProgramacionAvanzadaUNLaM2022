package grafos;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	private int grado;
	private String etiqueta = "";
	private int numeroDeNodo;
	private List<Arista> conexiones;
	private boolean visitado = false;

	public Nodo(String etiqueta, int numNodo) {
		this.etiqueta = etiqueta;
		this.grado = 0;
		this.numeroDeNodo = numNodo;
		this.conexiones = new ArrayList<Arista>();
	}

	public Nodo(int numNodo) {
		this.grado = 0;
		this.numeroDeNodo = numNodo;
		this.conexiones = new ArrayList<Arista>();
	}

	public void addConexion(Arista a) {
		conexiones.add(a);
		incrementarGrado();
	}

	public List<Arista> getConexiones() {
		return conexiones;
	}

	public void setVisitado(boolean s) {
		visitado = s;
	}

	public boolean isVisitado() {
		return visitado;
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
