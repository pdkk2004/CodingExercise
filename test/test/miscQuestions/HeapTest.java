package test.miscQuestions;

import org.junit.Assert;
import org.junit.Test;

import Common.Heap;

public class HeapTest {
	
	@Test
	public void testHeapAdd() {
		Heap<Integer> heap = new Heap<Integer>();
		heap.add(6);
		heap.add(10);
		heap.add(3);
		heap.add(7);
		heap.add(5);
		heap.add(6);
		heap.add(2);;
		heap.add(15);
		heap.add(8);;
		heap.add(13);
		
		while (!heap.isEmpty()) {
			System.out.println(heap.peek());
			heap.poll();
		}
	}
	
	@Test
	public void testPeekPollRemove() {
		Heap<Integer> heap = new Heap<Integer>();
		Assert.assertNull(heap.peek());
		
		heap.add(6);
		heap.add(10);
		heap.add(3);
		Assert.assertEquals((Integer)10, heap.peek());
		
		Assert.assertTrue(heap.remove(10));
		Assert.assertEquals((Integer)6, heap.poll());
		
		Assert.assertEquals(1, heap.size());
	}
	
	@Test
	public void testHeapRemove() {
		Heap<Integer> heap = new Heap<Integer>();
		heap.add(6);
		heap.add(10);
		heap.add(3);
		heap.add(7);
		heap.add(5);
		heap.add(6);
		heap.add(2);;
		heap.add(15);
		heap.add(8);;
		heap.add(13);
		
		Assert.assertFalse(heap.remove(0));
		Assert.assertTrue(heap.remove(10));
		String str = heap.toString();
		System.out.println(str);
		Assert.assertFalse(str.contains(Integer.toString(10)));
		Assert.assertEquals(9, heap.size());
		
		Integer pre = null;
		while (!heap.isEmpty()) {
			Integer v = heap.poll();
			Assert.assertTrue(pre == null || pre > v);
			System.out.println(v);
		}
	}
}
