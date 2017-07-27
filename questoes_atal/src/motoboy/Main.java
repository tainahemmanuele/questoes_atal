package motoboy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		while (n != 0) {
			int[] tempo = new int[n];
			int[] pizzaQtd = new int[n];
			
			int qtdPizza= sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				String valor = sc.nextLine();
				int p = Integer.parseInt(valor.split(" ")[0]);
				int t = Integer.parseInt(valor.split(" ")[1]);
				tempo[i] = t;
				pizzaQtd[i] = p;

			}

			int tMax=0;
			int [][] tMaximo= new int [n+1][qtdPizza+1];
			for (int i = 0; i < n+1; i++) {
				for (int j = 0; j < qtdPizza+1; j++) {
					if (i==0 || j==0){
						tMaximo[i][j]=0;
					}
					else if(tempo[i-1]>j){
						tMaximo[i][j]=tMaximo[i-1][j];
					}else{
						tMaximo[i][j] = Math.max(tMaximo[i-1][j], (tMaximo[i-1][j - tempo[i-1]])+pizzaQtd[i-1]);
					}
					tMax= tMaximo[i][j];

				}
				
			}
			System.out.println(tMax + " min.");
			
			n= sc.nextInt();
			sc.nextLine();
		}
	}
}
