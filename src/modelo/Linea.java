package modelo;

import java.awt.Color;

import util.Vector2;

public class Linea {
	public Vector2 A; // ya se que full mayusk se usa para cosas estaticas
	public Vector2 B; // me parecia comodo :p
	public Linea(Vector2 p1, Vector2 p2) {
		this.A=p1;
		this.B=p2;
	}
	
	public Linea clone() {
		return new Linea(A.clone(), B.clone());
	}
}
