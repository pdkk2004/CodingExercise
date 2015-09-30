//package MiscQuestions;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Stack;
//
//public class NestedArrayIterator {
//	
//	public static void main(String[] args) {
//		
//	}
//	
//	private static class ArrayElement<V> {
//		
//		private boolean isValue;
//		
//		private ArrayList<ArrayElement<V>> elements;
//		
//		private V value;
//		
//		public ArrayElement(V value) {
//			this.value = value;
//			this.isValue = true;
//		}
//		
//		public ArrayElement(Collection<ArrayElement<V>> elements) {
//			this.elements = new ArrayList<ArrayElement<V>>(elements);
//		}
//		
//		public boolean isValue() {
//			return isValue;
//		}
//
//		public V getValue() {
//			if (isValue) {
//				return value;
//			} else {
//				throw new RuntimeException("Invalid operation. This Element is a collection.");
//			}
//		}
//		
//		public List<ArrayElement<V>> getValues() {
//			if (!isValue) {
//				return elements;
//			} else {
//				throw new RuntimeException("Invalid operation. This Element is a single value.");
//			}
//		}
//	}
//	
//	private static class Array<V> {
//		
//		private ArrayList<ArrayElement<V>> elements;
//		
//		public Array() {
//			this.elements = new ArrayList<ArrayElement<V>>();
//		}
//		
//		public int size() {
//			return elements.size();
//		}
//		
//		public Iterator<V> iterator() {
//			return new ArrayIterator();
//		}
//		
//		private class ArrayIterator<V> implements Iterator<V>{
//			
//			private Stack<ArrayElement<V>> stack;
//			private Stack<Integer> iStack;
//			
//			public ArrayIterator() {
//				
//				stack = new Stack<ArrayElement<V>>();
//				iStack = new Stack<Integer>();
//				ArrayElement<V> current = null;
//				int i;
//				
//				if (size() > 0) {
//					current = elements.get(0);
//					i = 0;
//				}
//			}
//			 
//			public boolean hasNext() {
//				if (!stack.isEmpty()) {
//					return true;
//				} else {
//					return false;
//				}
//			}
//			
//			public V next() {
//				
//			}
//			
//			public void remove() {
//			}
//		}
//	}
//}
