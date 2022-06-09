package ejercicios_OIA.metro;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMetro {

	Metro metro;

	@Test
	public void Caso_01_Enunciado() {
		ejecutarCaso("Caso_01_Enunciado");
	}

	@Test
	public void Caso_02_Ningun_puente_entre_las_islas() {
		ejecutarCaso("Caso_02_Ningun_puente_entre_las_islas");
	}

	@Test
	public void Caso_03_Todas_las_islas_tienen_puentes() {
		ejecutarCaso("Caso_03_Todas_las_islas_tienen_puentes");
	}

	@Test
	public void Caso_04_Valores_maximos() {
		ejecutarCaso("Caso_04_Valores_maximos");
	}

	@Test
	public void Caso_05_Sin_puentes_ni_tuneles() {
		ejecutarCaso("Caso_05_Sin_puentes_ni_tuneles");
	}

	public void ejecutarCaso(String nombreCaso) {
		String in = "src\\test\\resources\\ejercicios_OIA\\metro\\Lote De Prueba\\Entrada\\" + nombreCaso + ".in";
		String expected = "src\\test\\resources\\ejercicios_OIA\\metro\\Lote De Prueba\\Salida Esperada\\" + nombreCaso
				+ ".out";
		String actual = "src\\test\\resources\\ejercicios_OIA\\metro\\Lote De Prueba\\Salida Ejecucion\\" + nombreCaso
				+ ".out";

		metro = new Metro(ArchivoMetro.LeerArchivoMetro(in));
		ArchivoMetro.EscribirArchivoMetro(actual, metro.BuscarMinimoNumPuentes());

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
