import java.util.*;

public class BinaryHeap {

	long[] h;

	public BinaryHeap(int n) {
		this.h = new long[n];
	}

	public long removeMin() {
		return 0;
	}

	public void add(long value) {
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 1000; step++) {
			int n = rnd.nextInt(100) + 1;
			PriorityQueue<Long> q = new PriorityQueue<>();
			BinaryHeap h = new BinaryHeap(n);
			for (int op = 0; op < 1000; op++) {
				if (rnd.nextBoolean() && q.size() < n) {
					long v = rnd.nextLong();
					q.add(v);
					h.add(v);
				} else if (!q.isEmpty()) {
					if (q.remove() != h.removeMin())
						throw new RuntimeException();
				}
			}
		}
	}
}
