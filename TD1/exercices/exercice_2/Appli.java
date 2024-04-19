package exercice_2;

public class Appli {

	public static void main(String[] args) {
		Compteur compte= new Compteur(); //Lancement du compteur
		new Arreteur(compte); // lancement de l’arreteur du compteur
	}
}
