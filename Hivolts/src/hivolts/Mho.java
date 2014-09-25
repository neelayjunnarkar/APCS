package hivolts;

import java.awt.*;

/**
 * Created by Neelay on 9/18/2014.
 */

public class Mho extends LivingEntity implements Enemy {

    Color mhoColor = new Color(222, 97, 1);//144, 40, 13);
    Panel panel;
    
    public Mho(Panel panel, int x, int y) {
        super(x, y);
        this.panel = panel;
    }

    public void update() {
    	
    	if (panel.isFence(x, y)) {
    		dead = true;
    	}
    	if (dead) {
    		return;
    	}
    	
    	/*Checks if Mho is on same axis as Player and moves Mho horizontally or vertically towards Player*/
        if (panel.getPlayerX() == x) {
            if (panel.getPlayerY() > y && !panel.isMho(x, y+1)) {
                y++;
            } else if (panel.getPlayerY() < y && !panel.isMho(x, y+1)) {
                y--;
            }
        	if (panel.isFence(x, y)) {
        		dead = true;
        	}
            return;
        }
        if (panel.getPlayerY() == y) {
            if (panel.getPlayerX() > x && !panel.isMho(x+1, y)) {
                x++;
            } else if (panel.getPlayerX() < x && !panel.isMho(x-1, y)) {
                x--;
            }
        	if (panel.isFence(x, y)) {
        		dead = true;
        	}
            return;
        }
        
        /*Checks if Mho is diagonal to the Player and moves Mho diagonally towards Player*/
        if (Math.abs(x-panel.getPlayerX()) == Math.abs(y-panel.getPlayerY())) {
        	if (x-panel.getPlayerX() < 0) {
        		if (y-panel.getPlayerY() < 0 && !panel.isMho(x+1, y+1)) {
        			x++;
        			y++;
        		} else if (y-panel.getPlayerY() > 0 && !panel.isMho(x+1, y-1)) {
        			x++;
        			y--;
        		}
            	if (panel.isFence(x, y)) {
            		dead = true;
            	}
            	return;
        	}
        	if (x-panel.getPlayerX() > 0) {
        		if (y-panel.getPlayerY() < 0 && !panel.isMho(x-1, y+1)) {
        			x--;
        			y++;
        		} else if (y-panel.getPlayerY() > 0 && !panel.isMho(x-1, y-1)) {
        			x--;
        			y--;
        		}
            	if (panel.isFence(x, y)) {
            		dead = true;
            	}
            	return;
        	}

        }
        
      
        if (Math.abs(x-panel.getPlayerX()) >= Math.abs(y-panel.getPlayerY())) {
        	if (x-panel.getPlayerX() < 0 && !panel.isMho(x+1, y)) {
        		x++;
        	} else if (x-panel.getPlayerX() > 0 && !panel.isMho(x-1, y)) {
        		x--;
        	}
        	if (panel.isFence(x, y)) {
        		dead = true;
        	}
        	return;
        }
        if (Math.abs(y-panel.getPlayerY()) >= Math.abs(x-panel.getPlayerX())) {
        	if (y-panel.getPlayerY() < 0 && !panel.isMho(x, y+1)) {
        		y++;
        	} else if (y-panel.getPlayerY() > 0 && !panel.isMho(x, y-1)) {
        		y--;
        	}
        	if (panel.isFence(x, y)) {
        		dead = true;
        	}
        	return;
        }
        
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        if (!dead) {
	        Graphics2D g2d = (Graphics2D) g.create();
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setColor(mhoColor);
	        g2d.fillOval((x * Main.cell_width + Main.cell_sep * x), (y * Main.cell_height + Main.cell_sep * y), Main.cell_width, Main.cell_height);
        }
   }
}
