package us_flag;

import java.awt.*;

public class Star extends Polygon {
	
	public Star(double x, double y, double r, double inner_r, int nPoints) {
		this(x, y, r, inner_r, nPoints, 0.0); //The initial rotation angle of the star is modifiable, and by default, is set to 0
	}

	public Star(double x, double y, double r, double inner_r, int nPoints, double initAng) {		 
		/*Calculating coordinates of points using trig and putting the x and y coordinates in separate arrays*/
		int xpts[] = new int[nPoints*2];
		int ypts[] = new int[nPoints*2];
		double plusAng = (2*Math.PI)/nPoints; //radians for 360degrees/nPoints. Determines the angle between points.  
		double currAng = initAng, pentAng = initAng + (Math.PI/nPoints);
		for (int i = 0; i < nPoints; i++) {
			xpts[i*2] = (int) Math.round((r * Math.cos(currAng))+ x); //The outer most points of the star (the points of the larger pentagon)
			ypts[i*2] = (int) Math.round((r * Math.sin(currAng)) + y);
			currAng += plusAng;
			xpts[(i*2)+1] = (int) Math.round((inner_r * Math.cos(pentAng)) + x); //The innner points of the star which cut into the outer pentagon and create the star shape
			ypts[(i*2)+1] = (int) Math.round((inner_r * Math.sin(pentAng)) + y);
			pentAng += plusAng; 
		}
		
		for (int i = 0; i < nPoints * 2; i++) {
			addPoint(xpts[i], ypts[i]); //this Star class simply gives the Polygon base class the vertices and allows the base class to handle everything else
		}
	}
}