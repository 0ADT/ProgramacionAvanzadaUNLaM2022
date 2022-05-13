package ejercicios_loom.oia2;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ejercicios_loom.oia2.Deposito;

public class TestMesadaDeGranito {

	private String entrada = "src\\test\\resources\\ejercicios_loom\\oia2\\Lote De Prueba\\Entrada\\";
	private String salidaEjecucion = "src\\test\\resources\\ejercicios_loom\\oia2\\Lote De Prueba\\Salida Ejecucion\\";
	private String salidaEsperada = "src\\test\\resources\\ejercicios_loom\\oia2\\Lote De Prueba\\Salida Esperada\\";

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

	@Test
	public void Caso_01_Flujo_Normal() {		
		Deposito depo = new Deposito();

		depo.CargarMesadas(entrada + "Caso_01_Flujo_Normal.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas(salidaEjecucion + "Caso_01_Flujo_Normal.out");

		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_01_Flujo_Normal.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_01_Flujo_Normal.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_02_Minima_Cantidad_De_Mesadas() {
		Deposito depo = new Deposito();

		depo.CargarMesadas(entrada + "Caso_02_Minima_Cantidad_De_Mesadas.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas(salidaEjecucion + "Caso_02_Minima_Cantidad_De_Mesadas.out");

		List<String> lineasArchivoSalidaEsperada = leerArchivo(
				salidaEsperada + "Caso_02_Minima_Cantidad_De_Mesadas.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(
				salidaEjecucion + "Caso_02_Minima_Cantidad_De_Mesadas.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_03_Ninguna_Mesada_se_apila() {
		Deposito depo = new Deposito();

		depo.CargarMesadas(entrada + "Caso_03_Ninguna_Mesada_se_apila.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas(salidaEjecucion + "Caso_03_Ninguna_Mesada_se_apila.out");

		List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada + "Caso_03_Ninguna_Mesada_se_apila.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion + "Caso_03_Ninguna_Mesada_se_apila.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_04_Maxima_Cantidad_De_Mesadas_Todas_Se_Apilan() {
		Deposito depo = new Deposito();

		depo.CargarMesadas(entrada + "Caso_04_Maxima_Cantidad_De_Mesadas_Todas_Se_Apilan.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas(salidaEjecucion + "Caso_04_Maxima_Cantidad_De_Mesadas_Todas_Se_Apilan.out");

		List<String> lineasArchivoSalidaEsperada = leerArchivo(
				salidaEsperada + "Caso_04_Maxima_Cantidad_De_Mesadas_Todas_Se_Apilan.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(
				salidaEjecucion + "Caso_04_Maxima_Cantidad_De_Mesadas_Todas_Se_Apilan.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_05_Mesadas_Rotadas_Y_Ordenadas() {
		Deposito depo = new Deposito();

		depo.CargarMesadas(entrada + "Caso_05_Mesadas_Rotadas_Y_Ordenadas.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas(salidaEjecucion + "Caso_05_Mesadas_Rotadas_Y_Ordenadas.out");

		List<String> lineasArchivoSalidaEsperada = leerArchivo(
				salidaEsperada + "Caso_05_Mesadas_Rotadas_Y_Ordenadas.out");
		List<String> lineasArchivoSalidaPrograma = leerArchivo(
				salidaEjecucion + "Caso_05_Mesadas_Rotadas_Y_Ordenadas.out");

		assertEquals(true, lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}

	@Test
	public void Caso_06_Maxima_Cantidad_De_Mesadas_Con_Valores_Diferentes() {
		Deposito depo = new Deposito();

		depo.CargarMesadas(entrada + "Caso_06_Maxima_Cantidad_De_Mesadas_Con_Valores_Diferentes.in");
		depo.ApilarMesadas();
		depo.GuardarMesadas(salidaEjecucion + "Caso_06_Maxima_Cantidad_De_Mesadas_Con_Valores_Diferentes.out");

		// List<String> lineasArchivoSalidaEsperada = leerArchivo(salidaEsperada +
		// "Caso_06_Maxima_Cantidad_De_Mesadas_Con_Valores_Diferentes.out");
		// List<String> lineasArchivoSalidaPrograma = leerArchivo(salidaEjecucion +
		// "Caso_06_Maxima_Cantidad_De_Mesadas_Con_Valores_Diferentes.out");

		// assertEquals(true,
		// lineasArchivoSalidaEsperada.equals(lineasArchivoSalidaPrograma));
	}
}
