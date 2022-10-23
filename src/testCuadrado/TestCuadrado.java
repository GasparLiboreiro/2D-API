package testCuadrado;

import java.util.ArrayList;

import modelo.Drawable;
import modelo.Program;

public class TestCuadrado extends Program{
	private ArrayList<Entity> escena;
	
	public TestCuadrado() {
		
	}
	
	
	@Override
	public ArrayList<Drawable> getEscena() {
		ArrayList<Drawable> e = new ArrayList<Drawable>();
		for(int x=0; x<escena.size(); x++)
			e.add(escena.get(x));
		return e;
	}

	@Override
	public void update(double DTime) {
		// TODO Auto-generated method stub
		
	}
	
}
