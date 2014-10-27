package chatClient;

import java.io.*;
import java.net.*;

public class TCP_Client {

	String msg;
	String buf;
	
	Socket socket;
	InetAddress addr = InetAddress.getByName("123.123.321.321");
	BufferedReader usr_in = new BufferedReader( new InputStreamReader(System.in));
	DataOutputStream serv_out = new DataOutputStream(socket.getOutputStream());
	BufferedReader serv_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
	public TCP_Client() throws UnknownHostException, IOException {
		socket = new Socket(addr, 3950);
		
		while (true) {
			msg = usr_in.readLine();
			serv_out.writeBytes(msg+'\n');
			if ((buf = serv_in.readLine()) == null) {
				System.out.println("connection terminated");
				break;
			}
			System.out.println("server: "+buf);
			
		}
		socket.close();
	}
	public static void main(String[] args) {
		try {
			new TCP_Client();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
