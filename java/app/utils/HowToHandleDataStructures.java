package utils;

import java.util.*;

public class HowToHandleDataStructures {
	public static void main(String args[]) {
		HowToHandleDataStructures.listExample();
	}
	
    public static void arrayExample() {
        // Array simples
        int[] priceOfPen= new int[5];

        Scanner in=new Scanner(System.in);
	    for(int i=0;i<priceOfPen.length;i++){
	        System.out.println("Digite um inteiro:");
	    	priceOfPen[i]=in.nextInt();
        }
        
        for(int i=0;i<priceOfPen.length;i++){
		    System.out.print(priceOfPen[i]+" ");
        }
    }

    public static void listExample() {
        
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(4);
        lista.add(8);
        lista.add(16);
        lista.add(32);
    
        // O foreach do Java é um for com o tipo do item da lista
        for(Integer item : lista) {
          System.out.println(item);
        }
    }
   
}  