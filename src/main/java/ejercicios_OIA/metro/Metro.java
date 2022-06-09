package ejercicios_OIA.metro;

public class Metro {
	private GrafoMetro planoCiudad;

	public Metro(GrafoMetro planoCiudad) {
		this.planoCiudad = planoCiudad;
	}

	public int BuscarMinimoNumPuentes() {
		planoCiudad.Algoritmo_kruskal_mod();		
		return planoCiudad.getCantMinimaDePuentes();
	}
}
