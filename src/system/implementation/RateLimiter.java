package system.implementation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {
	
	private static final class Bucket {

		private double tokens;
		
		private double limit;
		
		private ReentrantLock lock;
		
		private Condition notEmpty;
		
		private Condition notFull;
		
		public Bucket(int tokens) {
			this.tokens = tokens;
			this.limit = tokens;
			this.lock = new ReentrantLock();
			this.notEmpty = lock.newCondition();
			this.notFull = lock.newCondition();
		}
		
		public double getAvailableNum() {
			try {
				lock.lock();
				return tokens;
			} finally {
				lock.unlock();
			}
		}
		
		public void addToken(double num) throws InterruptedException {
			lock.lock();
			try {
				double t = this.tokens + num;
				this.tokens = t > limit ? limit : t;
			} finally {
				lock.unlock();
			}
		}
		
		public double consume(int num) throws InterruptedException {
			lock.lock();
			try {
				while (tokens < num) {
					notEmpty.await();
				}
				this.tokens -= num;
				notFull.signalAll();
				return this.tokens;
			} finally {
				lock.unlock();
			}
		}
	}

	private int interval;
	
	private int limit;
	
	private Bucket bucket;
	
	private Thread refillThread;
	
	private volatile boolean started;
	
	public RateLimiter(int limit, int interval) {
		this.limit = limit;
		this.bucket = new Bucket(limit);
		this.interval = interval;
		this.refillThread = new Thread(new RefillRunnable(this.bucket, limit, interval));
	}
	
	public void acquire(int tokens) throws InterruptedException {
		if (tokens <= 0) {
			throw new IllegalArgumentException();
		}
		bucket.consume(tokens);
	}
	
	public void acquire() throws InterruptedException {
		if (!started) {
			started = true;
			this.refillThread.start();
		}
		this.acquire(1);
	}
	
	private class RefillRunnable implements Runnable {
		
		private Bucket bucket;
		
		private int refillInterval;
		
		private double rate;
		
		private RefillRunnable(Bucket bucket, double limit, int interval) {
			if (limit <= 0 || interval <= 0) {
				throw new IllegalArgumentException();
			}
			this.bucket = bucket;
			this.refillInterval = interval;
			this.rate = limit / interval;
		}
		
		public void run() {
			while (started) {
				try {
					bucket.addToken(rate);
					Thread.sleep(refillInterval);
				} catch (InterruptedException e) {
					started = false;
					return;
				}
			}
		}
	}
}
