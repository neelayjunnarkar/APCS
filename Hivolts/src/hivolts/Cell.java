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
    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    public void swap(Cell cell) {
        Entity otherentity = cell.getEntity();
        cell.setEntity(entity);
        entity = otherentity;
    }

    private boolean updated = false;
    public boolean isUpdated() {
        return updated;
    }
    public void setUpdated(boolean updated) {
        this.updated = updated;
    }


    public Cell(Panel panel, int x, int y) {
    	this(panel, x, y, new Entity(x, y));
    }
    
    public Cell(Panel panel, int x, int y, Entity entity) {
    	this.panel = panel;
        this.x = x;
        this.y = y;
        this.entity = entity;
        System.out.println("cell x, y: "+x+" "+y);
    }

    public void update() {
        entity.update(x, y);
        panel.getCells().get(entity.getEntityX()).get(entity.getEntityY()).setEntity(entity);

    }

    public void draw(Graphics g) {
        entity.draw(g, x, y);
    }
}
