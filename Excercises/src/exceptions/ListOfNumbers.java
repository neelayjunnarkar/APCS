package exceptions;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
     List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }
    
    /**
     * 
     * @param file the file from which to read numbers and append to list
     */
    public void readList(File file) {
    	RandomAccessFile input = null;
 	    String line = null;
        try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				list.add(new Integer(line).intValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("C:/Users/95028672/workspace/APCS/Excercises/src/exceptions/OutFile.txt"));
        
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    
}