package lineasEncadenadas;

import java.awt.Color;
import java.util.ArrayList;

import modelo.ColorCl;
import modelo.Drawable;
import util.Vector2;

public class Linea extends Drawable{
	protected ArrayList<Vector2> vertices = new ArrayList<Vector2>();
	protected ArrayList<int[]> relaciones = new ArrayList<int[]>();
	protected ColorCl c;
	
	public Linea(Vector2 p1, Vector2 p2) {
		this.vertices.add(p1);
		this.vertices.add(p2);
		this.relaciones.add(new int[] {0,1});
		this.c = ColorCl.resrap(Color.WHITE);
	}
	public Linea(Vector2 p1, Vector2 p2, ColorCl c) {
		this.vertices.add(p1);
		this.vertices.add(p2);
		this.relaciones.add(new int[] {0,1});
		this.c = c;
	}
	
	
	public Linea clone() {
		return new Linea(vertices.get(0).clone(), vertices.get(1).clone());
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
	
	
	public double longitud() {
		return vertices.get(0).distancia(vertices.get(1));
	}
	@Override
	public Drawable getObst() {
		return this;
	}
	
}















/*



public class Linea extends Entity{
	
	public Linea(Vector2 p1, Vector2 p2) {
		super(0,0,0, new Vector2[] {p1,p2}, new int[][] {{0,1}}, new ColorCl(255,255,255));
	}
	public Linea(Vector2 p1, Vector2 p2, ColorCl c) {
		super(0,0,0, new Vector2[] {p1,p2}, new int[][] {{0,1}}, c);
	}
	
	public Linea clone() {
		return new Linea(vertices.get(0).clone(), vertices.get(1).clone());
	}
	
	
}



*/