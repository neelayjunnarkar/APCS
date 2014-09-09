package hivolts;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Neelay Junnarkar, September 2014
 */

public class MainScreen extends Screen{

    private enum KeyHit {
        NONE, ESCAPE, ENTER;
    }
    KeyHit keyHit = KeyHit.NONE;

    public MainScreen() {
        setFocusable(true);
        System.out.println("mainscreen constructor");
        addKeyListener(this);
    }

    @Override
    public Screen update() {
        switch (keyHit) {
            case ESCAPE:
                return null;
            case ENTER:
            	System.out.println("keyHit enter");
                return new GameScreen();
        }
        return this;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.magenta);
        g2d.fillRect(0, 0, 100, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

   @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keypressed");
    	switch (e.getKeyCode()) {
	        case KeyEvent.VK_ESCAPE:
	            System.out.println("escape clicked");
                keyHit = KeyHit.ESCAPE;
	            break;
            case KeyEvent.VK_ENTER:
                System.out.println("enter clicked");
                keyHit = KeyHit.ENTER;
                removeKeyListener(this);
                break;
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
