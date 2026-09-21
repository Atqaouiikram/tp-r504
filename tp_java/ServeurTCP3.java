// TCP3
import java.net.*;
import java.io.*;

public class ServeurTCP3 {

	public static void main(String[] args) {

		try {
			ServerSocket socketserver = new ServerSocket(2017);

			while (true) {

				System.out.println("Serveur en attente");

				Socket socket = socketserver.accept();

				System.out.println("Connexion d'un client");

				DataInputStream dIn = new DataInputStream(socket.getInputStream());

				String msg = dIn.readUTF();

				System.out.println("Message: " + msg);

// inverse la chaîne
				String rev = new StringBuilder(msg).reverse().toString();

// renvoie la chaîne inversée au client
				DataOutputStream dOut =
		new DataOutputStream(socket.getOutputStream());

dOut.writeUTF(rev);
			socket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
