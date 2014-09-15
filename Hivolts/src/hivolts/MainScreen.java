package hivolts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainScreen extends Screen {
	
	public MainScreen() {
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		System.out.println("MainScreen paint");
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setColor(Color.black);
		g2d.fillRect(0,  0, 100, 100);
		g2d.fillRect(0,  0, 200, 200);
	}
	
}
