package grafos.coloreo;

public class Coloreo {
	private int colores;
	private int[] coloresAsignados;

	public int getColores() {
		return colores;
	}

	public int[] getColoresAsignados() {
		return coloresAsignados;
	}

	public int getColorDelNodo(int nodo) {
		return coloresAsignados[nodo];
	}
}
