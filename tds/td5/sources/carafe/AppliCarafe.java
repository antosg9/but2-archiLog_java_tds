package carafe_énoncé;

public class AppliCarafe {
  public static void main(String[] args) {
    Carafe carafe = new Carafe();

    // un garçon de café se nommant Brette, se reposant 150ms à chaque tour de
    // remplissage de la carafe
    new GarconDeCafe("Brette", carafe, 150);

    // trois convives (nom,carafe,temps pour boire son verre)
    new Convive("Alfred", carafe, 25);
    new Convive("Bebert", carafe, 18);
    new Convive("Chochotte", carafe, 35);
  }
}
