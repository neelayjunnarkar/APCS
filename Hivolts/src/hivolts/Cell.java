package hivolts;

import javax.swing.*;
import java.awt.*;

/**
 * @author Neelay Junnarkar
 */
public class Cell extends JComponent {

    private int y;

    public int getY() {
        return y;
    }

    private int x;

    public int getX() {
        return x;
    }

    Panel panel;

    private Entity entity;

    public Entity getEntity() {
        return entity;
    }

    public Entity setEntity(Entity entity) {
        return (this.entity = entity);
    }

    public void swap(Cell cell) {
        Entity otherentity = cell.getEntity();
        cell.setEntity(entity);
        entity = otherentity;
    }

    public boolean isUpdated() {
        return entity.getUpdated();
    }

    public void setUpdated(boolean updated) {
        entity.setUpdated(updated);
    }


    public Cell(Panel panel, int x, int y) {
        this(panel, x, y, new Entity(x, y));
    }

    public Cell(Panel panel, int x, int y, Entity entity) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.entity = entity;
        System.out.println("cell x, y: " + x + " " + y);
    }

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

    public void draw(Graphics g) {
        entity.draw(g, x, y);
    }
}
