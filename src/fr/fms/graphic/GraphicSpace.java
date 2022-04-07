package fr.fms.graphic;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class GraphicSpace extends JFrame {
	
	private static final long serialVersionUID = 1L;

	  AudioFormat audioFormat;
	  AudioInputStream audioInputStream;
	  SourceDataLine sourceDataLine;
	  boolean stopPlayback = false;
	  final JButton stopBtn = new JButton("Stop");
	  final JButton playBtn = new JButton("Play");
	  final JTextField textField =
	                       new JTextField("sound3.au");


	public GraphicSpace() {
		super("Voici nos formes g�om�triques !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);
		setLocationRelativeTo(null);
		playAudio();
		setVisible(true);
		
	}

	private void playAudio() {
	    try{
	      File soundFile =
	                   new File(textField.getText());
	      audioInputStream = AudioSystem.
	                  getAudioInputStream(soundFile);
	      audioFormat = audioInputStream.getFormat();
	      System.out.println(audioFormat);

	      DataLine.Info dataLineInfo =
	                          new DataLine.Info(
	                            SourceDataLine.class,
	                                    audioFormat);

	      sourceDataLine =
	             (SourceDataLine)AudioSystem.getLine(
	                                   dataLineInfo);

	
	    }catch (Exception e) {
	      e.printStackTrace();
	      System.exit(0);
	    }//end catch
	  }//end playAudio


	@Override
	public void paint(Graphics g) { // le rep�re x,y commence en haut � gauche (0,0)
		super.paint(g);
		playAudio();


		g.fillOval(50, 50, 35, 35);	// x , y , largeur , hauteur (diam�tre)
//		g.drawOval(150, 50, 45, 70);
//		g.drawRect(50, 150, 50, 50);
//		g.fillRect(150, 150, 70, 50);		

//		Graphics2D g2d = (Graphics2D)g;
//		g2d.setPaint( new GradientPaint(0, 0, Color.GREEN, 50, 50, Color.RED, true));
//		g2d.fillRect(250, 50, 70, 50);		
//		
//		g2d.fillOval(250,150,55,55);		
	}

	public static void main(String[] args) {
		new GraphicSpace();
	}
}