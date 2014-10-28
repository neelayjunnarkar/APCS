package chatClient;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class TCP_Client {

	String msg, buf;
	Socket socket;

	public TCP_Client() throws UnknownHostException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		msg = in.readLine();
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String serverAddress = "199.80.144.121";

		socket = new Socket(serverAddress, 9097);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.write(msg);
		buf = input.readLine();
		System.out.println(buf);
		System.exit(0);
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
