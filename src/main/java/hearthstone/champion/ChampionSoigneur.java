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
        if (!capaciteUtilisee && cible.getPv() > 0 && cible.getPvMax() > cible.getPv()) {
            int soinFinal = soins+cible.getPv();

            if (soinFinal > cible.getPvMax())
                soinFinal = cible.getPvMax()-soinFinal;
            else soinFinal = soins;
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour soigner "+soinFinal+" PVs à "+cible.getNom(),"info");
            cible.prendreDegats(-soinFinal);
        } else {
            if (cible.getPv() < 0)
                printAndLog("Action Interdite : Impossible de soigner un compagnon mort.", "warning");
            if (cible.getPv() == cible.getPvMax())
                printAndLog("Impossible de soigner un allié dont la vie est pleine ("+cible.getNom()+" a "+cible.getPv()+"/"+cible.getPvMax()+")", "info");
            }
    }

    @Override
    public void utiliserCapacite() {

    }

    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee && cible.getPv() > 0 && cible.getPvMax() > cible.getPv() && !cible.equals(this)) {
            int soinFinal = soins+cible.getPv();

            if (soinFinal > cible.getPvMax())
                soinFinal = cible.getPvMax()-soinFinal;
            else soinFinal = soins;
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour soigner "+soinFinal+" PVs à "+cible.getNom(),"info");
            cible.prendreDegats(-soinFinal);
        } else {
            if (cible.getPv() < 0)
                printAndLog("Action Interdite : Impossible de soigner un compagnon mort.", "warning");
            if (cible.getPv() == cible.getPvMax())
                printAndLog("Impossible de soigner un allié dont la vie est pleine ("+cible.getNom()+" a "+cible.getPv()+"/"+cible.getPvMax()+")", "info");
        }
    }

    public int getSoins() {
        return soins;
    }

}
