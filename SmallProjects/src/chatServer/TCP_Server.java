package chatServer;

import java.io.*;
import java.net.*;

public class TCP_Server {


	String msg, buf;
	
	public TCP_Server() throws IOException {
	        ServerSocket serv_socket = new ServerSocket(9097);
	        Socket socket = null;
	        try {
                socket = serv_socket.accept();
	            while (true) {
	                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	                    BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
	                    buf = in.readLine();
	                    buf = buf+"e";
	                    out.write(buf);
	            }
	        } finally {
	        	socket.close();
	            serv_socket.close();
	        }
		
	}
	
	public static void main(String[] args) {
		try {
			new TCP_Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
