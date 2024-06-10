package carafe;

public class GarconDeCafe implements Runnable {
  private String nom;
  private int tempsRepos;
  private Carafe carafe;

  public GarconDeCafe(String nom, Carafe carafe, int repos) {
    this.nom = nom;
    this.tempsRepos = repos;
    this.carafe = carafe;
    new Thread(this).start();
  }

  public void run() {
    System.out.println(nom + " demarre son service");
    try {
      while (true) {
			carafe.remplir();
			System.err.println(	nom + " remplit la carafe");

		Thread.sleep(tempsRepos);
      }
    } catch (InterruptedException e) {
      System.out.println(nom + " a termine son service");
    }
  }
}
