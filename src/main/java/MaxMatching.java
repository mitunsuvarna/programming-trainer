import java.util.*;

public class MaxMatching {

	public static int maxMatching(List<Integer>[] graph, int n2) {

		return 0;
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 1000; step++) {
			int n1 = rnd.nextInt(20) + 1;
			int n2 = rnd.nextInt(20) + 1;
			List<Integer>[] g = new List[n1];
			for (int i = 0; i < n1; i++)
				g[i] = new ArrayList<>();
			for (int i = 0; i < n1; i++)
				for (int j = 0; j < n2; j++)
					g[i].add(j);
			int res1 = maxMatching(g, n2);
			int res2 = slowMinVertexCover(g, n2);
			if (res1 != res2)
				throw new RuntimeException();
		}
	}

	static int slowMinVertexCover(List<Integer>[] g, int n2) {
		int n1 = g.length;
		int[] mask = new int[n1];
		for (int i = 0; i < n1; i++)
			for (int j : g[i])
				mask[i] |= 1 << j;
		int res = n2;
		for (int m = 0; m < 1 << n2; m++) {
			int cur = Integer.bitCount(m);
			for (int i = 0; i < n1; i++)
				if ((mask[i] & m) != mask[i])
					++cur;
			res = Math.min(res, cur);
		}
		return res;
	}
}
