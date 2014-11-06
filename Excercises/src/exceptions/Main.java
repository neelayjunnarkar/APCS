package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
	public static void main(String[] args) {
		System.out.println("contents of text.txt: ");
		cat(new File("C:/Users/95028672/workspace/APCS/Excercises/src/exceptions/text.txt")); //prints contents of text.txt
		System.out.println("cat: finished");
		
		ListOfNumbers listn = new ListOfNumbers();
		
		System.out.println("ListOfNumbers initial size: "+listn.list.size());
		System.out.print("Initial list: ");
		for (int i : listn.list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		listn.writeList(); //writes to OutFile.txt
		
		listn.readList(new File("C:/Users/95028672/workspace/APCS/Excercises/src/exceptions/text.txt")); //reads from text.txt and appends to list in ListOfNumbers
		
		System.out.println("ListOfNumbers final size: "+listn.list.size());
		System.out.print("Final list: ");
		for (int i : listn.list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	//added catch blocks as well as a try-catch block for "input.close()"
	public static void cat(File file) {
	    RandomAccessFile input = null;
	    String line = null;
        try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
			    System.out.println(line);
			}
		} catch (FileNotFoundException e) {
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
}
