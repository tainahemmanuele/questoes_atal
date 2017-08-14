package fatores_permitidos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		int n = Integer.parseInt(entrada.split(" ")[0]);
		int m = Integer.parseInt(entrada.split(" ")[1]);
		while (n != 0 && m != 0) {
			int[] values = new int[n];
			String num = sc.nextLine();
			for (int i = 0; i < values.length; i++) {
				values[i] = Integer.parseInt(num.split(" ")[i]);
			}
			int indice = (int) Math.pow(10, 6);
			int[] sequence = new int[indice + 1];
			for (int i = 0; i < values.length; i++) {
				sequence[values[i]]=1;
				for (int j = values[i]; j < indice + 1; j++) {
					int mult = (values[i] * j);
					if (mult <= indice) {
						sequence[mult] = 1;
					}

				}

			}
			int k = values[0];
			int contador = 0;
			int index = 0;
			while (k < indice + 1) {
				if (sequence[k] == 1) {
					contador += 1;
					if (contador == m) {
						index = k;
						break;
					}
				}

				k++;
			}

			System.out.println(index);

			n = Integer.parseInt(entrada.split(" ")[0]);
			m = Integer.parseInt(entrada.split(" ")[1]);
		}
	}

}
