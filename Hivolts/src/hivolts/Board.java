package hivolts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

/**
 * Created by Neelay Junnarkar, September 2014
 */

public class Board extends JComponent {

	Entity[] board = new Entity[144];
	
	public Board() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		
		drawGrid(g2d);
	}
	
	private void drawGrid(Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, 100, 100);
	}
}
