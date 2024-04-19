package exercice_2;

public class Compteur implements Runnable {

	private boolean fin=false;

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Compteur()
	{
		new Thread(this).start(); //Lancement automatique dans le constructeur (nous évite de faire la méthode .lancer())
	}

	@Override
	public void run() {
		int compte=0;
		while(true)
		{
			++compte;
			System.out.println(compte);
			
			try {
				Thread.sleep(1000); // Pause d'une seconde pour ralentir le compteur
			} catch (InterruptedException e) {
				System.out.println("Thread interrompu !");
                return;
			} 
		}		
	}
}
