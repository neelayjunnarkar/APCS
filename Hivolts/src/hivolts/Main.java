package hivolts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main{

	public static final int width = 640, height = 640,
            board_dim_x = 12, board_dim_y = 12,
            cell_width = width/board_dim_x, cell_height = height/board_dim_y,
            cell_sep = 1;
	
	JFrame frame = new JFrame("Neelay Junnarkar Hivolts 2 APCS ");
	Panel panel = new Panel();

	public Main() {
        frame.setResizable(false);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		while (frame.isActive()) {
			panel.repaint();
		}
	}

    public static void main(String[] args) {
		new Main();
	}

}
