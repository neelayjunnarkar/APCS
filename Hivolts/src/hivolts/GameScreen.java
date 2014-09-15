package hivolts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameScreen extends Screen {

	public GameScreen() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("paintgame");
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, 100, 100);
		g2d.fillRect(0, 100, 100, 100);
	}

}
