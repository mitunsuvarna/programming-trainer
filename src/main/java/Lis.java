import java.util.*;

public class Lis {

	public static int[] lis(int[] a) {
		return new int[0];
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 10_000; step++) {
			int n = rnd.nextInt(10) + 1;
			int[] s = new int[n];
			for (int i = 0; i < n; i++)
				s[i] = rnd.nextInt(10);
			int res1 = lis(s).length;
			int res2 = lisSlow(s);
			if (res1 != res2)
				throw new RuntimeException();
		}
	}

	static int lisSlow(int[] s) {
		int n = s.length;
		int res = 0;
		m1:
		for (int mask = 0; mask < 1 << n; mask++) {
			for (int i = 0, prev = -1; i < n; i++)
				if ((mask & (1 << i)) != 0) {
					if (prev >= s[i])
						continue m1;
					prev = s[i];
				}
			res = Math.max(res, Integer.bitCount(mask));
		}
		return res;
	}
}
