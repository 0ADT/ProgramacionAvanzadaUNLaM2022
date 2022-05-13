package ejercicios_loom.oia2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoDeMesadas {
	public List<Mesada> LeerArchivo(String ubicacion){
		List<Mesada> mesadas = new ArrayList<Mesada>();
		
		try {
			File archivo = new File(ubicacion);
			
			if(!archivo.exists()) {
				return null;
			}
			
			Scanner sc = new Scanner(archivo);
			
			int cantMesadas = sc.nextInt();
				
			for(int i = 0; i < cantMesadas; i++) {
				Mesada mesada = new Mesada(sc.nextInt(), sc.nextInt());
				
				mesadas.add(mesada);
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getCause());
			mesadas = null;
		}
		
		return mesadas;
	}
	
	public boolean EscribirArchivo(String ubicacion, int valor) {
		try {
			File archivo = new File(ubicacion);
			
			if(!archivo.exists())
				archivo.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			
			bw.write(valor + "");
			bw.close();
		} catch (Exception e) {
			System.err.println(e.getCause());
			return false;
		}
		
		return true;
	}
}
