package chatClient;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class TCP_Client {

	String msg, buf;
	Socket socket;

	public TCP_Client() throws UnknownHostException, IOException {
		String serverAddress = "199.80.145.98";
		socket = new Socket(serverAddress, 9990);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
