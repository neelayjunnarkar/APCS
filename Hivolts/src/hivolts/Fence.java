package hivolts;

import java.awt.*;
import java.util.Random;

public class Fence extends Entity {

    Color fenceColor = new Color(201, 14, 0);//165, 28, 15);

    public Fence(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(fenceColor);
        g2d.fillRect(x * Main.cell_width + Main.cell_sep * x, y * Main.cell_height + Main.cell_sep * y, Main.cell_width, Main.cell_height);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        paintComponent(g);
    }


}
