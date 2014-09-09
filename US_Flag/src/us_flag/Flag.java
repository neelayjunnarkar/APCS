package us_flag;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Flag extends JPanel {

	int nPoints = 5;
	double height, width, stripe_width, multiplier = 150;
	final double flag_height = 1.0, flag_length = 1.9;
	final double union_height = 0.5385, union_length = 0.76;
	final double E = 0.054, F = 0.054, G = 0.063, H = 0.063;
	final double star_diameter = 0.0616, star_r = 0.0308;
	final double stripe_proportion = 0.0769;

	/*Colors for the flag*/
	Color oldGloryBlue = new Color(0, 82, 165);
	Color oldGloryRed = new Color(224, 22, 43);

	/*Slider allows for resizing of flag while keeping flag to scale*/
	JSlider slider = new JSlider(10, 1000, 250); 
	
	public Flag() { 
		add(slider);
		slider.addChangeListener(new ChangeListener(){			
			@Override
			public void stateChanged(ChangeEvent e) {
				repaint();
				add(slider);
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //smooths out drawings, especially stars (stars are rendered better)
		Dimension dim = this.getSize();
		
		/*This makes sure the flag cannot be resized beyond bounds of window. Window can be resized to allow different ranges of flag sizes.*/
		double flag_length_max, flag_height_max;
		flag_length_max = ((dim.getWidth()-20)/flag_length); //The "-20" makes a border on the right side so the flag doesn't go all the way to the edge of the window
		flag_height_max = ((dim.getHeight()-20)/flag_height);
		
		slider.setMaximum((flag_length_max < flag_height_max) ? (int)Math.round(flag_length_max) : (int)Math.round(flag_height_max) );
		
		multiplier = slider.getValue();
		height = multiplier *  flag_height;
		width = multiplier * flag_length;
		
		/*Drawing Order: 
		 * 1. White Background
		 * 2. Red and White Stripes
		 * 3. Blue Rectangle
		 * 4. Stars - drawn as 2 interlaced rectangles with stars as points. Use nested for loops to determine (x, y) coordinate of star.
		 */
		
		/*Drawing White Background*/
		g2d.setColor(new Color(255, 255, 255));
		g2d.fillRect(10, 10, (int) Math.round(width), (int) Math.round(height));

		/*Drawing Red Stripes and White Stripes (spaces where the red stripes are not drawn become white stripes due to the white background*/
		g2d.setColor(oldGloryRed);
		for (double y = 10; y < 10 + height; y += (stripe_proportion * 2 * multiplier)) {
			g2d.fillRect(10, (int) y, (int) Math.round(width), (int) Math.round(stripe_proportion * multiplier));
		}

		/*Drawing Blue Rectangle*/
		g2d.setColor(oldGloryBlue);
		g2d.fillRect(10, 10, (int) Math.round(union_length * multiplier), (int) Math.round(union_height * multiplier));

		/*Drawing Larger Star Rectangle*/
		g2d.setColor(new Color(255, 255, 255));
		int cy = 1, cx = 1;
		for (double y = 10 + (F*multiplier/2.0) + (((union_height * multiplier) - (9 * F * multiplier)) / 2.0); cy < 6; y += 2 * (F * multiplier)) {
			cx = 1;
			for (double x = 10 + (H*multiplier/2.0) + (((union_length*multiplier)-(11*H*multiplier))/2.0); cx < 7; x += 2 * (H * multiplier)) {
				g2d.fillPolygon(new Star(x, y, (star_r*multiplier), (star_r*multiplier/3.0), 5, 60));
				cx++;
			}
			cy++;
		}

		/*Drawing Smaller Star Rectangle*/
		cy = 1;
		cx = 1;
		for (double y = 10 + (F*multiplier/2.0) + (((union_height * multiplier) - (7 * F * multiplier)) / 2.0); cy < 5; y += 2 * (F *  multiplier)) {
			cx = 1;
			for (double x = 10 + (H*multiplier/2.0) + (((union_length * multiplier) - (9 * H * multiplier)) / 2.0); cx < 6; x += 2 * (H * multiplier)) {
				g2d.fillPolygon(new Star(x, y, (star_r*multiplier), (star_r*multiplier/3.0), 5, 60));
				cx++;
			}
			cy++;
		}

	}
}