package us_flag;

import java.awt.*;

public class Star extends Polygon {
	
	public Star(double x, double y, double r, double pent_r, int nPoints) {
		this(x, y, r, pent_r, nPoints, 0.0);
	}

	public Star(double x, double y, double r, double pent_r, int nPoints, double initAng) {		 
		/*Calculating coordinates of points and putting in separate arrays for X and Y */
		int xpts[] = new int[nPoints*2];
		int ypts[] = new int[nPoints*2];
		double plusAng = (2*Math.PI)/nPoints; //radians for 360degrees/nPoints 
		double currAng = initAng, pentAng = initAng + (Math.PI/nPoints);
		for (int i = 0; i < nPoints; i++) {
			xpts[i*2] = (int) Math.round((r * Math.cos(currAng))+ x);
			ypts[i*2] = (int) Math.round((r * Math.sin(currAng)) + y);
			currAng += plusAng;
			xpts[(i*2)+1] = (int) Math.round((pent_r * Math.cos(pentAng)) + x);
			ypts[(i*2)+1] = (int) Math.round((pent_r * Math.sin(pentAng)) + y);
			pentAng += plusAng;
		}
		
		for (int i = 0; i < nPoints * 2; i++) {
			addPoint(xpts[i], ypts[i]);
		}
	}
}