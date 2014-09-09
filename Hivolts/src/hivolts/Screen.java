package hivolts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Neelay Junnarkar, September 2014
 */

public abstract class Screen extends JPanel implements KeyListener{

	abstract public Screen update();

    abstract public void paintComponent(Graphics g);
}
