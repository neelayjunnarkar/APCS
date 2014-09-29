package hivolts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * @author Neelay Junnarkar
 * The Main class is the entry point of the program and uses a JFrame
 * The Main class is also where constants are written
 */
public class Main {

    public static final int
            width = 640, /**The width of the window*/
            height = 640, /**The height of the window*/
            board_dim_x = 12, /**The width of the board in cell units*/
            board_dim_y = 12,/**The height of the board in cell units*/
            cell_width = width / board_dim_x, /**The width of each individual cell of the board*/
            cell_height = height / board_dim_y, /**The height of each individual cell of the board*/
            cell_sep = 1; /**The number of pixels by which each cell is separated*/

    /**
     * The JFrame
     */
    JFrame frame = new JFrame("Neelay Junnarkar Hivolts 2 APCS ");

    /**
     * An instance of Panel, which extends JPanel
     */
    Panel panel = new Panel();

    /**
     * The constructor for the Main class. Loops repaint, and sets up window.
     */
    public Main() {
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (frame.isEnabled()) {
            panel.repaint();
        }
    }

    /**
     * Entry point for program. Creates new Main()
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }

}
