package lineasEncadenadas;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import conexion.GameJPanelParser;
import modelo.ColorCl;
import modelo.Drawable;
import modelo.Program;
import util.Util;
import util.Vector2;
import vista.PanelCustom;

public class LineasEncadenadas extends Program {

	private ArrayList<Linea> escena;
	private int lineaSelec = SIN_SELECCIONAR;
	
	public static final int SIN_SELECCIONAR = -1;
	
	public LineasEncadenadas() {
		escena = new ArrayList<Linea>();
		
		escena = setPuntosEnCiruclo(6, 1);
	}
	
	private ArrayList<Linea> setCadena(int c, double l) {
		ArrayList<Linea> escena = new ArrayList<Linea>();
		ArrayList<Vector2> nodos = new ArrayList<Vector2>();
		for(int x=0; x<c; x++) 
			nodos.add(new Vector2(0, x*l));
		for(int x=0; x<c; x++) 
			escena.add(new Linea(nodos.get(x), nodos.get(x+1)));
		return escena;
	}
	
	private ArrayList<Linea> setPuntosEnCiruclo(int c, double r) {
		ArrayList<Linea> escena = new ArrayList<Linea>();
		ArrayList<Vector2> nodos = new ArrayList<Vector2>();
		for(int x=0; x<c+1; x++) 
			nodos.add(new Vector2(0, r));
		for(int x=0; x<c; x++) 
			escena.add(new Linea(nodos.get(x), nodos.get(x+1)));
		return escena;
	}
	
	@Override
	public void update(double DTime) {
		
	}

	@Override
	public ArrayList<Drawable> getEscena() {
		ArrayList<Drawable> e = new ArrayList<Drawable>();
		for(int x=0; x<escena.size(); x++)
			e.add(escena.get(x));
		return e;
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		Vector2 mouse = PanelCustom.getInstance().getGJP().Vector2PixelsAUnits(new Vector2(e.getX(), e.getY()));
		

		double distanciaMinimaPixels = 10;
		double distancia;
		double mejorDistancia = 1;
		for(int x=0; x<this.escena.size(); x++) {
			distancia = mouse.distancia(escena.get(x).getVertices().get(0));
			if(distancia < PanelCustom.getInstance().getGJP().pixelsAUnits(distanciaMinimaPixels) && distancia <= mejorDistancia) {
				this.lineaSelec = x;
				mejorDistancia = distancia;
			}
		}
		distancia = mouse.distancia(escena.get(escena.size()-1).getVertices().get(1));
		if(distancia < PanelCustom.getInstance().getGJP().pixelsAUnits(distanciaMinimaPixels) && distancia <= mejorDistancia) {
			this.lineaSelec = escena.size();
			mejorDistancia = distancia;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.lineaSelec = SIN_SELECCIONAR;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(lineaSelec != SIN_SELECCIONAR) {
			double rotacion;
			Vector2 mouse = PanelCustom.getInstance().getGJP().Vector2PixelsAUnits(new Vector2(e.getX(), e.getY()));
			if(lineaSelec<escena.size()) {
				rotacion = Util.incVector(mouse) - Util.incVector(escena.get(this.lineaSelec).getVertices().get(0));
				for(int x = this.lineaSelec; x<escena.size(); x++) {
					Vector2 v = escena.get(x).getVertices().get(0);
					double X = Math.cos(Util.incVector(v) + rotacion) * v.distancia(Vector2.CERO);
					double Y = Math.sin(Util.incVector(v) + rotacion) * v.distancia(Vector2.CERO);
					v.x=X;
					v.y=Y;
				}
				Vector2 v = escena.get(escena.size()-1).getVertices().get(1);
				double X = Math.cos(Util.incVector(v) + rotacion) * v.distancia(Vector2.CERO);
				double Y = Math.sin(Util.incVector(v) + rotacion) * v.distancia(Vector2.CERO);
				v.x=X;
				v.y=Y;
			} else {
				rotacion = Util.incVector(mouse) - Util.incVector(escena.get(escena.size()-1).getVertices().get(1));
				Vector2 v = escena.get(escena.size()-1).getVertices().get(1);
				double X = Math.cos(Util.incVector(v) + rotacion) * v.distancia(Vector2.CERO);
				double Y = Math.sin(Util.incVector(v) + rotacion) * v.distancia(Vector2.CERO);
				v.x=X;
				v.y=Y;
			}
			
			
		}
	}


}
