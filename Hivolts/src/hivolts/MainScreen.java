package hivolts;

import java.awt.Desktop.Action;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class MainScreen extends Screen {
	
	JComponent component;
	
	public MainScreen() {

	}
	
	@Override
	public Screen update() {
		component.getInputMap().put(KeyStroke.getKeyStroke("F2"),  "doNothing");
		//component.getActionMap().put("doNothing", 
		return this;
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("mainscreen");
	}
	
	
	
}
