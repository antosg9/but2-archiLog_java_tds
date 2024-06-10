package appli;

import cours.Cours;
import cours.PasAsseezDePlacesException;

public class Inscription implements Runnable {

	private Cours cours;
	private int nbPlaces;

	public Inscription(Cours cours, int nbPlaces) {
		this.cours = cours;
		this.nbPlaces = nbPlaces;
	}

	public void run() {
		try {
			synchronized (cours) {
				cours.inscription(nbPlaces);
			}
		} catch (PasAsseezDePlacesException e) {
			System.out.println(e);
		}
	}
}
