package hivolts;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * @author Neelay Junnarkar
 *         The Entity base class from which all other types of entities derive from
 */
public class Entity extends JComponent {

    /**
     * The enitity's self-tracked coordinates
     */
    protected int entityx, entityy;

    /**
     * Sets the entity's x-coord
     * @param i the new x-coord
     */
    public void setEntityX(int i) {
        entityx = i;
    }

    /**
     * Sets the entity's y-coord
     * @param i the new y-coord
     */
    public void setEntityY(int i) {
        entityy = i;
    }

    /**
     * @return Returns the entity's x-coord
     */
    public int getEntityX() {
        return entityx;
    }

    /**
     * @return Returns the entity's y-coord
     */
    public int getEntityY() {
        return entityy;
    }

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
