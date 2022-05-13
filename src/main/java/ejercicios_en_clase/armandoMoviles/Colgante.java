package ejercicios_en_clase.armandoMoviles;

public class Colgante implements Comparable<Colgante>{
	private int peso;
	
	public int getPeso() {
		return peso;
	}

	public Colgante(int peso) {
		this.peso = peso;
	}

	public boolean TieneElMismoPeso(Colgante otroColgante) {
		return this.peso == otroColgante.peso;
	}

	public int compareTo(Colgante o) {
		if(this.peso < o.peso)
			return -1;
		else if(this.peso > o.peso)
			return 1;

		return 0;
	}
}
