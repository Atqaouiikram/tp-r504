import java.io.*;
import java.net.*;

public class ClientUDP{
	public static void main( String[] args ){

		if (args.length <1)
		{
			System.out.println("erreur, pas d'arument");
			System.exit(1);
		}	
		String s=args[0];
		byte[] data=s.getBytes();

		try{
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("adresse="+addr.getHostName());
		DatagramPacket packet=new DatagramPacket(data, data.length,addr,1234);
		DatagramSocket sock=new DatagramSocket();
		sock.send(packet);
		sock.receive(packet);

		String str=new String(packet.getData());
		System.out.println("recepetion de " + str );
		sock.close();
	}

		catch (Exception ex ) {
			System.out.println("erreur!");
			ex.printStackTrace();
		}
	}

}
