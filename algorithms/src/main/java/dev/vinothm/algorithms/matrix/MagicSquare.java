package dev.vinothm.algorithms.matrix;

public class MagicSquare {

	public void loubereMethod(int n) {
		if (n % 2 == 0) {
			System.out.println("N needs to odd");
			return;
		}

		int[][] matrix = new int[n][n];
		int i = 2;
		int j = 0;
		for (int k = 1; k <= n * n; k++) {
			int ti = i;
			matrix[i][j] = k;
			j = (j + 1) % n;
			i = n - 1 - (n - i) % n;
			if (matrix[i][j] != 0) {
				i = ti % n;
			}
		}

		for (int[] x : matrix) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		new MagicSquare().loubereMethod(3);
	}

}
