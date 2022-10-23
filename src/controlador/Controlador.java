package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import conexion.GameJPanelParser;
import modelo.APIMain;
import util.Vector2;

public class Controlador implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{
	private APIMain api;
	private GameJPanelParser GJP;
	
	public Controlador(APIMain api, GameJPanelParser GJP) {
		this.GJP = GJP;
		this.api = api;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseExited(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).keyReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseMoved(e);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		for(int x=0; x<api.getCarga().size(); x++)
			api.getCarga().get(x).mouseWheelMoved(e);
	}

	
}
