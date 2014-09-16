package hivolts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main implements KeyListener {

	public static final int width = 640, height = 640;
	
	JFrame frame = new JFrame("Neelay Junnarkar Hivolts 2 APCS ");
	Panel panel = new Panel();
	
	public Main() {
		frame.addKeyListener(this);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		while (frame.isActive()) {
			panel.repaint();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			break;
		case KeyEvent.VK_ESCAPE:
			break;
		default:
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
