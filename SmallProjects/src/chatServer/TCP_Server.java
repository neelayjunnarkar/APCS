package chatServer;

import java.io.*;
import java.net.*;

public class TCP_Server {


	public TCP_Server() throws IOException {
	        ServerSocket serv_socket = new ServerSocket(9090);
	        try {
	            while (true) {
	                Socket socket = serv_socket.accept();
	                try {
	                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	                    out.println("hello");
	                } finally {
	                    socket.close();
	                }
	            }
	        }
	        finally {
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
