package parque;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String palavra1 = sc.nextLine();
		while (palavra1 != "#") {
			String palavra2 = sc.nextLine();
			int max = 0;
			String palavra = "";
			int[][] palavras = new int[palavra1.length() + 1][palavra2.length() + 1];
			for (int i = 0; i < palavra1.length(); i++) {
				for (int j = 0; j < palavra2.length(); j++) {
					if (i == 0 || j == 0) {
						palavras[i][j] = 0;
					} else if (palavra1.charAt(i) == palavra2.charAt(j)) {
						palavras[i][j] = 1 + palavras[i - 1][j - 1];
					} else {
						palavras[i][j] = Math.max(palavras[i][j - 1], palavras[i - 1][j]);
					}
					max = palavras[i][j];

				}
			}
			int value = (palavra1.length() + palavra2.length()) - max;
			char[] palavraN = new char[value];
			int k = 0;
			int value1 = palavra1.length()-1;
			int value2 = palavra2.length()-1;
			while (k < value) {
				if (value1 > 0 && value2 > 0 && palavra1.charAt(value1) == palavra2.charAt(value2)) {
					palavraN[k] = palavra1.charAt(value1);
					value1--;
					value2--;
				} else {
					if (value2 > 0 && palavras[value1][value2] == palavras[value1][value2-1]+1) {
						palavraN[k] = palavra1.charAt(value1);
						value1--;
						
					} else {
						palavraN[k] = palavra2.charAt(value2);
						value2--;
						
					}
				}
				System.out.println(Arrays.toString(palavraN));
				k++;

			}
			System.out.println(max);
			System.out.println(Arrays.toString(palavraN));
			palavra1 = sc.nextLine();

		}

	}

}
