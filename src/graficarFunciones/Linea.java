package graficarFunciones;

import java.util.ArrayList;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

import modelo.ColorCl;
import modelo.Drawable;
import util.Vector2;

public abstract class Linea extends Drawable {
	public ArrayList<Vector2> vertices;
	public ArrayList<int[]> relaciones;
	public ColorCl c;
	
	public Linea() {
		vertices = new ArrayList<Vector2>();
		relaciones = new ArrayList<int[]>();
		c=new ColorCl(255,255,255);
		initVertices(1000, -50, 100);
	}
	public Linea(ColorCl c) {
		vertices = new ArrayList<Vector2>();
		relaciones = new ArrayList<int[]>();
		this.c=c;
		initVertices(1000, -50, 100);
	}
	
	private void initVertices(int nVertices, double X, double DX) {
		for(int x = 0; x <= nVertices; x++) {
			double xMedicion = X+(DX/nVertices)*x;
			if(funcion(xMedicion)<1000000)
				vertices.add(new Vector2(xMedicion, funcion(xMedicion)));
		}
		for(int x=0; x<vertices.size()-1; x++) {
			relaciones.add(new int[] {x, x+1});
		}
	}
	
	public abstract double funcion(double X);
	
	
	
	@Override
	public ArrayList<Vector2> getVertices() {
		return vertices;
	}

	@Override
	public ArrayList<int[]> getRelaciones() {
		return relaciones;
	}

	@Override
	public ColorCl getColor() {
		return c;
	}

	@Override
	public Drawable getObst() {
		return this;
	}

}
