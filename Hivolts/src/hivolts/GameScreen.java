package hivolts;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Neelay Junnarkar, September 2014
 */

public class GameScreen extends Screen {

    public GameScreen() {
        System.out.println("GameScreen constructor");
        addKeyListener(this);
    }

    @Override
    public Screen update() {
        return this;
    }

    @Override
    public void paintComponent(Graphics g) {
    	System.out.println("gamescreen paintcomponent");
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.green);
        g2d.fillRect(100, 0, 100, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
