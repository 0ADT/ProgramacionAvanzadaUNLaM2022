package desafios_del_taller.miniChat;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
	private int puerto;
	// private ArrayList<Socket> clientes;

	public Server(int puerto) throws IOException {
		this.puerto = puerto;

		EscuchaActiva();
	}

	private void EscuchaActiva() throws IOException {
		ServerSocket servidor = new ServerSocket(puerto);

		System.out.println("Server inicializando...");

		int numeroCliente = 1;

		// Se "congela" en la siguiente linea, hasta que llegue un pedido
		Socket socket = servidor.accept();

		// Flujos de información
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
		// DataInputStream entrada = new DataInputStream(socket.getInputStream());
		// ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

		System.out.println("Conectado cliente: " + numeroCliente);
		salida.writeUTF("" + numeroCliente);

		boolean salir = false;
		// PaqueteChat paquete;

		while (!salir) {
			try {
				PaqueteChat paquete = (PaqueteChat) entrada.readObject();
				System.out.println(paquete.getUsuario() + " dice: " + paquete.getMensaje());

			} catch (EOFException | SocketException e) {
				System.out.println("El cliente esta desconectado");

				// Se cierran recursos
				entrada.close();
				salida.close();
				socket.close();

				socket = servidor.accept();
				salida = new DataOutputStream(socket.getOutputStream());
				// salida = new ObjectOutputStream(socket.getOutputStream());
				entrada = new ObjectInputStream(socket.getInputStream());
				// entrada = new DataInputStream(socket.getInputStream());

				System.out.println("Conectado cliente: " + numeroCliente);
				salida.writeUTF("" + numeroCliente);
			} catch (Exception e) {
				System.out.println("Error no identificado");
				System.out.println("Server Finalizado");
				entrada.close();
				salida.close();
				socket.close();
				servidor.close();
				System.out.println(e.getCause());
				salir = true;
			}
		}
	}

	public static void main(String[] args) {
		try {
			Server s = new Server(20000);
			// Thread t = new Thread(s);

			// t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
