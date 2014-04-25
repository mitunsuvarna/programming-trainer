import java.util.*;

public class NthElement {

	public static void nth_element(int[] a, int low, int high, int n) {

	}

	public static void main(String[] args) {
		Random rnd = new Random();
		for (int step = 0; step < 100_000; step++) {
			int n = rnd.nextInt(10) + 1;
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = rnd.nextInt(10);
			int k = rnd.nextInt(n);
			nth_element(a, 0, n, k);
			int[] s = a.clone();
			Arrays.sort(s);
			if (a[k] != s[k])
				throw new RuntimeException();
			for (int i = 0; i < n; i++)
				if (i < k && a[i] > a[k] || i > k && a[i] < a[k])
					throw new RuntimeException();
		}
	}
}
