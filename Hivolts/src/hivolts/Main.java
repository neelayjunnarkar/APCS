package hivolts;

import javax.swing.JFrame;

public class Main {
	JFrame frame = new JFrame("Neelay Junnarkar APCS Hivolts");
	Screen screen = new MainScreen();
	
	public Main() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(screen);
		screen.requestFocusInWindow();
		gameloop();
	}
	
	private void gameloop() {
		while (frame.isEnabled()) {
			screen = screen.update();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
