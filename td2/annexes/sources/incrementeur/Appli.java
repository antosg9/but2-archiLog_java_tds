package incrementeur;

public class Appli {
	public static void main(String args[]) throws InterruptedException {
	    System.out.println("VALEUR " + Incrementeur.getValeur());
	    
	    new Thread(new Incrementeur("Thread1")).start();
	    new Thread(new Incrementeur("Thread1")).start();
	   
	    Thread.sleep(10);
	    
	    System.out.println("VALEUR FINALE " + Incrementeur.getValeur());
	  }
}
