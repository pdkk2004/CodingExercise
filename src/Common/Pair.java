package Common;

public class Pair<K, V> {
	public K k;
	public V v;
	
	public Pair(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	@Override
	public boolean equals(Object toCompare) {
		if (toCompare instanceof Pair<?,?>) {
			Pair<?, ?> p = (Pair<?, ?>)toCompare;
			return p.k == k && p.v == v;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return k.hashCode() * 17 + v.hashCode();
	}
	
	@Override
	public String toString() {
		return "[" + k + "," + v + "]";
	}
	
}
