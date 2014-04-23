import java.util.*;

public class MergeSort {

	public static void mergeSort(int[] a, int low, int high) {
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
			mergeSort(b, 0, n);
			Arrays.sort(a);
			if (!Arrays.equals(a, b))
				throw new RuntimeException();
		}
	}
}
