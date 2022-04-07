package fr.fms.thread;

import fr.fms.graphic.AudioPlayer02;
import fr.fms.graphic.GraphicSpace;

public class ThreadTime {

	public static void main(String[] args) {

		long time = (int) ((Math.random()*100000) + 1);
		Thread thread = new Thread(new MonRunnable(15000)); //

		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
					AudioPlayer02 audioplay=	new AudioPlayer02();
					GraphicSpace g = new GraphicSpace(); //	
					audioplay.playAudio();
					Thread.sleep(delai);
					g.setVisible(false);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
