package promocao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public Main () {
		// TODO Auto-generated constructor stub
	}
	
	public int totalProdutos(int qtd, int peso, int[] precoProduto, int []pesoProduto){
		int max =0;
		int [][] maximo = new int[qtd+1][peso+1];
		for (int i = 0; i  < qtd+1; i++) {
			for (int j = 0; j < peso+1; j++) {
				if (i==0 || j==0){
					maximo[i][j] = 0;
				}else if (pesoProduto[i-1] > j ){
					maximo[i][j] = maximo[i-1][j];
				}else{
					maximo[i][j] = Math.max(maximo[i-1][j], (maximo[i-1][j -pesoProduto[i-1]])+precoProduto[i-1]);
				}
				max = maximo[i][j];

			}


		}

		return max;
		
	}
	public static void main(String[] args) {
		Main p = new Main();
		Scanner sc = new Scanner(System.in);
		String nLista = sc.nextLine();
        int qtd = Integer.parseInt(nLista);
       while( qtd!=0){
    	   int [] pesoProduto= new int [qtd];
    	   int [] precoProduto = new int [qtd];
    	   
    	   for (int i = 0; i < qtd; i++) {
    		   String valor = sc.nextLine();
    			int n = Integer.parseInt(valor.split(" ")[0]);
    			int k = Integer.parseInt(valor.split(" ")[1]);
    			pesoProduto[i]=k;
    			precoProduto[i]=n;
    			
		}
    	   
        String pLista= sc.nextLine();
        int peso = Integer.parseInt(pLista);
        int value= p.totalProdutos(qtd, peso, precoProduto, pesoProduto);
        System.out.println(value);
        
        qtd = sc.nextInt();
        sc.nextLine();
        }
	}
}