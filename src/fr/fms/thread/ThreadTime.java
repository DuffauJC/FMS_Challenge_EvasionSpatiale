package fr.fms.thread;

import fr.fms.graphic.GraphicSpace;

public class ThreadTime {

	public static void main(String[] args) {

		long time = (int) ((Math.random()*100000) + 1);
		Thread thread = new Thread(new MonRunnable(5000)); //

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
					GraphicSpace g = new GraphicSpace(); //				
					Thread.sleep(delai);
					g.setVisible(false);
					
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
