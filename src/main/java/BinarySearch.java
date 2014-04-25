import java.util.*;
import java.util.function.IntPredicate;

public class BinarySearch {

	public static int binarySearchFirstTrue1(IntPredicate predicate, int fromInclusive, int toInclusive) {

		return 0;
	}

	public static int binarySearchFirstTrue2(IntPredicate predicate, int fromInclusive, int toInclusive) {

		return 0;
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 100_000; step++) {
			int n = rnd.nextInt(20);
			boolean[] b = new boolean[n];
			int firstTrue = rnd.nextInt(n + 1);
			Arrays.fill(b, firstTrue, n, true);
			int res1 = binarySearchFirstTrue1(i -> b[i], 0, n - 1);
			int res2 = binarySearchFirstTrue2(i -> b[i], 0, n - 1);
			if (res1 != firstTrue || res2 != firstTrue)
				throw new RuntimeException();
		}
	}
}