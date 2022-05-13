package ejercicios_loom.oia2;

public class Mesada implements Comparable<Mesada> {
	private int ancho;
	private int largo;

	/**
	 * @brief El constructor rota la mesada, de esta manera me garantizo tener los
	 *        valores mas altos en la misma variable para realizar las comparaciones
	 *        y ordenar.
	 * 
	 * @param ancho: medida de la mesada
	 * @param largo: medida de la mesada
	 **/
	public Mesada(int ancho, int largo) {
		if (ancho < largo) {
			this.ancho = largo;
			this.largo = ancho;
		} else {
			this.ancho = ancho;
			this.largo = largo;
		}
	}
	
	public boolean SePuedeApilar(Mesada otraMesada) {
		return ((this.ancho >= otraMesada.ancho && this.largo >= otraMesada.largo));
	}

	public int compareTo(Mesada o) {
		int val = 0;

		if (this.ancho < o.ancho)
			val = 1;
		else if (this.ancho > o.ancho)
			val = -1;

		return val;
	}
}
