package chatClient;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class TCP_Client {

	String msg, buf;
	Socket socket;

	public TCP_Client() throws UnknownHostException, IOException {
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address:");
		socket = new Socket(serverAddress, 9090);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		buf = input.readLine();
		JOptionPane.showMessageDialog(null, buf);
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
