package hivolts;

import java.awt.*;

/**
 * Created by Neelay on 9/13/2014.
 */
public class MainScreen extends Screen {

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("MainScreen paint");
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor( new Color(5, 98, 165));
        g2d.fillRect(0, 0, 100, 100);
    }
}
