package chatServer;

import java.io.*;
import java.net.*;

public class TCP_Server {

	String msg, buf;
	
	ServerSocket serv_sock;
	Socket sock;
	
	BufferedReader usr_in = new BufferedReader( new InputStreamReader(System.in));
	DataOutputStream client_out = new DataOutputStream(sock.getOutputStream());
	BufferedReader client_in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	
	public TCP_Server() throws IOException {
		serv_sock = new ServerSocket(3950);
		sock = serv_sock.accept();
		
		while (true) {
			msg = usr_in.readLine();
			client_out.writeBytes(msg+'\n');
			if ((buf = client_in.readLine()) == null) {
				System.out.println("connection terminated");
				break;
			}
			System.out.println("client: "+buf);
		}
		sock.close();
		serv_sock.close();
		
	}
	
	public static void main(String[] args) {
		try {
			new TCP_Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
