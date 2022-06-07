package desafios_del_taller.miniChat;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketException;

public class ServerHilo extends Thread {
	private String nombre;
	private DataOutputStream salida;
	private ObjectInputStream entrada;

	public ServerHilo(String nombre, ObjectInputStream entrada, DataOutputStream salida) {
		this.nombre = nombre;
		this.salida = salida;
		this.entrada = entrada;
	}

	@Override
	public void run() {
		boolean salir = false;

		while (!salir) {
			try {
				MensajesChat mensajeChat = (MensajesChat) entrada.readObject();
				System.out.println(mensajeChat.getUsuario() + " dice: " + mensajeChat.getMensaje());

			} catch (EOFException | SocketException e) {
				System.out.println("El cliente " + nombre + " esta desconectado");
				salir = true;
				
				// Se cierran recursos
				try {
					entrada.close();
					salida.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("Error no identificado");
				System.out.println("Server Finalizado");

				try {
					entrada.close();
					salida.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				System.out.println(e.getCause());
				salir = true;
			}
		}
	}

}
