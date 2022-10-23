package testCuadrado;

import java.awt.Color;
import java.util.ArrayList;

import modelo.ColorCl;
import modelo.Drawable;
import util.Vector2;

public class Entity extends Drawable {
	private ArrayList<Vector2> vertices;
	private ArrayList<int[]> relaciones;
	private Vector2 pos, 
					vel = Vector2.CERO, 
					asc = Vector2.CERO;
	private ColorCl c;
	private double rot;
	public Entity(Vector2 pos, double rot, ColorCl c) {
		this.pos = pos;
		this.rot = rot;
		this.c = c;
	}
	
	
	@Override
	public ArrayList<Vector2> getVertices() {
		return this.vertices;
	}

	@Override
	public ArrayList<int[]> getRelaciones() {
		return this.relaciones;
	}

	@Override
	public ColorCl getColor() {
		return this.c;
	}

	@Override
	public Drawable getObst() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
