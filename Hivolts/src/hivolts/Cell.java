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


    public Cell(int x, int y) {
    	this(x, y, new Entity());
    }
    public Cell(int x, int y, Entity entity) {
        this.x = x;
        this.y = y;
        this.entity = entity;
    }

    public void update() {
        entity.update(x, y);
    }

    public void draw(Graphics g) {
        entity.draw(g, x, y);
    }
}
