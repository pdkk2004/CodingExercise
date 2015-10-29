package MiscQuestions;

import java.sql.Time;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskScheduler {
	
	public static class Task implements Comparable<Task>{
		private Runnable task;
		private Time start;
		
		public Task(Runnable task, Time start) {
			this.task = task;
			this.start = start;
		}
		
		@Override
		public int compareTo(Task t) {
			return this.start.compareTo(t.start);
		}
	}
	
	private PriorityQueue<Task> queue;
	private ReentrantLock lock;
	private Condition notReady = lock.newCondition();
	private Thread executor;
	
	public TaskScheduler() {
		queue = new PriorityQueue<Task>();
		lock = new ReentrantLock(true);
		executor = new Thread(new Runnable() {
			public void run() {
				lock.lock();
				while (true) {
					while (queue.isEmpty()) {
						try {
							notReady.await();
						} catch (InterruptedException ie) {
							System.out.println(ie.getMessage());
						}
					}
					Task t = queue.peek();
					long startTime = t.start.getTime();
					if (startTime <= System.currentTimeMillis()) {
						Thread thread = new Thread(queue.poll().task);
						thread.run();
					} else {
						if (startTime - System.currentTimeMillis() > 0) {
							try {
								notReady.wait(startTime - System.currentTimeMillis());
							} catch (InterruptedException ie) {
								System.out.println(ie.getMessage());
							}
						}
					}
				}
			}
		});
	}
	
	public void addTask(Task t) {
		try {
			lock.lockInterruptibly();
			queue.add(t);
		} catch (InterruptedException ie) {
			System.out.println("Fail to add task." + ie.getMessage());
		} finally {
			lock.unlock();
			notReady.signalAll();
		}
	}
	
	public Task removeTask(Task t) throws InterruptedException{
		try {
			lock.lockInterruptibly();
			if (queue.contains(t)) {
				Task ret = queue.poll();
				return ret;
			} else {
				throw new NoSuchElementException();
			}
		} finally {
			lock.unlock();
			notReady.signalAll();
		}
	}
	
	public void invokeScheduler() {
		executor.start();
	}
}
