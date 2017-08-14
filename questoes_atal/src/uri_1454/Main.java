package uri_1454;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valor = sc.nextLine();
		int n = Integer.parseInt(valor.split(" ")[0]);
		int m = Integer.parseInt(valor.split(" ")[1]);
		int[][] ruas = new int[n + 1][n + 1];
		ruas[0][0] = 0;
		for (int i = 0; i < m; i++) {
			String entrada = sc.nextLine();
			ruas[Integer.parseInt(entrada.split(" ")[0])][Integer.parseInt(entrada.split(" ")[1])] = Integer
					.parseInt(entrada.split(" ")[2]);
			ruas[Integer.parseInt(entrada.split(" ")[1])][Integer.parseInt(entrada.split(" ")[0])] = Integer
					.parseInt(entrada.split(" ")[2]);

		}
		int value = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < value; i++) {
			String caminho = sc.nextLine();
			int inicio = Integer.parseInt(caminho.split(" ")[0]);
			int fim = Integer.parseInt(caminho.split(" ")[1]);
			int result = ruas[inicio][fim];
			for (int j = inicio; j < fim; j++) {
				for (int k = inicio; k < fim; k++) {
					for (int l = inicio; l < fim; l++) {
						ruas[k][l] = Math.min(ruas[k][l], Math.max(ruas[k][j], ruas[j][l]));
						if(ruas[k][l]>result){
							result = ruas[k][l];
						}

				

					}

				}

			}
			System.out.println(result);

			//System.out.println(result);

		}
	}

}
