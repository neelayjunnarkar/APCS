package us_flag;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		JFrame frame = new JFrame("Neelay Junnarkar 2nd Period APCS Kuszmaul US Flag");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 720);
        Flag flag = new Flag();
        frame.add(flag);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}