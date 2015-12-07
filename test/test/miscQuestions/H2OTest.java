package test.miscQuestions;

import org.junit.Test;

import MiscQuestions.H2O;

public class H2OTest {
	
	private static enum Selection {
		H,
		O
	}
	
	@Test
	public <T> void testH2O() {
		H2O h2o = new H2O();
		Selection[] input = {Selection.O, Selection.H, Selection.H, Selection.H, Selection.H, Selection.H, Selection.O, Selection.H, Selection.H};
		for (Selection s : input) {
			Runnable r = null;
			switch(s) {
			case O:
				r = () -> {try {
					h2o.O();
				} catch (Exception e) {
					e.printStackTrace();
				}};
				break;
			case H:
				r = () -> {try {
					h2o.H();
				} catch (Exception e) {
					e.printStackTrace();
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
				System.out.println(e.getMessage());
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();
		
		Runnable r1 = () -> {
			try {
				h2o.H();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		
		Runnable r3 = () -> {
			try {
				h2o.H();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		
		Thread t3 = new Thread(r3);
		t3.start();
	}
	
	@Test
	public void testH2OTwoO() {
		H2O h2o = new H2O();

		Runnable r1 = () -> {
			try {
				h2o.O();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		
		Runnable r2 = () -> {
			try {
				h2o.O();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();
	}
}
