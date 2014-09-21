package hivolts;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Entity extends JComponent {

    protected int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {

    }

    public void draw(Graphics g) {

    }

}
