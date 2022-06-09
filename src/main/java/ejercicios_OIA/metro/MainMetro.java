package ejercicios_OIA.metro;

public class MainMetro {

	public static void main(String[] args) {
		System.out.println("Inicia metro");

		String path = "src\\main\\resources\\ejercicios_loom\\metro\\metro";
		Metro m = new Metro(ArchivoMetro.LeerArchivoMetro(path + ".in"));		
		ArchivoMetro.EscribirArchivoMetro(path + ".out", m.BuscarMinimoNumPuentes());
		System.out.println("Fin del proceso de metro");
	}

}
