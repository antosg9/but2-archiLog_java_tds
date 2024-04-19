// Appli.java
package client;

import voiture.Voiture;
import voiture.moteurs.TestMoteur;
import voiture.Usine;
import static voiture.Usine.Version;

public class Appli {

	public static void main(String[] args) {
		Voiture[] tab = { 
				Usine.construit("607", Version.STANDARD),
				Usine.construit("Clio", Version.POPULAIRE),
				Usine.construit("Clio sport", Version.SUICIDAIRE), 
		};
		for (Voiture v : tab) {
			new TestMoteur(v);
		}
	}
}
