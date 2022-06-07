package desafios_del_taller.miniChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Server {
	private static Map<Integer, DataOutputStream> clientes = new HashMap<>();

	/**
	 * @brief Envia los mensajes a todos los usuarios conectados al servidor
	 * 
	 * @param numCliente: El numero que se le asigno al entrar al servidor
	 * @param mensaje:    El mensaje a enviar a todos los usuarios
	 **/
	public static void EnviarMensajes(int numCliente, String mensaje) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		Iterator<Entry<Integer, DataOutputStream>> it = clientes.entrySet().iterator();

		mensaje = dtf.format(LocalDateTime.now()) + " - " + mensaje;
		RegistroChat.EscribirRegistro(mensaje);

		while (it.hasNext()) {
			try {
				Map.Entry<Integer, DataOutputStream> me = (Entry<Integer, DataOutputStream>) it.next();

				if (numCliente != (Integer) me.getKey())
					((DataOutputStream) me.getValue()).writeUTF(mensaje);
			} catch (IOException e) {
				it.remove();
			}
		}
	}

	public static void main(String[] args) {
		ServerSocket server = null;

		try {
			server = new ServerSocket(20000);
			Socket sc;
			int numeroCliente = 1;

			System.out.println("Servidor iniciado");

			while (true) {
				// Espero la conexion del cliente
				sc = server.accept();

				ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
				DataOutputStream out = new DataOutputStream(sc.getOutputStream());

				out.writeUTF(RegistroChat.LeerRegistro());
				clientes.put(numeroCliente, out);// agrego la conexion para enviar

				String nombreCliente = ((MensajesChat) in.readObject()).getUsuario();

				// Inicio el hilo
				ServerHilo hilo = new ServerHilo(numeroCliente, nombreCliente, in);

				numeroCliente++;
				hilo.start();
				EnviarMensajes(numeroCliente, nombreCliente + " se conecto a la sala.");
				System.out.println("Creada la conexion con el cliente " + nombreCliente);
			}

		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
