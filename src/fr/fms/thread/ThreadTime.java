package fr.fms.thread;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.fms.graphic.GraphicSpace;

public class ThreadTime {

	public static void main(String[] args) {

		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Thread thread = new Thread(new MonRunnable(5000, df)); //

		//System.out.println(df.format(new Date()));

		thread.start();
	}

	public static class MonRunnable implements Runnable {

		private long delai;
		private DateFormat df; //

		public MonRunnable(long delai, DateFormat df) { //
			this.delai = delai;
			this.df = df; //
		}

		@Override
		public void run() {
			while (true) {
				try {
					
					new GraphicSpace();
					Thread.sleep(delai);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
