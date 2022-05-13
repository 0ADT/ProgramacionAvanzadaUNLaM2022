package ejercicios_en_clase.luchadoresJaponeses;

import java.util.ArrayList;
import java.util.List;

public class Torneo {
	private List<Luchador> luchadores = new ArrayList<Luchador>();
	private Archivo ArchivoDelTorneo;
	private String nombreDelTorneo;
	
	public Torneo(String nomTorneo, String rutaArchivoInscriptos, String rutaArchivoResultados) {
		this.nombreDelTorneo = nomTorneo;
		this.ArchivoDelTorneo = new Archivo(rutaArchivoInscriptos, rutaArchivoResultados);
		this.luchadores = ArchivoDelTorneo.leerInscriptos();
	}
	
	private boolean guardarResultados() {
		return ArchivoDelTorneo.escribirResultados(luchadores);
	}
	
	public void iniciarCompetencia() {
		if(luchadores == null) {
			System.err.println("Los luchadores no se han cargado correctamente en el torneo --" + this.nombreDelTorneo + "--.");
			return;
		}

		//Se compara cada luchador con cada luchador
		for(int i = 0; i < luchadores.size(); i++) {
			for(int j = 0; j < luchadores.size(); j++) {
				if(i != j) {
					if(luchadores.get(i).dominaAlLuchador(luchadores.get(j)))
						luchadores.get(i).incrementarDominados();
				}
			}
		}
		
		if(guardarResultados())
			System.out.println("Los resultados del torneo --" + this.nombreDelTorneo + "-- se han guardado correctamente.");
		else
			System.out.println("Ha ocurrido un error al guardar los resultados del torneo --" + this.nombreDelTorneo + "--.");
	}
}
