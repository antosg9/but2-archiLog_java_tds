// Voiture.java
package voiture;

public class Voiture {
  private String nom;
  private int vitesse;
  private IFreins freins;
  private IMoteur moteur;

  // Ce constructeur n'a plus à être public, les voitures sont construites par
  // l'usine
  // public Voiture(String nom) {
  // this(nom, new FreinsStandard(), new MoteurStandard());
  // }

  // Visibilité paquetage
  Voiture(String nom, IFreins freins, IMoteur moteur) {
    this.nom = nom;
    this.vitesse = 0;
    this.freins = freins;
    this.moteur = moteur;
  }

  // Les 6 méthodes suivantes sont 'final' car elles n'ont pas vocation à être
  // spécialisées

  public final String getNom() {
    return nom;
  }

  public final int getVitesse() {
    return vitesse;
  }

  public final void setVitesse(int v) {
    vitesse = v;
  }

  @Override
  public final String toString() {
    return nom;
  }

  public final void freiner() {
    freins.freiner(this);
  }

  public final void remplacerFreins(IFreins freins) {
    this.freins = freins;
  }

  public final void réparerFreins() {
    freins.réparer();
  }

  public final int getVitesseMaximale() {
    return moteur.getVitesseMaximale(this);
  }

  public final void accélérer() {
    moteur.accélérer(this);
  }

}
