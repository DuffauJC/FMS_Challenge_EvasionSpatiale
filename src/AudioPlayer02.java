
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.Line.Info;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AudioPlayer02 extends JFrame {

	AudioFormat audioFormat;
	AudioInputStream audioInputStream;
	SourceDataLine sourceDataLine;
	boolean stopPlayback = false;
	final JButton stopBtn = new JButton("Stop");
	final JButton playBtn = new JButton("Play");
	final JTextField textField = new JTextField("junk.au");

	public static void main(String args[]) {
		new AudioPlayer02();
	}

	public AudioPlayer02() {

		stopBtn.setEnabled(false);
		playBtn.setEnabled(true);

		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopBtn.setEnabled(true);
				playBtn.setEnabled(false);
				playAudio();
			}
		});

		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopPlayback = true;
			}
		});

		getContentPane().add(playBtn, "West");
		getContentPane().add(stopBtn, "East");
		getContentPane().add(textField, "North");

		setTitle("Copyright 2003, R.G.Baldwin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 70);
		setVisible(true);
	}

	private void playAudio() {
		try {
			URL url = new URL("https://www.wavsource.com/snds_2020-10-01_3728627494378403/sfx/air_raid.wav");
			audioInputStream = AudioSystem.getAudioInputStream(url);
			audioFormat = audioInputStream.getFormat();
			Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);

			System.out.println(audioFormat);
			new PlayThread().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class PlayThread extends Thread {
		byte tempBuffer[] = new byte[10000];

		public void run() {
			try {
				sourceDataLine.open(audioFormat);

				int bytesRead = 0;
				byte[] buffer = new byte[1024];
				sourceDataLine.start();
				while ((bytesRead = audioInputStream.read(buffer)) != -1) {
					sourceDataLine.write(buffer, 0, bytesRead);
				}
				sourceDataLine.drain();
				sourceDataLine.close();
				audioInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
