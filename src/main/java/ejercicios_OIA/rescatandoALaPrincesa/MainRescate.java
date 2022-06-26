package ejercicios_OIA.rescatandoALaPrincesa;

public class MainRescate {

	public static void main(String[] args) {
		GrafoRescate gr = ArchivoRescate
				.LeerArchivoRescate("src\\main\\resources\\ejercicios_loom\\rescatandoALaPrincesa\\princesa.in");
		Rescate r = new Rescate(gr);
		ArchivoRescate.EscribirArchivoRescate(
				"src\\main\\resources\\ejercicios_loom\\rescatandoALaPrincesa\\princesa.out", r.rescatar());
	}

}
