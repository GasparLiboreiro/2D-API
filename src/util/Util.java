package util;

import java.awt.Color;
import java.util.ArrayList;


public class Util {
	public static double incVector(Vector2 v) {
		double inclinacion=0;
		if(v.x!=0) {
			inclinacion = Math.atan(v.y / v.x);
			
			if(v.x<0)
				inclinacion+=Math.PI;
		}
		else if(v.y>0)
			inclinacion = 0.5 * Math.PI;
		else if(v.y<=0)
			inclinacion = 1.5 * Math.PI;
		
		return inclinacion;
	}
	
	public static Color colorWBrightnes(Color c, double b) {
		if(b>1 || b<0)
			throw new Error();
		return new Color((int)(c.getRed()*b), (int)(c.getGreen()*b), (int)(c.getBlue()*b));
	}
}
