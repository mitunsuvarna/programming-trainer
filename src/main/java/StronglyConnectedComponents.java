import java.util.*;
import java.util.stream.Collectors;

public class StronglyConnectedComponents {

	public static List<List<Integer>> scc(List<Integer>[] graph) {

		return new ArrayList<>();
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 10_000; step++) {
			int n = rnd.nextInt(30);
			List<Integer>[] g = getRandomGraph(n, rnd);

			Set<Set> s1 = sccSLow(g).stream().map(HashSet::new).collect(Collectors.toSet());
			Set<Set> s2 = scc(g).stream().map(HashSet::new).collect(Collectors.toSet());

			if (!s1.equals(s2))
				throw new RuntimeException();
		}
	}

	static List<Integer>[] getRandomGraph(int n, Random rnd) {
		List<Integer>[] res = new List[n];
		for (int i = 0; i < n; i++) {
			res[i] = new ArrayList<>();
			for (int j = 0; j < n; j++)
				if (rnd.nextBoolean())
					res[i].add(j);
		}
		return res;
	}


	static List<List<Integer>> sccSLow(List<Integer>[] graph) {
		boolean[][] d = transitiveClosure(graph);
		List<List<Integer>> res = new ArrayList<>();

		int n = graph.length;
		boolean[] used = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				List<Integer> component = new ArrayList<>();
				for (int j = 0; j < n; j++)
					if (i == j || d[i][j] && d[j][i]) {
						component.add(j);
						used[j] = true;
					}
				res.add(component);
			}
		}

		return res;
	}

	static boolean[][] transitiveClosure(List<Integer>[] graph) {
		int n = graph.length;
		boolean[][] res = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j : graph[i])
				res[i][j] = true;

		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					res[i][j] |= res[i][k] && res[k][j];

		return res;
	}

}
