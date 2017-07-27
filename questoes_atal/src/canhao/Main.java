package canhao;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vezes = sc.nextInt();
		sc.nextLine();
		for (int k = 0; k < vezes; k++) {
			

		int n = sc.nextInt();
		sc.nextLine();
		int[] poder = new int[n];
		int[] peso = new int[n];

		for (int i = 0; i < n; i++) {
			String valor = sc.nextLine();
			int p = Integer.parseInt(valor.split(" ")[0]);
			int t = Integer.parseInt(valor.split(" ")[1]);
			poder[i] = t;
			peso[i] = p;

		}
		
		int carga = sc.nextInt();
		sc.nextLine();
		int resistencia = sc.nextInt();
		sc.nextLine();
		int max=0;
		int [][] dano = new int [n+1][carga+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < carga+1; j++) {
				if (i==0 || j==0){
					dano[i][j]=0;
				}else if(poder[i-1]>j){
					dano [i][j]= dano[i-1][j];
				}else{
					dano[i][j]= Math.max(dano[i-1][j], (dano[i-1][j-poder[i-1]])+peso[i-1]);
				}

				max = dano[i][j];
				
			}

			
		}
		if(max >= resistencia){
			System.out.println("Missao completada com sucesso");
		}else{
			System.out.println("Falha na missao");
		}
		}
	}
}