package voiture.freins;

import voiture.Voiture;

public class FreinsPopulaires extends FreinsStandard {
  private int nbFreinagesViolents = 0;

  private static final int SEUIL = 100;
  private static final int MAX_FREIN = 20;

  @Override
  public void freiner(Voiture voiture) {
    if (nbFreinagesViolents < MAX_FREIN) {
      if (voiture.getVitesse() > SEUIL)
        ++nbFreinagesViolents;
      super.freiner(voiture);
    }
    // sinon, on ne freine plus !!!!
  }

  @Override
  public void réparer() {
    nbFreinagesViolents = 0;
  }
}
