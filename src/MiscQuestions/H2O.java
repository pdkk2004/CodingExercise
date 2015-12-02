package MiscQuestions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

	private int quotaH = 2;
	private int quotaO = 1;
	private ReentrantLock lock;
	private Condition conditionH;
	private Condition conditionO;

	public H2O() {
		this.lock = new ReentrantLock();
		conditionH = lock.newCondition();
		conditionO = lock.newCondition();
	}

	public void O() throws InterruptedException {
		lock.lock();
		try {
			while (quotaO < 1) {
				conditionO.await();
			}
			System.out.print("O");
			if (--quotaO == 0 && quotaH == 0) {
				quotaH = 2;
				quotaO = 1;
				System.out.println(" water");
				conditionH.signalAll();
				conditionO.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

	public void H() throws InterruptedException {
		lock.lock();
		try {
			while (quotaH < 1) {
				conditionH.await();
			}
			System.out.print("H");
			if (--quotaH == 0 && quotaO == 0) {
				quotaH = 2;
				quotaO = 1;
				System.out.println(" water");
				conditionO.signalAll();
				conditionH.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

}
