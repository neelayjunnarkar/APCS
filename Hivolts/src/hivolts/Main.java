package hivolts;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {

    JFrame frame = new JFrame("Neelay Junnarkar APCS 2nd Period Hivolts");
    Panel panel = new Panel();

	public Main() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
        frame.requestFocusInWindow();
        frame.add(panel);
        frame.setVisible(true);

	}

    public static void main(String[] args) {
		new Main();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                panel.setGame();
                System.out.println("enter");
                break;
            case KeyEvent.VK_ESCAPE:
                panel.setMain();
                System.out.println("escape");
                break;
            default:
                System.out.println("pressed");
                break;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
