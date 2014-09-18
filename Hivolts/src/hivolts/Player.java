package hivolts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.spi.AbstractInterruptibleChannel;

/**
 * Created by Neelay on 9/17/2014.
 */

public class Player extends Entity{

    Color playerColor = new Color(5, 98, 165);
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
            System.out.println("KeyAction constructor");
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	switch (key) {
        	case Q:
        		System.out.println("Q");
        		y--;
        		x--;
        		break;
        	case W:
        		y--;
        		break;
        	case E:
        		System.out.println("E");
        		y--;
        		x++;
        		break;
        	case A:
        		x--;
        		break;
        	case S:
        		break;
        	case D:
        		x++;
        		System.out.println("D");
        		break;
        	case Z:
        		y++;
        		x--;
        		break;
        	case X:
        		y++;
        		break;
        	case C:
        		y++;
        		x++;
        		break;
        	case J:
        		break;
        	default:
        		System.out.println("some other key");
        		break;
        	}
        		
        }

    }

}
