package ejercicios_OIA.rescatandoALaPrincesa;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestRescatePrincesa {

	Rescate rescate;

	@Test
	public void Caso_01_Enunciado() {
		ejecutarCaso("Caso_01_Enunciado");
	}

	@Test
	public void Caso_02_El_principe_fue_interceptado() {
		ejecutarCaso("Caso_02_El_principe_fue_interceptado");
	}

	@Test
	public void Caso_03_No_hay_camino_entre_el_principe_y_la_princesa() {
		ejecutarCaso("Caso_03_No_hay_camino_entre_el_principe_y_la_princesa");
	}

	@Test
	public void Caso_04_Minima_cantidad_de_claros() {
		ejecutarCaso("Caso_04_Minima_cantidad_de_claros");
	}

	public void ejecutarCaso(String nombreCaso) {
		String in = "src\\test\\resources\\ejercicios_OIA\\rescatandoALaPrincesa\\Lote De Prueba\\Entrada\\"
				+ nombreCaso + ".in";
		String expected = "src\\test\\resources\\ejercicios_OIA\\rescatandoALaPrincesa\\Lote De Prueba\\Salida Esperada\\"
				+ nombreCaso + ".out";
		String actual = "src\\test\\resources\\ejercicios_OIA\\rescatandoALaPrincesa\\Lote De Prueba\\Salida Ejecucion\\"
				+ nombreCaso + ".out";

		rescate = new Rescate(ArchivoRescate.LeerArchivoRescate(in));
		ArchivoRescate.EscribirArchivoRescate(actual, rescate.rescatar());

		List<String> lineasArchivoSalidaEsperada = leerArchivo(expected);
		List<String> lineasArchivoSalidaPrograma = leerArchivo(actual);

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	/**
	 * @brief Metodo para cargar las lineas de los archivos
	 * 
	 * @param archivo: ruta completa donde se encuentran los archivos
	 * 
	 * @return Una lista con todas las lineas del archivo
	 **/
	private List<String> leerArchivo(String archivo) {
		List<String> lineasArchivo = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(archivo)));
			String linea;

			while ((linea = br.readLine()) != null) {
				lineasArchivo.add(linea);
			}

			br.close();
		} catch (Exception e) {
			System.err.println("Error al leer un archivo en el test " + archivo);
			throw new AssertionError();
		}

		return lineasArchivo;
	}

}
