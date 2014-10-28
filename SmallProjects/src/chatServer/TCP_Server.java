package chatServer;

import java.io.*;
import java.net.*;

public class TCP_Server {


	public TCP_Server() throws IOException {
	        ServerSocket serv_socket = new ServerSocket(9099);
	        Socket socket = null;
	        try {
                socket = serv_socket.accept();
	            while (true) {
	                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	                    out.println("hello");
	            }
	        } finally {
	        	socket.close();
	            serv_socket.close();
	        }
		
	}
	
	public static void main(String[] args) {
		try {
			TCP_Server server = new TCP_Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
