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

    public Player(int x, int y) {
        super(x, y);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void update() {
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        getActionMap().put("pressed", new KeyAction("pressed"));
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
        private String txt;
        public KeyAction(String str) {
            this.txt = str;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (txt) {
                default:
                    System.out.println("asdfasdf");
            }
        }
    }

}
