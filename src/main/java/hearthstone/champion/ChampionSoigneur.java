package hearthstone.champion;

import hearthstone.monstre.Monstre;
public class ChampionSoigneur extends Champion {
    private final int soins;

    public ChampionSoigneur(int id, String nom, String cheminVersLeDeck, int soins) {
        super(id, nom, cheminVersLeDeck);
        this.soins = soins;
    }

    @Override
    public void utiliserCapacite(Monstre cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour soigner "+soins+" à"+cible.getNom(),"info");
            cible.prendreDegats(-soins);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }

    @Override
    public void utiliserCapacite() {

    }

    @Override
    public void mourir() {

    }

    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour soigner "+cible.getNom(),"info");
            cible.prendreDegats(-200);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }

    public int getSoins() {
        return soins;
    }

}
