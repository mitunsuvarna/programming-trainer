import java.util.Random;

public class KmpMatcher {

	public static int[] prefixFunction(String s) {

		return null;
	}

	public static int kmpMatcher(String s, String pattern) {
		int[] p = prefixFunction(pattern);

		return 0;
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 10_000; step++) {
			String s = getRandomString(rnd, 100);
			String pattern = getRandomString(rnd, 5);
			int pos1 = kmpMatcher(s, pattern);
			int pos2 = s.indexOf(pattern);
			if (pos1 != pos2)
				throw new RuntimeException();
		}
	}

	static String getRandomString(Random rnd, int maxlen) {
		StringBuilder sb = new StringBuilder();
		int n = rnd.nextInt(maxlen);
		for (int i = 0; i < n; i++)
			sb.append((char) ('a' + rnd.nextInt(3)));
		return sb.toString();
	}
}
