package carafe;

public class AppliCarafe {
  public static void main(String[] args) {
    Carafe carafe = new ConcurrentCarafe(new CarafeSimple()); //La carafe utilisée par le programme sera le proxy qui gère le thread-safety dans sa classe
    

    // un garcon de cafe se nommant Brette, se reposant 150ms a chaque tour de
    // remplissage de la carafe
    new GarconDeCafe("Marc", carafe, 150);

    // trois convives (nom,carafe,temps pour boire son verre)
    new Convive("Alfred", carafe, 25);
    new Convive("Stan", carafe, 18);
    new Convive("Franck", carafe, 35);
  }
}
