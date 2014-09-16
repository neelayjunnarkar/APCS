package hivolts;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public abstract class Entity extends JComponent {

	int x, y;
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public int getX() { return x; }
	public int getY() { return y; }
	
	public abstract void update();
	public abstract void draw(Graphics g);
	
}
