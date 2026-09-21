// TCP3
import java.net.*;
import java.io.*;

public class ClientTCP3
{
	public static void main(String[] args)
	{
		try
		{
			Socket socket = new Socket("localhost", 2017);
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

			dOut.writeUTF(args[0]);

// reception depuis le serveur
			DataInputStream dIn = new DataInputStream(socket.getInputStream());
			System.out.println("Message recu du serveur: " + dIn.readUTF());

			socket.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
