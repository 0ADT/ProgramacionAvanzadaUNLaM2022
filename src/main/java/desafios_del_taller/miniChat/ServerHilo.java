package desafios_del_taller.miniChat;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketException;

public class ServerHilo extends Thread {
	private String nombre;
	private ObjectInputStream entrada;
	private int numeroCliente;

	public ServerHilo(int numeroCliente, String nombre, ObjectInputStream entrada) {
		this.nombre = nombre;
		this.entrada = entrada;
		this.numeroCliente = numeroCliente;
	}

	@Override
	public void run() {
		boolean salir = false;

		while (!salir) {
			try {
				MensajesChat mensajeChat = (MensajesChat) entrada.readObject();
				String mensaje = mensajeChat.getUsuario() + " dice: " + mensajeChat.getMensaje();

				System.out.println(mensaje);

				Server.EnviarMensajes(this.numeroCliente, mensaje);

			} catch (EOFException | SocketException e) {
				System.out.println("El cliente " + nombre + " esta desconectado");

				Server.EnviarMensajes(this.numeroCliente, nombre + " se ha desconectado");

				salir = true;

				// Se cierran recursos
				try {
					entrada.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("Error no identificado");
				System.out.println("Server Finalizado");

				try {
					entrada.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				System.out.println(e.getCause());
				salir = true;
			}
		}
	}

}
