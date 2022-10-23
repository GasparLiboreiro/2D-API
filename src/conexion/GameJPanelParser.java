package conexion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.APIMain;
import modelo.Drawable;
import util.Vector2;

public class GameJPanelParser {
	private APIMain api;
	public double ppu = 20; //pixel per unit
	public Vector2 cam;     //pos cam en units
	public int width, height;
	
	public GameJPanelParser(APIMain api) {
		this.api = api;
		cam = new Vector2(0,0);
	}
	public GameJPanelParser() {
		this.api = new APIMain();
		cam = new Vector2(0,0);
	}
	
	public void paint(Graphics g, int width, int height) {
		this.width=width;
		this.height=height;
		g.setColor(new Color(30,30,30));
		for(int x=0; x<this.height; x++)
			g.drawLine(0,x,this.width,x);
		dibujarEjes(g);
		g.setColor(Color.WHITE);
		
		for(int x=0; x<api.getCarga().size(); x++) {
			for(int y=0; y<api.getCarga().get(x).getEscena().size(); y++) {
				this.dibujarObst(g, api.getCarga().get(x).getEscena().get(y).getObst());
			}
		}
		
	}
	
	public void dibujarObst(Graphics g, Drawable shape) {
		ArrayList<Vector2> vertices = shape.getVertices();
		ArrayList<int[]> relaciones = shape.getRelaciones();
		Color c = shape.getColor();
		for(int y=0; y<relaciones.size(); y++) {
			g.setColor(c);
			g.drawLine(
				(int)(( vertices.get(relaciones.get(y)[0]).x + cam.x)*ppu + width /2), 
				(int)((-vertices.get(relaciones.get(y)[0]).y - cam.y)*ppu + height/2),   //invierto las 'y' para que cooiincidan con como se visualizan los ejes cartecianos (normalemnte mientras mas alta es y mas abajo de la pantalla estas, deveria ser al revez)
				(int)(( vertices.get(relaciones.get(y)[1]).x + cam.x)*ppu + width /2), 
				(int)((-vertices.get(relaciones.get(y)[1]).y - cam.y)*ppu + height/2) 
			);
		}
	}
	
	
	public void dibujarEjes(Graphics g) {
		g.setColor(new Color(100,100,100));
		g.drawLine(0, (int)(height/2-cam.y*ppu), width, (int)(height/2-cam.y*ppu));//eje x
		g.drawLine((int)(width/2+cam.x*ppu), 0, (int)(width/2+cam.x*ppu), height); //eje y
		
		
		for(int x=(int) (width/2+cam.x*ppu); x>0; x-=ppu) {
			g.drawLine((int)(x), (int)(height/2-1-cam.y*ppu), (int)(x), (int)(height/2+1-cam.y*ppu));
		}
		for(int x=(int) (width/2+cam.x*ppu); x<width; x+=ppu) {
			g.drawLine((int)(x), (int)(height/2-1-cam.y*ppu), (int)(x), (int)(height/2+1-cam.y*ppu));
		}
		for(int x=(int) (height/2-cam.y*ppu); x>0; x-=ppu) {
			g.drawLine((int)(width/2-1+cam.x*ppu), (int)(x), (int)(width/2+1+cam.x*ppu), (int)(x));
		}
		for(int x=(int) (height/2-cam.y*ppu); x<height; x+=ppu) {
			g.drawLine((int)(width/2-1+cam.x*ppu), (int)(x), (int)(width/2+1+cam.x*ppu), (int)(x));
		}
	}
	
	
	public void moverCam(double x, double y) {
		cam.mover(x, y);
	}
	
	
	
	
	
	
	
	
	
	

	public Vector2 Vector2PixelsAUnits(Vector2 coords) {
		Vector2 v = new Vector2();
		v.x=(coords.x-width/2-cam.x*ppu)/ppu;
		v.y=(-(coords.y-height/2)-cam.y*ppu)/ppu;
		return v;
	}
	
	public Vector2 Vector2UnitsAPixels(Vector2 pos) {
		Vector2 v = new Vector2();
		v.x=pos.x*ppu+width/2+cam.x*ppu;
		v.y=-(pos.y*ppu+height/2)+cam.y*ppu;
		return v;
	}
	
	public double pixelsAUnits(double pixels) {
		return pixels/ppu;
	}

	public double unitsAPixels(double pixels) {
		return pixels*ppu;
	}
	
	
}