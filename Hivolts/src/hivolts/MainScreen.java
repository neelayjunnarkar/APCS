package hivolts;

import java.awt.Desktop.Action;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class MainScreen extends Screen {
	
		
	public MainScreen() {

	}
	
	@Override
	public Screen update() {
		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "doNothing");
		getActionMap().put("doNothing", nothing);
		
		return this;
	}
	
	public void paintComponent(Graphics g) {
		//System.out.println("mainscreen");
	}
	
	AbstractAction nothing = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("nothing");
		}
	};
			
}
