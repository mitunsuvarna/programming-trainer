import java.util.*;

public class Lis {

	public static int[] lis(int[] a) {
		return new int[0];
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 10_000; step++) {
			int n = rnd.nextInt(10) + 1;
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = rnd.nextInt(10);
			int[] lis = lis(a);
			checkLis(a, lis);
		}
	}

	static void checkLis(int[] a, int[] lis) {
		int n = a.length;
		boolean found = false;
		m1:
		for (int mask = 0; mask < 1 << n; mask++) {
			int len = Integer.bitCount(mask);
			if (len < lis.length)
				continue;
			for (int i = 0, prev = Integer.MIN_VALUE; i < n; i++)
				if ((mask & (1 << i)) != 0) {
					if (prev >= a[i])
						continue m1;
					prev = a[i];
				}
			if (len > lis.length)
				throw new RuntimeException();
			boolean ok = true;
			for (int i = 0, j = 0; i < n; i++)
				if ((mask & (1 << i)) != 0)
					ok &= a[i] == lis[j++];
			found |= ok;
		}
		if (!found)
			throw new RuntimeException();
	}
}
