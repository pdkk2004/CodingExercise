package MiscQuestions;

import java.util.concurrent.Semaphore;

/**
 * http://www.fgdsb.com/2015/01/03/sequential-outputting/
 * @author dipa
 *
 */
public class SequentialOutputting {

	private Semaphore odd = new Semaphore(1);

	private  Semaphore even = new Semaphore(0);

	public void sequentialOutput() throws InterruptedException {
		Thread oddPrinter = new Thread(new OutputRunnable(odd, even, false));
		Thread evenPrinter = new Thread(new OutputRunnable(odd, even, true));
		oddPrinter.start();
		evenPrinter.start();
		Thread.sleep(100);
		oddPrinter.interrupt();
		evenPrinter.interrupt();
		oddPrinter.join();
		evenPrinter.join();
		System.out.println("Completed printing.");
	}

	private static class OutputRunnable implements Runnable {

		private int count;
		private boolean isEven;
		private Semaphore odd;
		private Semaphore even;

		public OutputRunnable(Semaphore oddLock, Semaphore evenLock, boolean isEven) {
			this.count = isEven ? 2 : 1;
			this.isEven = isEven;
			this.odd = oddLock;
			this.even = evenLock;
		}

		public void run() {
			
			while (!Thread.interrupted()) {
				try {
					if (isEven) {
						even.acquire(1);
					} else {
						odd.acquire(1);
					}
				} catch (InterruptedException e) {
					return;
				}
				
				System.out.println(count);
				this.count += 2;
				if (isEven) {
					odd.release(1);
				} else {
					even.release(1);
				}
			}
		}
	}
}
