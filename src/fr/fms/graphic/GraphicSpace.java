package fr.fms.graphic;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;


public class GraphicSpace extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public GraphicSpace() {
		super("Voici nos formes g�om�triques !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) { // le rep�re x,y commence en haut � gauche (0,0)
		super.paint(g);

		g.fillOval(50, 50, 35, 35);	// x , y , largeur , hauteur (diam�tre)
		//g.dispose();
	}

	public static void main(String[] args) {
		new GraphicSpace();
	}
}