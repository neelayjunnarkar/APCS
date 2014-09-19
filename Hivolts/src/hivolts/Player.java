package hivolts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by Neelay on 9/17/2014.
 */

public class Player extends LivingEntity {

    Color playerColor = new Color(5, 98, 150);
    Panel panel;
    
    enum Key {
    	
    	Q(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "Q"),
    	W(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "W"),
        E(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "E"),
    	A(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "A"),
    	S(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "S"),
    	D(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "D"),
    	Z(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "Z"),
    	X(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "X"),
    	C(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C"),
    	J(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0), "J");
    	
    	private KeyStroke keyStroke;
    		public KeyStroke getKeyStroke() { return keyStroke; }
    	private String str;
    		public String getString() { return str; }
    		
    	Key(KeyStroke keyStroke, String str) {
    		this.keyStroke = keyStroke;
    		this.str = str;
    	}
    	
    }
    
    public Player(Panel panel, int x, int y) {
        super(x, y);
        this.panel = panel;
        
        for (Key key : Key.values()) {
        	panel.getInputMap().put(key.getKeyStroke(), key.getString());
        	panel.getActionMap().put(key.getString(), new KeyAction(key));
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(playerColor);
        g2d.fillOval((x*Main.cell_width + Main.cell_sep*x), (y*Main.cell_height + Main.cell_sep*y), Main.cell_width, Main.cell_height);
    }

    private class KeyAction extends AbstractAction {
    	
    	private Key key;
    	
        public KeyAction(Key key) {
        	this.key = key;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	switch (key) {
        	case Q:
        		System.out.println("Q");
        		y--;
        		x--;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case W:
        		y--;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case E:
        		System.out.println("E");
        		y--;
        		x++;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case A:
        		x--;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case S:
        		break;
        	case D:
        		x++;
                if (panel.isMurderer(x, y)) { dead = true; }
        		System.out.println("D");
        		break;
        	case Z:
        		y++;
        		x--;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case X:
        		y++;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case C:
        		y++;
        		x++;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	case J:
                System.out.println("J");
                Random rand = new Random();
                int newx, newy;
                do {
                    newx = rand.nextInt(10) + 1;
                    newy = rand.nextInt(10) + 1;
                } while (panel.isFence(newx, newy));
                x = newx;
                y = newy;
                if (panel.isMurderer(x, y)) { dead = true; }
        		break;
        	default:
        		System.out.println("weirdness just happened");
        		break;
        	}
        		
        }

    }

}
