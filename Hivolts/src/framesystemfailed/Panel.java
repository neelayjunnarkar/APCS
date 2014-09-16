package framesystemfailed;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Panel extends JPanel {

	Screen screen;
	
	public Panel() {
		screen = new MainScreen();
		add(screen);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Panel paint");
		if (screen instanceof GameScreen) {
			System.out.println("game");
			((GameScreen)screen).update(g);
			//((GameScreen)screen).repaint();
		} else if (screen instanceof MainScreen) {
			System.out.println("main");
			((MainScreen)screen).update(g);
			//((MainScreen)screen).repaint();
		}
	}
	
	
	public void setGame() {
		screen = new GameScreen();
		//update(getGraphics());
	}
	
	public void setMain() {
		screen = new MainScreen();
		//update(getGraphics());
	}
	
}
