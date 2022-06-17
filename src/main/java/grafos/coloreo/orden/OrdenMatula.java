package grafos.coloreo.orden;

import java.util.Collections;
import java.util.List;

import grafos.Grafo;
import grafos.Nodo;

public class OrdenMatula implements MetodoOrdenamiento {

	@Override
	public Orden generarOrden(Grafo g) {
		List<Nodo> nodos = g.getNodos();

		Collections.sort(nodos, (n1, n2) -> {
			return n1.getGrado() - n2.getGrado();
		});

		Orden orden = new Orden(nodos.size());

		for (int i = 0; i < nodos.size(); i++) {
			orden.set(nodos.get(i), i);
		}

		return orden;
	}
}
