package exercice_2;

public class Compteur implements Runnable {

	private boolean fin=false;
	private Thread monThread;

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Compteur()
	{
		monThread = new Thread(this); //Stockage de la référence du Thread pour pouvoir l'arrêter
		monThread.start(); //Lancement automatique dans le constructeur (nous évite de faire la méthode .lancer())
	}

	@Override
	public void run() {
		int compte=0;

		while(true) //Boucle infini
		{			
			if(fin)
			{
				monThread.interrupt(); //Interruption du Thread si fin=true (donc si quelqu'un touche à Arreteur)
			}

			++compte;
			System.out.println(compte);	

			try {
				Thread.sleep(1000); // Pause d'une seconde pour ralentir le compteur
			} catch (InterruptedException e) { //détection de l'interruption du thread
				return; //Sortie de force du thread
			}
		}
	}
}