package Filosofos;

public class Jantar{
	
   public static void main (String[] args){
      Mesa mesa = new Mesa ();
      for (int i = 0; i < 5; i++){
    	  String nome = "Filosofo " + i;
    	  Filosofo f = new Filosofo(nome, i, mesa);
    	  f.start();
      }
   }
}