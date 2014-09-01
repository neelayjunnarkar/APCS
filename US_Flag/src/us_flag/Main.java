package us_flag;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		JFrame frame = new JFrame("Neelay Junnakrar 2nd Period APCS Kuszmaul US Flag");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 610);
        frame.add(new Flag());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}