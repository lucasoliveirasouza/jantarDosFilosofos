package Filosofos;

public class Mesa{
  
	final static int QTD = 5;
	String[] filosofos = new String[QTD];
  
	public Mesa(){
		for (int i=0; i<QTD; i++){
			filosofos[i] = "Pensando";  
		}
	}

	public synchronized void filosofoPegarGarfo (int filosofo){
		filosofos[filosofo] = "Fome";
		while (filosofos[filosofoEsquerda(filosofo)].equals("Comendo") || filosofos[filosofoDireita(filosofo)].equals("Comendo")){
			try{
				wait();
			}
			catch (InterruptedException e){
				
			}
		}
     
		filosofos[filosofo] = "Comendo";
		mostraStatus(); 
	}

	public synchronized void filosofoDevolverGardo (int filosofo){
     
		if (filosofos[filosofoEsquerda(filosofo)].equals("Fome") || filosofos[filosofoDireita(filosofo)].equals("Fome")){
			notifyAll();
		}
		filosofos[filosofo] = "Pensando";
		//mostraStatus(); 
      
	}
	public int filosofoEsquerda(int id){
		int esquerda;
		if(id == 0){
			esquerda = QTD-1;
			return esquerda;
		}
		esquerda = id-1;
		return esquerda;
	}
	
	public int filosofoDireita(int id){
		int direita;
		if(id == QTD-1){
			direita = 0;
			return direita;
		}
		direita = id+1;
		return direita;
	}

   

	public void mostraStatus (){
		System.out.print("STATUS DOS FILOSOFOS = [");
      for (int i = 0; i < QTD; i++)
      {
         if(i==(QTD-1)){
        	 System.out.println(filosofos[i] + "]");
         }else{
        	 System.out.print(filosofos[i] + ", ");
         }
        
      }
      
   }

   
}