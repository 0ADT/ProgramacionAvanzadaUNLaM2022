package desafios_del_taller.miniChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private MensajesChat mensajeChat;

	public Client(String ip, int puerto) throws UnknownHostException, IOException {
		System.out.println("Ingrese un nombre de usuario:");

		Scanner scanner = new Scanner(System.in);

		mensajeChat = new MensajesChat(scanner.nextLine());
		System.out.println("Conectando al servidor...");

		// Conecta a un Server. Si no esta activo da Exception:
		// java.net.ConnectException
		Socket socket = new Socket(ip, puerto);

		// Flujos de información
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		// DataOutputStream salidaString = new
		// DataOutputStream(socket.getOutputStream());
		ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
		boolean salir = false;

		// Recibir mensaje
		System.out.println("Cliente conectado.");
		salida.writeObject(mensajeChat);
		salida.flush();
		salida.reset();
		// System.out.println("Soy el cliente número: " + entrada.readUTF());

		while (!salir) {

			// mensajeConsola = scanner.nextLine();
			mensajeChat.setMensaje(scanner.nextLine());

			if (mensajeChat.getMensaje().equals("/salir") || mensajeChat.getMensaje().equals("/s")
					|| mensajeChat.getMensaje().equals("/q")) {
				salir = true;
			} else {
				// salida.writeUTF(nombre + ": " + mensajeConsola);
				System.out.println("Yo: " + mensajeChat.getMensaje());
				salida.writeObject(mensajeChat);
				salida.flush();
				salida.reset();
			}
		}

		// Cierre de recursos
		scanner.close();
		entrada.close();
		salida.close();
		socket.close();
		System.out.println("Me cierro");
	}

	public static void main(String[] args) {
		try {
			new Client("localhost", 20000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
