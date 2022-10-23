package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Ventana extends JFrame{

	

	public Ventana() {
		this.setBounds(0, 0, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.addKeyListener(PanelCustom.getInstance());
		this.getContentPane().add(PanelCustom.getInstance(), BorderLayout.CENTER);
	}


}
