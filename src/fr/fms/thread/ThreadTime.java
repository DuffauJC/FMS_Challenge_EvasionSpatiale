package fr.fms.thread;

import fr.fms.graphic.AudioPlayer02;
import fr.fms.graphic.GraphicSpace;

public class ThreadTime {

	public static void main(String[] args) {

		Thread thread = new Thread(new MonRunnable(5000)); //
		thread.start();
	}

	public static class MonRunnable implements Runnable {
		private long delai;

		public MonRunnable(long delai) { //
			this.delai = delai;
		}

		@Override
		public void run() {
			while (true) {
				try {
					
				//	GraphicSpace graphicSpace = new GraphicSpace();
				AudioPlayer02 audioPlayer02 =	new AudioPlayer02();
				//
				Thread.sleep(delai);
				audioPlayer02.playAudio();
					audioPlayer02.setVisible(false);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
