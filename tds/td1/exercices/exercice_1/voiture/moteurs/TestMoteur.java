package voiture.moteurs;

import voiture.Voiture;

public class TestMoteur implements Runnable{

	private Voiture v;
	
	public TestMoteur(Voiture v)
	{
		this.v=v;
		new Thread (this).start(); /*Lancement automatique dans le contructeur*/
	/*Nous évite de faire la fonction lancer*/
	}
	
	@Override
	public void run() {
		int nb = testMoteur(v);
		System.out.println(v + " nb d'accelerations -> " + nb);		
	}
	
	public static int testMoteur(Voiture v) {
		int cpt = 0;
		v.setVitesse(0);
		while (v.getVitesse() < v.getVitesseMaximale()) {
			v.accelerer();
			System.out.println(v + "accelere"); //Possibilité de commenter cette ligne pour une meilleure visibilité
			++cpt;
		}
		while (v.getVitesse() > 0){
			if(Math.random() < 1.0 / 30.0) // 1/30 de rater le test de freinage
				throw new RuntimeException("Le test de freinage de la voiture"+ v +"a échoué");
			v.freiner();
			System.out.println(v + "freine");  //Possibilité de commenter cette ligne pour une meilleure visibilité
		}

		return cpt;
	}
}
