package ejercicios_OIA.metro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Metro {
	private GrafoMetro planoCiudad;

	public Metro(GrafoMetro planoCiudad) {
		this.planoCiudad = planoCiudad;
	}

	public int BuscarMinimoNumPuentes() {
		// recorrer todos los nodos atravesando la menor cantidad de puentes (-1)
		// usar BFS modificado
		List<Integer> islasVisitadas = new ArrayList<Integer>(planoCiudad.getCantNodos());
		int cantPuentesVisitados = 0;
		Queue <Integer> colaIslasVisitar = new LinkedList<>();
		
		
		return 0;
	}
}
