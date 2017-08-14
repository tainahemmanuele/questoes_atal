package cartoes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int cartoes = sc.nextInt();
		sc.nextLine();
		int [] vCartoes = new int [cartoes];
		String valor = sc.nextLine();
		for (int i = 0; i < vCartoes.length; i++) {
			vCartoes[i]= Integer.parseInt(valor.split(" ")[i]);	
			
		}
		int [] maxValues = new int [cartoes];

		for (int i = 0; i < maxValues.length; i++) {
			int max =vCartoes[i];
			for (int j = i+1; j < maxValues.length; j++) {
				max = Math.max(max, vCartoes[i] + vCartoes[j]);
				System.out.println(max);
				
			}
			maxValues[i]=max;
			
			
		}
		int mFinal=maxValues[0];
		for (int i = 0; i < maxValues.length; i++) {
			if( maxValues[i] > mFinal){
				mFinal = maxValues[i];
			}
			
		}
		System.out.println(mFinal);

	}

}