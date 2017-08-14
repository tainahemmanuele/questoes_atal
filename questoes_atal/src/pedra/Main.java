package pedra;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] inicio = new int[n];
		int[] fim = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			String valor = sc.nextLine();
			int c = Integer.parseInt(valor.split(" ")[0]);
			int f = Integer.parseInt(valor.split(" ")[1]);
			inicio[i] = c;
			fim[i] = f;
		}
		int[] tempo = new int[3600 + 1];
		for (int i = 0; i < tempo.length; i++) {
			tempo[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			if (tempo[inicio[i]] == 0 && tempo[fim[i]] == 0) {
				int value = fim[i] - inicio[i];
				for (int k = inicio[i]; k < value; k++) {
					tempo[k] = 1;
				}
				tempo[fim[i]] = value;
				max += tempo[fim[i]];

			}
			else if (tempo[inicio[i]] == 0 && tempo[fim[i]] != 0 ) {
				int maxC = 0;
				int maxAtual = 0;
				maxC = tempo[fim[i]];
				int aux = max - tempo[fim[i]];
				maxAtual = aux + (fim[i] - inicio[i]);
				if (maxAtual > max) {
					int value = fim[i] - inicio[i];
					max -= maxC;
					for (int k = inicio[i]; k < value; k++) {
						tempo[k] = 1;
					}
					tempo[fim[i]] = Math.max(max, max + value);
					max = tempo[fim[i]];

				}
			}


		}
		System.out.println(max);

	}

}
