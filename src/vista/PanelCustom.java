package vista;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import conexion.GameJPanelParser;
import modelo.GameLoop;
import modelo.APIMain;
import modelo.Linea;
import util.Vector2;
import controlador.Controlador;

public class PanelCustom extends JPanel implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{
	private static PanelCustom instance = null;
	private APIMain api;
	private GameJPanelParser GJP;
	private Controlador controlador;
	private static boolean locked = false;
	
	private GameLoop gameLoop;
	
	private PanelCustom() {
		api = new APIMain();
		GJP = new GameJPanelParser(api);
		gameLoop = new GameLoop(api, this);
		
		controlador = new Controlador(api, GJP);
		
		this.addMouseListener(this);
		this.addMouseWheelListener(this); //listener vista
		this.addMouseMotionListener(this);
		
		this.addMouseListener(controlador);
		this.addMouseWheelListener(controlador); //listener programs
		this.addMouseMotionListener(controlador);
		
		
	}
	
	public static PanelCustom getInstance() {
		if(instance==null)
			instance = new PanelCustom();
		return instance;
	}
	
	public void startAPI() {
		gameLoop.startLoop();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		GJP.paint(g, this.getWidth(), this.getHeight());
		g.setColor(Color.GRAY);
		g.drawString("FPS:"+gameLoop.getAverageFPS(), 5, 10);
		g.drawString("UPS:"+gameLoop.getAverageUPS(), 3, 20);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_P:
			if(locked)
				locked=false;
			else
				locked=true;
			break;
		}
		
		/*
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			juego.moverJugador(0.5,true);
			break;
		case KeyEvent.VK_A:
			juego.moverJugador(1,true);
			break;
		case KeyEvent.VK_S:
			juego.moverJugador(1.5,true);
			break;
		case KeyEvent.VK_D:
			juego.moverJugador(0,true);
			break;
		case KeyEvent.VK_Q:
			juego.getJugador().vrot=1;
			break;
		case KeyEvent.VK_E:
			juego.getJugador().vrot=-1;
			juego.getJugador().escenaFromThis(juego.getEscena());
			break;
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			juego.moverJugador(0.5,false);
			break;
		case KeyEvent.VK_A:
			juego.moverJugador(1,false);
			break;
		case KeyEvent.VK_S:
			juego.moverJugador(1.5,false);
			break;
		case KeyEvent.VK_D:
			juego.moverJugador(0,false);
			break;
		case KeyEvent.VK_Q:
			juego.getJugador().vrot=0;
			break;
		case KeyEvent.VK_E:
			juego.getJugador().vrot=0;
			//juego.getJugador().escenaFromThis(juego.getEscena());
			break;
		}*/
	}
	
	

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(!locked)
			if(e.getWheelRotation()<0) {
				GJP.ppu*=1.25;
			} else {
				if(GJP.ppu*0.75>1)
					GJP.ppu=(int)(GJP.ppu*0.75);
				else
					GJP.ppu=1;
			}
	}
	
	private MouseEvent antPos=null;
	@Override
	public void mouseDragged(MouseEvent e) {
		if(antPos!=null && !locked) {
			GJP.moverCam((e.getX()-antPos.getX())/GJP.ppu, -(e.getY()-antPos.getY())/GJP.ppu);
		}
		antPos=e;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		antPos=null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public APIMain getApi() {
		return api;
	}
	
	public GameJPanelParser getGJP() {
		return GJP;
	}
	
	public Controlador getControlador() {
		return this.controlador;
	}
}
