package hivolts;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Panel extends JPanel {

	Screen screen = new MainScreen();
	
	public Panel() {
		add(screen);
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("Panel paint");
		screen.update(g);
	}
	
	public void update(Graphics g) {
		paintComponent(g);
	}
	
	public void setGame() {
		screen = new GameScreen();
	}
	
	public void setMain() {
		screen = new MainScreen();
	}
	
}
