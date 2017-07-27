package lucro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linha;

		while ((linha = sc.readLine()) != null) {
			int dias = Integer.parseInt(linha);
			int custo = Integer.parseInt(sc.readLine());
			int max = 0;
			int[] receitas = new int[dias+1];
			if (dias!=0){
			receitas[0]=0;
			for (int i = 1; i < dias+1; i++) {
				receitas[i] = Integer.parseInt(sc.readLine());
			}

			int[] ganhos = new int[dias+1];

			ganhos[0] = 0;

			for (int i = 1; i < dias+1; i++) {
				ganhos[i] = Math.max(receitas[i] - (custo), ((receitas[i] - custo ) + ganhos[i-1]));

				if (ganhos[i] > max) {
					max = ganhos[i];
				}

			}
			}
			out.println(max);
		}

		out.close();
	}

}