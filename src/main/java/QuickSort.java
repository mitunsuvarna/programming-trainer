import java.util.*;

public class QuickSort {

	public static void quickSort(int[] a, int low, int high) {
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 10_000; step++) {
			int n = rnd.nextInt(100);
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = rnd.nextInt();
			}
			int[] b = a.clone();
			quickSort(b, 0, n - 1);
			Arrays.sort(a);
			if (!Arrays.equals(a, b))
				throw new RuntimeException();
		}
	}
}
