package test.miscQuestions;

import org.junit.Test;

import MiscQuestions.H2O;

public class H2OTest {
	
	private static enum Selection {
		H,
		O
	}
	
	@Test
	public void testH2O() {
		H2O h2o = new H2O();
		for (int i = 0; i < 30; i++) {
			Selection s = select();
			Runnable r = null;
			switch(s) {
			case O:
				r = () -> {try {
					h2o.O();
				} catch (Exception e) {
				}};
				break;
			case H:
				r = () -> {try {
					h2o.H();
				} catch (Exception e) {
				}};
				break;
			}
			Thread t = new Thread(r);
			t.start();
		}
	}
	
	@Test
	public void testH2OSimpleCase() {
		H2O h2o = new H2O();

		Runnable r2 = () -> {
			try {
				h2o.O();
			} catch (Exception e) {
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();
		
		Runnable r1 = () -> {
			try {
				h2o.H();
			} catch (Exception e) {
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();


		
		Runnable r3 = () -> {
			try {
				h2o.H();
			} catch (Exception e) {
			}
		};
		
		Thread t3 = new Thread(r3);
		t3.start();
	}
	
	private Selection select() {
		int num = (int)(Math.random() * 3);
		if (num == 0) {
			return Selection.O;
		} else {
			return Selection.H;
		}
	}
	
}
