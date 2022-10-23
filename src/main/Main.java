package main;

import java.awt.EventQueue;

import graficarFunciones.GraficarFunciones;
import lineasEncadenadas.LineasEncadenadas;
import vista.PanelCustom;
import vista.Ventana;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

				//LineasEncadenadas pm = new LineasEncadenadas();
				GraficarFunciones pm = new GraficarFunciones();
				
				PanelCustom.getInstance().getApi().addProgram(pm);
				
				PanelCustom.getInstance().startAPI();
				
			}
		});
	}

}
