package hivolts;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private ArrayList< ArrayList<Entity> > entities = new ArrayList< ArrayList<Entity> >(12);
	
	private enum Screen {
		MAIN, GAME, GAMEOVER;
	}
	Screen screen;
	
	
	public Panel() {
		setPreferredSize(new Dimension(Main.width, Main.height));
		screen = Screen.MAIN;
		for (int x = 0; x < 12; x++) {
			entities.add(new ArrayList<Entity>(12));
		}
		
		for (int xy = 0; xy < 12; xy++) {
			entities.get(0).add(xy, new Fence(0, xy));
			entities.get(11).add(xy, new Fence(11, xy));
			entities.get(xy).add(0, new Fence(xy, 0));
			entities.get(xy).add(new Fence(xy, 11));//idk
		}
		
//		Random rand = new Random();
//		int x, y;
//		for (int i = 0; i < 20; i++) {
//			x = rand.nextInt(10)+1;
//			y = rand.nextInt(10)+1;
//			entities.get(x).set(y, new Fence(x, y));
//		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
		for (ArrayList<Entity> a : entities) {
			for (Entity e : a) {
				e.update();
				e.draw(g);
			}
		}
	}

}
