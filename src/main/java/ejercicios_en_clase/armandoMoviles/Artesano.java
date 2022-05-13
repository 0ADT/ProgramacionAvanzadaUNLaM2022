package ejercicios_en_clase.armandoMoviles;

import java.util.Collections;
import java.util.List;

public class Artesano {
	private List<Colgante> colgantes;
	private ArchivoDeColgantes archivoDeColgantes;
	private int pesoColgantesArmados;
	private int varillasMovilesArmados;
	
	public Artesano(String entrada, String salida) {
		archivoDeColgantes = new ArchivoDeColgantes(entrada, salida);
	}
	
	public void ArmarColgantes() {
		Collections.sort(colgantes);
		
		for(int i = 0; i < colgantes.size() - 1; i++) {
			if(colgantes.get(i).TieneElMismoPeso(colgantes.get(i + 1))) {
				pesoColgantesArmados += colgantes.get(i).getPeso() * 2;
				varillasMovilesArmados++;
				i++;
			}
		}
	}
	
	public boolean CargarColgantes() {
		colgantes = archivoDeColgantes.LeerEntrada();
		
		return colgantes != null;
	}
	
	public boolean GuardarColgantes() {
		return archivoDeColgantes.GuardarSalida(pesoColgantesArmados, varillasMovilesArmados);
	}
}
