package hivolts;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;

/**
 * Created by Neelay Junnarkar, September 2014
 */

public class Main {

	JFrame frame = new JFrame("Neelay Junnarkar APCS Hivolts");
	Screen screen = new MainScreen();

	public Main() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
        frame.add(screen);
		frame.setVisible(true);
        screen.requestFocusInWindow();
        gameLoop();
    }

    private void gameLoop() {
        while(frame.isActive()) {
            screen = screen.update();
            if (screen == null) {
                System.out.println("null");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                return;
            }
            frame.repaint();
        }
    }
	public static void main(String[] args) {
		new Main();
	}
}
