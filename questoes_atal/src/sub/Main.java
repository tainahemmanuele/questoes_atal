package sub;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			sc.nextLine();

		}
		System.out.println("Sum of maximum sum increasing " + " subsequence is " + maxSumIS(array, n));
		int max_atual = 0;
		int max_total = -1;
		int xtemp = 0;
		for (int i = 0; i < n; i++) {
			max_atual = max_atual + array[i];
			if (max_atual < 0) {
				max_atual = 0;
				xtemp = i + 1;
			}
			if (max_atual > max_total) {
				max_total = max_atual;
				int x = xtemp;
				int y = i;
			}
		}

	}

	static int maxSumIS(int arr[], int n) {
		int i, j, max = 0;
		int msis[] = new int[n];

		/* Initialize msis values for all indexes */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/* Pick maximum of all msis values */
		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];
		System.out.println(Arrays.toString(msis));
		return max;


	}


}
