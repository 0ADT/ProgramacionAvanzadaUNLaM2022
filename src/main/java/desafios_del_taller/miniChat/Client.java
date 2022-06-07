package desafios_del_taller.miniChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client extends Thread {
	private MensajesChat mensajeChat;
	private static DataInputStream entrada;

	@Override
	public void run() {
		boolean cerrar = false;

		while (!cerrar) {
			try {
				System.out.println(entrada.readUTF());
			} catch (IOException e) {
				try {
					cerrar = true;
					entrada.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void MostrarHistorial(String mc) {
		for (String s : mc.split("\n", 0))
			System.out.println(s);
	}

	public Client(String ip, int puerto) throws UnknownHostException, IOException, ClassNotFoundException {
		System.out.println("Ingrese un nombre de usuario:");

		Scanner scanner = new Scanner(System.in);

		scanner.useDelimiter("\n");
		mensajeChat = new MensajesChat(scanner.nextLine());
		System.out.println("Conectando al servidor...");

		// Conecta a un Server. Si no esta activo da Exception:
		// java.net.ConnectException
		Socket socket = new Socket(ip, puerto);

		// Flujos de información
		entrada = new DataInputStream(socket.getInputStream());

		ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
		boolean salir = false;

		// Recibir mensaje del historial
		MostrarHistorial(entrada.readUTF());

		// envio el nombre y un mensaje vacio
		salida.writeObject(mensajeChat);
		salida.flush();
		salida.reset();

		Thread t = new Thread(this);

		t.start();

		// Para que no quede tan feo, agrego la fecha y hora a lo que mande el cliente
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		while (!salir) {
			mensajeChat.setMensaje(scanner.nextLine());

			if (mensajeChat.getMensaje().equals("/salir") || mensajeChat.getMensaje().equals("/s")
					|| mensajeChat.getMensaje().equals("/q")) {
				salir = true;
			} else {
				System.out.println(dtf.format(LocalDateTime.now()) + " - " + "Yo: " + mensajeChat.getMensaje());
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
		System.out.println("Ha cerrado la conexion");
	}

	public static void main(String[] args) {
		try {
			new Client("localhost", 20000);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Te has desconectado del servidor debido a un error.");
			System.err.println("Te has desconectado del servidor debido a un error.");
		}
	}
}
