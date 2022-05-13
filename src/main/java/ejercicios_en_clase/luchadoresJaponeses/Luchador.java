package ejercicios_en_clase.luchadoresJaponeses;

public class Luchador {

	private int peso;
	private int altura;
	private int cantLuchadoresDominados;

	public Luchador(int peso, int altura) {
		this.altura = altura;
		this.peso = peso;
		this.cantLuchadoresDominados = 0;
	}

	public void incrementarDominados() {
		this.cantLuchadoresDominados++;
	}

	public int getCantLuchadoresDominados() {
		return cantLuchadoresDominados;
	}

	public boolean dominaAlLuchador(Luchador contrincante) {
		if ( (this.peso > contrincante.peso && this.altura > contrincante.altura)
				|| (this.peso == contrincante.peso && this.altura > contrincante.altura)
				|| (this.peso > contrincante.peso && this.altura == contrincante.altura) )
			return true;

		return false;
	}
}
