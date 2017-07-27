package parque;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String palavra1 = sc.nextLine();
		int contador = 0;
		while (palavra1 != "#") {
			contador += 1;
			String palavra2 = sc.nextLine();
			String pNova = "";
			int value = 0;
			int[][] c = new int[palavra1.length() + 1][palavra2.length() + 1];
			for (int i = 0; i < palavra1.length(); i++) {
				for (int j = 0; j < palavra2.length(); j++) {
					if (i == 0 || j == 0) {
						c[i][j] = 0;
					} else if (palavra1.charAt(i - 1) == palavra2.charAt(j - 1)) {
						c[i][j] = 1 + c[i - 1][j - 1];
						;

					} else {
						c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
					}
					value = c[i][j];
				}

			}

			int index = (palavra1.length() + palavra2.length()) - value;
			int k = 0;
			int j = 0;
			while (k < palavra1.length() && j < palavra2.length()) {
				if (palavra1.charAt(k) == palavra2.charAt(j)) {
					pNova += palavra1.charAt(k);
				} else {
					pNova += palavra2.charAt(j);
					pNova += palavra1.charAt(k);
				}
				k++;
				j++;
			}

			if (k < palavra1.length() ) {
				while (k < palavra1.length()) {
					pNova += palavra1.charAt(k);
					k++;
				}
			}
			if (j < palavra2.length()) {
				while (j < palavra2.length()) {
					pNova += palavra2.charAt(j);
					j++;
				}
			}
			System.out.println(pNova);
		}
	}

}
