package exceptions;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
	public static void main(String[] args) {
		cat(new File("C:/Users/95028672/workspace/APCS/Excercises/src/exceptions/text.txt"));
	}
	
	public static void cat(File file) {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } catch (Throwable e) {
	    	
	    } finally {
	        if (input != null) {
	            try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
}
