package us_flag;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Flag extends JPanel {

	int nSides = 5;
	double height, width, stripe_width;
	double multiplier = 150;
	double flag_height = 1.0, flag_length = 1.9;
	double union_height = 0.5385, union_length = 0.76;
	double E = 0.054, F = 0.054, G = 0.063, H = 0.063;
	double star_diameter = 0.0616, star_r = 0.0308;
	double stripe_proportion = 0.0769;
	JSlider slider = new JSlider(200, 450, 300);
	int sliderx = 100, slidery= 550;
	Color oldGloryBlue = new Color(0, 82, 165);
	Color oldGloryRed = new Color(224, 22, 43);

	public Flag() { 
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(25);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setAutoscrolls(true);
		add(slider);

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				multiplier = source.getValue();
				repaint();
				slider.paint(getGraphics());
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(multiplier);
		height = multiplier *  flag_height;
		width = multiplier * flag_length;
		/*
		 * Draw order: 1.White Background 2.Red Stripes 3.Blue Rectangle 4.Stars
		 */

		g.setColor(new Color(255, 255, 255));
		g.fillRect(10, 10, (int) Math.round(width), (int) Math.round(height));

		g.setColor(oldGloryRed);
		for (double y = 10; y < 10 + height; y += (stripe_proportion * 2 * multiplier)) {
			g.fillRect(10, (int) y, (int) Math.round(width), (int) Math.round(stripe_proportion * multiplier));
		}

		g.setColor(oldGloryBlue);
		g.fillRect(10, 10, (int) Math.round(union_length * multiplier), (int) Math.round(union_height * multiplier));

		g.setColor(new Color(255, 255, 255));
		int cy = 1, cx = 1;
		for (double y = 10 + (F*multiplier/2.0) + (((union_height * multiplier) - (9 * F * multiplier)) / 2.0); cy < 6; y += 2 * (F * multiplier)) {
			cx = 1;
			for (double x = 10 + (H*multiplier/2.0) + (((union_length*multiplier)-(11*H*multiplier))/2.0); cx < 7; x += 2 * (H * multiplier)) {
				g.fillPolygon(new Star(x, y, (star_r*multiplier), (star_r*multiplier/3.0), 5, 60));
				cx++;
			}
			cy++;
		}

		cy = 1;
		cx = 1;
		for (double y = 10 + (F*multiplier/2.0) + (((union_height * multiplier) - (7 * F * multiplier)) / 2.0); cy < 5; y += 2 * (F *  multiplier)) {
			cx = 1;
			for (double x = 10 + (H*multiplier/2.0) + (((union_length * multiplier) - (9 * H * multiplier)) / 2.0); cx < 6; x += 2 * (H * multiplier)) {
				g.fillPolygon(new Star(x, y, (star_r*multiplier), (star_r*multiplier/3.0), 5, 60));
				cx++;
			}
			cy++;
		}
		slider.paint(getGraphics());
		g.dispose();
	}
}