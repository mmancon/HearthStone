package hearthstone.monstre;

import hearthstone.champion.Champion;

public class MonstreSoigneur extends Monstre {
    private int quantiteSoin;
    public MonstreSoigneur(int id, int pv, String nom, int quantiteSoin) {
        super(id, pv, nom);
        this.quantiteSoin = quantiteSoin;
    }

    public void soigner(Monstre cible) {
        if (cible.getPv() > 0 && cible.getPvMax() > cible.getPv()) {
            int soinFinal;
            // On vérifie qu'on ne rend pas à la cible plus de ses PVs
            if (!this.isBuffed())
                soinFinal = getBuffedStat(quantiteSoin) + cible.getPv();
            else
                soinFinal = quantiteSoin+cible.getPv();

            if (soinFinal > cible.getPvMax())
                soinFinal = cible.getPvMax()-soinFinal;
            else soinFinal = quantiteSoin;

            if (this.isBuffed()) {
                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + (100 + getQuantiteBuff()) + "% de " + soinFinal + " ! Pour un total de : " + getBuffedStat(soinFinal), "info");
                cible.prendreDegats(-soinFinal);
            } else {
                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + soinFinal + " PVs", "info");
                cible.prendreDegats(-soinFinal);
            }
        } else {
            if (cible.getPv() < 0)
                printAndLog("Action Interdite : Impossible de soigner un compagnon mort.", "warning");
            if (cible.getPv() == cible.getPvMax())
                printAndLog("Impossible de soigner un allié dont la vie est pleine ("+cible.getNom()+" a "+cible.getPv()+"/"+cible.getPvMax()+")", "info");
        }
    }

    public void soigner(Champion cible) {
        if (cible.getPv() > 0 && cible.getPvMax() > cible.getPv()) {
            int soinFinal;
            // On vérifie qu'on ne rend pas à la cible plus de ses PVs
            if (!this.isBuffed())
                soinFinal = getBuffedStat(quantiteSoin) + cible.getPv();
            else
                soinFinal = quantiteSoin+cible.getPv();

            if (soinFinal > cible.getPvMax())
                soinFinal = cible.getPvMax()-soinFinal;
            else soinFinal = quantiteSoin;

            if (this.isBuffed()) {
                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + (100 + getQuantiteBuff()) + "% de " + soinFinal + " ! Pour un total de : " + getBuffedStat(soinFinal), "info");
                cible.prendreDegats(-soinFinal);
            } else {
                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + soinFinal + " PVs", "info");
                cible.prendreDegats(-soinFinal);
            }
        } else {
            if (cible.getPv() < 0)
                printAndLog("Action Interdite : Impossible de soigner un compagnon mort.", "warning");
            if (cible.getPv() == cible.getPvMax())
                printAndLog("Impossible de soigner un allié dont la vie est pleine ("+cible.getNom()+" a "+cible.getPv()+"/"+cible.getPvMax()+")", "info");
        }
    }

    public int getQuantiteSoin(){
        return quantiteSoin;
    }

    protected void setQuantiteSoin(int quantiteSoin){
        this.quantiteSoin = quantiteSoin;
    }

    @Override
    protected void mourir() {
        if (this.isBuffed()) { // Si le monstre était buffé, on précise au buffer qu'il ne buffe plus
            this.getMascotte().setBuffing(false);
            this.getMascotte().setMonstreBuffed(null);
        }
    }
}
