import java.util.*;

public class ArrayRotate {

	public static void rotate1(int[] a, int first, int middle, int last) {

	}

	public static void rotate2(int[] a, int first, int middle, int last) {

	}

	public static void rotate3(int[] a, int first, int middle, int last) {

	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 1000; step++) {
			int n = rnd.nextInt(2) + 1;
			int middle = rnd.nextInt(n);
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = rnd.nextInt(10);
			int[] b1 = a.clone();
			rotate1(b1, 0, middle, n);
			int[] b2 = a.clone();
			rotate2(b2, 0, middle, n);
			int[] b3 = a.clone();
			rotate3(b3, 0, middle, n);
			if (!Arrays.equals(b1, b2) || !Arrays.equals(b1, b3))
				throw new RuntimeException();
		}
	}
}
