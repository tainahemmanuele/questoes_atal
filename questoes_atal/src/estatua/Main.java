package estatua;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < index; i++) {
			String valor = sc.nextLine();
			int n = Integer.parseInt(valor.split(" ")[0]);
			int m = Integer.parseInt(valor.split(" ")[1]);
			String valores = sc.nextLine();
			int[] blocos = new int[n];
			int k = 0;
			int s = valores.length() - valores.replace(" ", "").length();
			for (int j = s; j >= 0 ; j--) {
				blocos[k] = Integer.parseInt(valores.split(" ")[j]);
				if(blocos[k]==0){
					blocos[k]=1;
				}
				k++;
			}
			Arrays.sort(blocos);
			int contador = 0;
			int aux = m;
			for (int j = n-1; j >= 0; j--) {
				while (m >= blocos[j]) {
					m = (m - blocos[j]);
					contador= contador+1;
				}
			}
			System.out.print(contador);
		}
	}

}
