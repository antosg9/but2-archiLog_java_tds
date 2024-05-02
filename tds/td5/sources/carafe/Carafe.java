package carafe_énoncé;

public class Carafe
 {
  private static int CONTENANCE_STANDARD = 100;
  private int quantite;
  private final int contenance;

  public Carafe(int contenance) {
    this.quantite = 0;
    this.contenance = contenance;
  }

  public Carafe() {
    this(CONTENANCE_STANDARD);
  }

  public void remplir() {
    quantite = contenance;
  }

  public void retirer(int q) {
    quantite -= q;
    if (quantite <= 0)
      quantite = 0;
  }

  public boolean estVide() {
    return quantite == 0;
  }

  @Override
  public String toString() {
    return "la carafe contient " + quantite + "cl";
  }
}
