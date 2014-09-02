package us_flag;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		JFrame frame = new JFrame("Neelay Junnakrar 2nd Period APCS Kuszmaul US Flag");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 610);
        Flag flag = new Flag();
        frame.add(flag);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}