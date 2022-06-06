package desafios_del_taller.miniChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private PaqueteChat paquete;

	public Client(String ip, int puerto) throws UnknownHostException, IOException {
		System.out.println("Ingrese un nombre de usuario:");

		Scanner scanner = new Scanner(System.in);

		paquete = new PaqueteChat(scanner.nextLine());
		System.out.println("Conectando al servidor...");

		// Conecta a un Server. Si no esta activo da Exception:
		// java.net.ConnectException
		Socket socket = new Socket(ip, puerto);

		// Flujos de información
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		// DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
		ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
		boolean salir = false;

		// Enviar mensaje escrito por consola
		// String mensajeConsola;// = scanner.nextLine();

		// Recibir mensaje
		System.out.println("Cliente conectado.");
		System.out.println("Soy el cliente número: " + entrada.readUTF());

		while (!salir) {

			// mensajeConsola = scanner.nextLine();
			paquete.setMensaje(scanner.nextLine());

			if (paquete.getMensaje().equals("/salir") || paquete.getMensaje().equals("/s")
					|| paquete.getMensaje().equals("/q")) {
				salir = true;
			} else {
				// salida.writeUTF(nombre + ": " + mensajeConsola);
				System.out.println("Yo: " + paquete.getMensaje());
				salida.writeObject(paquete);
				salida.flush();
				salida.reset();
			}

		}

		scanner.close();
		// Cierre de recursos
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
