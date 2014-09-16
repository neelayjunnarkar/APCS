package framesystemfailed;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main implements KeyListener {
	
	JFrame frame = new JFrame("sfsafdafsa");
	Panel panel = new Panel();
	
	public Main() {
		frame.addKeyListener(this);
		frame.setSize(640, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("fdsaf");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			//System.out.println("enter");
			panel.setGame();
			panel.repaint();
			break;
		case KeyEvent.VK_ESCAPE:
			//System.out.println("escape");
			panel.setMain();
			panel.repaint();
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
