package hivolts;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * @author Neelay Junnarkar
 *         The Entity base class from which all other types of entities derive from
 */
public class Entity extends JComponent {

    protected int entityx, entityy;

    public void setEntityX(int i) {
        entityx = i;
    }

    public void setEntityY(int i) {
        entityy = i;
    }

    public int getEntityX() {
        return entityx;
    }

    public int getEntityY() {
        return entityy;
    }

    private boolean updated = false;
    public boolean getUpdated() { return updated; }
    public void setUpdated(boolean bool) { updated = bool; }
    
    /**
     * The constructor for Entity
     */
    public Entity(int x, int y) {
        entityx = x;
        entityy = y;
    }

    /**
     * The update method for entity
     *
     * @param x x-coord on board
     * @param y y-coord on board
     */
    public void update(int x, int y) {

    }

    /**
     * The draw method for entity
     *
     * @param g Graphcis g
     * @param x x-coord on board
     * @param y y-coord on board
     */
    public void draw(Graphics g, int x, int y) {

    }

}
