package hivolts;

import javax.swing.*;
import java.awt.*;

/**
 * @author Neelay Junnarkar
 * The Cell class hosts all entities
 */
public class Cell extends JComponent {

    /**
     * y-coord of cell
     */
    private int y;

    /**
     * @return Returns y-coord of cell
     */
    public int getY() {
        return y;
    }

    /**
     * x-coord of cell
     */
    private int x;

    /**
     * @return Returns x-coord of cell
     */
    public int getX() {
        return x;
    }

    /**
     * An instance of panel
     */
    Panel panel;

    /**
     * The entity which the Cell hosts
     */
    private Entity entity;

    /**
     * @return Returns the Cell's entity
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * @param entity The new entity to which the Cell's Entity is to be set to
     * @return
     */
    public Entity setEntity(Entity entity) {
        return (this.entity = entity);
    }

    /**
     * A constructor for cell which defaults the Cell's entity to Entity
     * @param panel instance of panel
     * @param x x-coord of cell
     * @param y y-coord of cell
     */
    public Cell(Panel panel, int x, int y) {
        this(panel, x, y, new Entity(x, y));
    }

    /**
     * A constructor for Cell
     * @param panel instance of panel
     * @param x x-coord of cell
     * @param y y-coord of cell
     * @param entity The entity of the Cell
     */
    public Cell(Panel panel, int x, int y, Entity entity) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.entity = entity;
        System.out.println("cell x, y: " + x + " " + y);
    }

    /**
     * The Cells update method which updates the entities
     */
    public void update() {
        entity.update(x, y);
        /*To Enable Snake: remove if statement and 'entity = new Entity(x, y);' (and follow all other To Enable Snake statements)*/
        if (entity.getEntityX() != x || entity.getEntityY() != y) {
            if (panel.getCells().get(entity.getEntityX()).get(entity.getEntityY()).getEntity() instanceof Fence) {
                entity = new Entity(x, y);
                return;
            }
            panel.getCells().get(entity.getEntityX()).get(entity.getEntityY()).setEntity(entity);
            System.out.println(entity.getEntityX() + " " + entity.getEntityY());
            entity = new Entity(x, y);
        }
    }

    /**
     * Draws the entity
     * @param g Graphics
     */
    public void draw(Graphics g) {
        entity.draw(g, x, y);
    }
}
