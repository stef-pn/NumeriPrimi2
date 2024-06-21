/* Il SW deve servire per valutare un array di interi in input, separando i primi dai non primi.
ie: dati {11, 22, 37, 27, 107, 4}
Primi: 11,37,107
Non primi: 22, 27, 4

Per ottimizzare il sw vogliamo minimizzare le ripetizioni e quindi è necessario:
1-identificare il numero massimo da testare (ie 107)
2-identificare il suo massimo divisore (ie radice di 107, quindi 10)
3-identificare tutti i numeri primi tra 2 e 10 e memorizzarli in un array
4-testare ogni elemento di dati con i numeri primi trovati e smistarli a seconda dell'esito del test
5-pubblicare i numeri primi
6-pubblicare i non primi */

package com;
import java.util.ArrayList;

public class NumeriPrimi {
	  
	  public int a[] = {1, 0, 2, -3, -121, 11, 22, 37, 27, 107, 4, -1, -2}; //array di interi da valutare
	  
	  public ArrayList<Integer> primi = new ArrayList<>();  
	  public ArrayList<Integer> nonPrimi = new ArrayList<>();
	  public ArrayList<Integer> divisori = new ArrayList<>();
	  
	  public int max; //numero massimo dell'array a
	  public int x;   //radice quadrata di max
	  public int y;   //massimo divisore di max
	  
	  public void getMax() { //metodo per trovare il numero massimo da testare
	   max = a[0];
	       for(int i = 0; i < a.length; i++)
	       {
	         if(max < Math.abs(a[i]))
	         {
	            max = Math.abs(a[i]);
	         }
	       }
	       System.out.println("Il numero massimo da testare è: " + max);
	  }
	  
	  public void massimoDivisore() { //metodo per trovare la radice quadrata e il massimo divisore
	   double x = Math.sqrt((double)max);
	   y = (int)x;
	   System.out.println("Il massimo divisore è: " + y);
	  }
	  
	  public void trovaPrimi() { // metodo per trovare i numeri primi fino al massimo divisore di max
		  
	   for(int i = 2; i <= y; i++) {
		   boolean dividendo = false;
	    
		   for(int k = 2; k <= i/2; k++) { 
			   if(i % k == 0) {
				   dividendo = true;
				   break;  
			   }
		   } 
		   
	       if(dividendo == false) {   
	    	   divisori.add(i); //aggiungo i numeri trovati all arraylist
	       }
	       
	   	}  System.out.println("I divisori che servono sono: " + divisori);
	  }
	  
	  public void separaNumeri(){ //metodo per dividere i numeri primi da quelli non primi
		  
	      for(int i = 0; i < a.length; i++){ //faccio iterazioni su tutti gli elementi dell array a
	    	  
	          boolean divisore = false;
	          int daTestare = a[i]; //il numero che voglio testare
	          
	          for(int k = 0; k < divisori.size(); k++){// provo a dividere per i divisori trovati nel metodo precedente
	        	  
	              if(daTestare % divisori.get(k) == 0 && Math.abs(daTestare) != divisori.get(k)){
	                  divisore = true;
	                  break;
	              }
	          }
	          
	          if(divisore == true || Math.abs(daTestare) == 1){ //se dividendo == true il numero non è primo e lo aggiungo alla lista non primi
	              nonPrimi.add(daTestare);
	          } else { // altrimenti è primo e lo aggiungo alla lista dei primi
	              primi.add(daTestare);
	          }
	      }
	      
	      System.out.println("Sono primi: " + primi);
	      System.out.println("Non sono primi: " + nonPrimi);
	  }
	  
	  
}
