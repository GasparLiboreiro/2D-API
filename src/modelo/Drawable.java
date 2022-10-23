package modelo;

import java.util.ArrayList;

import util.Vector2;

public abstract class Drawable {
	public abstract ArrayList<Vector2> getVertices();
	public abstract ArrayList<int[]> getRelaciones();
	public abstract ColorCl getColor();
	public Drawable getObst() {
		return this;
	}
}

