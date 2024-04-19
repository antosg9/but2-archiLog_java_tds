package exercice_2;
import java.util.Scanner;

public class Arreteur implements Runnable{

	private Compteur t; //Récupération du thread compteur dans ma classe Arrêteur

	public Arreteur(Compteur t)
	{
		new Thread(this).start();
		this.t=t;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextLine())
			t.setFin(true);
		scanner.close();
	}
}