package incrementeur;
public final class Incrementeur implements Runnable {
	
  private static int cpt = 1;
  
  private String name;
  public Incrementeur(String name) {
    this.name = name;
  }

  public static int getValeur() {
    return cpt;
  }

  public void run() {
    for (int i = 1; i <= 10; i++) {
      int c = cpt;
      System.out.println("valeur a incrementer (round " + i + ") : " 
          + c + " par " + name);
      c = c + 1;
      System.out.println("valeur calculee (round " + i + ") par " + name 
          + " est : " + cpt);
      cpt = c;
    }
  }
}