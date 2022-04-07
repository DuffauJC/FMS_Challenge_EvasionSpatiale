package fr.fms.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.fms.graphic.GraphicSpace;

public class ThreadTime {
	
	

	public static void main(String[] args) {
		long time = (int) ((Math.random()*100000) + 1);
		Thread thread = new Thread(new MonRunnable(1000)); //

		thread.start();
		
		try {
			thread.join(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
					new GraphicSpace(); //
					Thread.sleep(delai);
					//GraphicSpace graphicSpace = new GraphicSpace();
					//Thread.interrupt();
					//graphicSpace.dispose();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
