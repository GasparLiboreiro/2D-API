package modelo;

import java.awt.Graphics;
import java.util.ArrayList;

public class APIMain {
	private ArrayList<Program> carga = new ArrayList<Program>();
	
	public APIMain() {
		
	}
	
	
	public void update(double deltaT) {
		for(int x=0; x<carga.size(); x++) {
			carga.get(x).update(deltaT);
		}
	}
	
	public ArrayList<Program> getCarga(){
		return this.carga;
	}
	
	public void addProgram(Program p) {
		carga.add(p);
	}
}

/* update vanilla
 * for(int x=0; x<escena.size(); x++) {
			escena.get(x).getPos().x+=escena.get(x).getVel().x * DTime;
			escena.get(x).getPos().y+=escena.get(x).getVel().y * DTime;

			escena.get(x).getVel().x+=escena.get(x).getAsc().x * DTime;
			escena.get(x).getVel().y+=escena.get(x).getAsc().y * DTime;
			
			escena.get(x).rot +=escena.get(x).vrot * DTime;
			escena.get(x).vrot+=escena.get(x).arot * DTime;
		}
 */
