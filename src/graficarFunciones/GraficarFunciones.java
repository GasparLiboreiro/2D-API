package graficarFunciones;

import java.util.ArrayList;

import modelo.ColorCl;
import modelo.Drawable;
import modelo.Program;
import util.Vector2;

public class GraficarFunciones extends Program {
	private ArrayList<Linea> escena;
	
	public GraficarFunciones() {
		escena = new ArrayList<Linea>();
		escena.add(new Linea() {
			@Override
			public double funcion(double X) {
				return Math.pow(2, X);
			}
		});
		
		escena.add(new Linea(new ColorCl(200,200,200)) {
			@Override
			public double funcion(double X) {
				return -Math.pow(2, -X);
			}
		});
		
		escena.add(new Linea(new ColorCl(200,20,20)) {
			@Override
			public double funcion(double X) {
				return Math.sin(X);
			}
		});
	}
	
	@Override
	public void update(double DTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Drawable> getEscena() {
		ArrayList<Drawable> array = new ArrayList<Drawable>();
		for(int x=0; x<escena.size(); x++)
			array.add(escena.get(x));
		return array;
	}
}
