package fr.fms.graphic;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GraphicSpace extends JFrame {
	private static final long serialVersionUID = 1L;

	  JPanel contentPane;
	    JLabel imageLabel = new JLabel();
	    JLabel headerLabel = new JLabel();

	public GraphicSpace() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		 try {
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	            contentPane = (JPanel) getContentPane();
	           
	            setTitle("Your Job Crashed!");
	            // add the header label
	         
	            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
	            // add the image label
	            ImageIcon ii = new ImageIcon( "Yoda_cat.gif");
	                   
	            imageLabel.setIcon(ii);
	            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
	            // show it
	            this.setVisible(true);
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		new GraphicSpace();
	}
}