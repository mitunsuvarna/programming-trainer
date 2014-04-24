import java.util.*;

public class RadixSort {

	public static void radixSort(int[] a) {
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
			radixSort(b);
			Arrays.sort(a);
			if (!Arrays.equals(a, b))
				throw new RuntimeException();
		}
	}
}
