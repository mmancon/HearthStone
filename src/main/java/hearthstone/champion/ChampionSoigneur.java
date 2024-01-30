package hearthstone.champion;

import hearthstone.monstre.Monstre;
public class ChampionSoigneur extends Champion {
    private final int soins;

    public ChampionSoigneur(int id, String nom, String cheminVersLeDeck, int soins) {
        super(id, nom, cheminVersLeDeck);
        this.soins = soins;
        printAndLog("Création d'un Champion de type Soigneur du nom de "+this.getNom()+" et ayant "+this.getPv()+" PVs", "info");
    }

    @Override
    public void utiliserCapacite(Monstre cible) {
        if (!capaciteUtilisee) {
            int differencePvMaxPv = cible.getPvMax() - cible.getPv();
            int soinFinal = Math.min(soins, differencePvMaxPv);
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour soigner "+soinFinal+" PVs à "+cible.getNom(),"info");
            cible.prendreDegats(-soinFinal);
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
        if (!capaciteUtilisee && !cible.equals(this)) { // On ne peut pas soigner son Champion
            int differencePvMaxPv = cible.getPvMax() - cible.getPv();
            int soinFinal = Math.min(soins, differencePvMaxPv);
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour soigner "+soinFinal+" PVs à "+cible.getNom(),"info");
            cible.prendreDegats(-soinFinal);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }

    public int getSoins() {
        return soins;
    }

}
