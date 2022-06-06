package desafios_del_taller.miniChat;

import java.io.Serializable;

public class PaqueteChat implements Serializable{

	private static final long serialVersionUID = 3435570502045552668L;
	private final String usuario;
	private String mensaje;
	
	public PaqueteChat(String nombre) {
		usuario = nombre;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
}
