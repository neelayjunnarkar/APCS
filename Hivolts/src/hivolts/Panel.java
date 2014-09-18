package hivolts;

import java.awt.*;
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
		screen = Screen.GAME;

        for (int x = 0; x < 12; x++) {
            entities.add(new ArrayList<Entity>(12));
            for (int y = 0; y < 12; y++) {
                if (y == 0 || x == 0 || y == 11 || x == 11) {
                    entities.get(x).add(new Fence(x, y));
                } else {
                    entities.get(x).add(new Entity(x, y));
                }
            }
        }

        Random rand = new Random();
        int x, y;
        for (int i = 0; i < 20; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            entities.get(x).set(y, new Fence(x, y));
        }

        do {
            x = rand.nextInt(10) + 1;
            y = rand.nextInt(10) + 1;
        } while (isOccupied(x, y));
        entities.get(x).set(y, new Player(this, x, y));

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (ArrayList<Entity> a : entities) {
			for (Entity e : a) {
				e.update();
				e.draw(g);
			}
		}
	}

    private boolean isOccupied(int x, int y) {
        return (isFence(x, y) || isPlayer(x, y));
    }
    private boolean isFence(int x, int y) {
        return (entities.get(x).get(y) instanceof Fence);
    }

    private boolean isPlayer(int x, int y) {
        return (entities.get(x).get(y) instanceof Player);
    }

}
