package hivolts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Fence extends Entity {

	Color fenceColor = Color.orange;
	
	public Fence(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("fence paint");
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setColor(fenceColor);
		g2d.fillRect(x*Main.width/12, y*Main.height/12, Main.width/12, Main.height/12);
	}

	@Override
	public void update() {
		Random rand = new Random();
		int r = rand.nextInt(3);
		switch (r) {
		case 0:
			fenceColor = Color.white;
			break;
		case 1:
			fenceColor = Color.orange;
			break;
		case 2:
			fenceColor = Color.red;
			break;
		default:
			fenceColor = Color.black;
			break;
		}
	}

	@Override
	public void draw(Graphics g) {
		//System.out.println("hello");
		//update(g);
		paintComponent(g);
	}
	
	
}
