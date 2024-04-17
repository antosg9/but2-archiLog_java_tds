package voiture.freins;

import voiture.IFreins;
import voiture.Voiture;

public class FreinsStandard implements IFreins {
  private static final int PAS_FREIN = 20;

  @Override
  public void freiner(Voiture voiture) {
    int v = voiture.getVitesse() - PAS_FREIN;
    voiture.setVitesse(v > 0 ? v : 0);
  }

  @Override
  public void réparer() {
    // Ces freins ne sont jamais en panne
  }
}
