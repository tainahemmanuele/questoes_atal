package parque;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String palavra1 = sc.nextLine();
			int tempo = 0;
			while (!(palavra1.equals("#"))) {
				String palavra2 = sc.nextLine();
				int max = 0;
				String palavra = "";
				tempo++;
				int[][] palavras = new int[palavra1.length()+1][palavra2.length()+1];
				for (int i = 0; i < palavra1.length(); i++) {
					for (int j = 0; j < palavra2.length(); j++) {
						if (i == 0 || j == 0) {
							palavras[i][j] = 0;
						} else if (palavra1.charAt(i - 1) == palavra2.charAt(j - 1)) {
							palavras[i][j] = 1 + palavras[i - 1][j - 1];
						} else {
							palavras[i][j] = Math.max(palavras[i - 1][j], palavras[i][j - 1]);
						}
						max = palavras[i][j];

					}
				}

				int value1 = palavra1.length();
				int value2 = palavra2.length();
				while (value1 != 0 && value2 != 0) {
					if (palavra1.charAt(value1 - 1) == palavra2.charAt(value2 - 1)) {
						palavra += palavra1.charAt(value1 - 1);
						value1--;
						value2--;

					} else {
						if (palavras[value1][value2] == palavras[value1 - 1][value2]) {
							palavra += palavra1.charAt(value1 - 1);
							value1 = value1 - 1;

						} else {
							palavra += palavra2.charAt(value2 - 1);
							value2 = value2 - 1;

						}
					}

				}

				while (value1 > 0) {
					palavra += palavra1.charAt(value1 - 1);
					value1--;
				}

				while (value2 > 0) {
					palavra += palavra2.charAt(value2 - 1);
					value2--;
				}


				StringBuffer fim = new StringBuffer(palavra).reverse();
				System.out.println("Teste " + tempo);
				System.out.println(fim);
				palavra1 = sc.nextLine();
			}
		} catch (Exception e) {
			return ;
		}
	}

}
