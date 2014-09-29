package hivolts;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * @author Neelay Junnarkar
 * The Entity base class from which all other types of entities derive from
 */
public class Entity extends JComponent {

    /**
     * The x,y coordinate location of the Entity
     */
    protected int x, y;

    /**
     * Sets the x coordinate location
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate location
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the x coordinate
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y coordinate
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Gets updated
     * @return
     */
    public boolean isUpdated() {
        return updated;
    }

    /**
     * Sets updated
     * @param updated
     */
    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    /**
     * Whether the entity has been updated or not. Used by Panel
     */
    private boolean updated = false;


    /**
     * The constructor for Entity
     * @param x
     * @param y
     */
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The update method for entity
     */
    public void update(int x, int y) {

    }

    /**
     * The draw method for entity
     * @param g
     */
    public void draw(Graphics g, int x, int y) {

    }

}
