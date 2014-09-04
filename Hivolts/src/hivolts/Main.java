package hivolts;

import javax.swing.JFrame;

public class Main {
	JFrame frame = new JFrame("Neelay Junnarkar APCS Hivolts");
	Board board = new Board();
	public Main() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.add(board);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
