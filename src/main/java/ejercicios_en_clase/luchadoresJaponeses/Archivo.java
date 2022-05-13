package ejercicios_en_clase.luchadoresJaponeses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

	private String ubicacionEntrada;
	private String ubicacionSalida;

	public Archivo(String rutaArchivoEntrada, String rutaArchivoSalida) {
		this.ubicacionEntrada = rutaArchivoEntrada;
		this.ubicacionSalida = rutaArchivoSalida;
	}

	/**
	 * @brief Lee el archivo de entrada con los luchadores inscriptos
	 * 
	 * @returns Lista de Luchadores, null si hubo un error
	 **/
	public List<Luchador> leerInscriptos() {
		List<Luchador> luchadores = new ArrayList<Luchador>();

		try { 
			File file = new File(this.ubicacionEntrada);

			// Verificar si existe el archivo.
			if (!file.exists()) {
				return null;
			}
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			int cantLuchadores = Integer.parseInt(br.readLine());//lee la cantidad de luchadores
			
			for(int i = 0; i < cantLuchadores; i++) {
				String valores[] = br.readLine().split(" ");
				luchadores.add(new Luchador(Integer.parseInt(valores[0]), Integer.parseInt(valores[1])));
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return luchadores;
	}

	/**
	 * @brief Escribe, en el orden de inscripcion de los luchadores, cuantos dominan
	 *        cada uno.
	 * 
	 * @returns true si se escribio el archivo con exito, false si hubo un error.
	 */
	public boolean escribirResultados(List<Luchador> luchadores) {
		try {
			File file = new File(this.ubicacionSalida); // Instanciar referencia de la Clase File

			// Verificar si existe el archivo.
			if (!file.exists()) {
				file.createNewFile();// Crear archivo.
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			for (Luchador luchador : luchadores) {
				bw.write(luchador.getCantLuchadoresDominados() + "\n");
			}

			bw.close();// Cerrar el archivo.
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
