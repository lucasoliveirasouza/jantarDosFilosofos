package Filosofos;

public class Filosofo extends Thread{

	Mesa mesa;
	int filosofo;

	public Filosofo (String nome, int id,Mesa mesa){
		super(nome);
		this.mesa = mesa;
		filosofo = id;
	}

   public void run (){
         filosofoPensar();
         mesa.filosofoPegarGarfo(filosofo);
         filosofoComer();
         mesa.filosofoDevolverGardo(filosofo);   
   }

	public void filosofoPensar (){
		try{
			sleep(100);
		}
		catch (InterruptedException e){
	         
		}
	}

	public void filosofoComer (){
		try{
			sleep(100);
		}
		catch (InterruptedException e){
         
		}
	}

}