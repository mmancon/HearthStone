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
            int differencePvMaxPv = cible.getPvMax() - cible.getPv();

            if (this.isBuffed()) {
                int soinBuffed = getBuffedStat(quantiteSoin);
                int soinFinal = Math.min(soinBuffed, differencePvMaxPv);

                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + (100 + getQuantiteBuff()) + "% de " + quantiteSoin + " ! Pour un total de : " + soinFinal, "info");
                cible.prendreDegats(-soinFinal);
            } else {
                int soinFinal = Math.min(quantiteSoin, differencePvMaxPv);

                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + soinFinal + " PVs", "info");
                cible.prendreDegats(-soinFinal);
            }
        } else {
            printAndLog("Action Interdite : Impossible de soigner un compagnon mort.", "warning");
        }
    }

    public void soigner(Champion cible) {
        if (cible.getPv() > 0 && cible.getPvMax() > cible.getPv()) {
            int differencePvMaxPv = cible.getPvMax() - cible.getPv();

            if (this.isBuffed()) {
                int soinBuffed = getBuffedStat(quantiteSoin);
                int soinFinal = Math.min(soinBuffed, differencePvMaxPv);

                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + (100 + getQuantiteBuff()) + "% de " + quantiteSoin + " ! Pour un total de : " + soinFinal, "info");
                cible.prendreDegats(-soinFinal);
            } else {
                int soinFinal = Math.min(quantiteSoin, differencePvMaxPv);

                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + soinFinal + " PVs", "info");
                cible.prendreDegats(-soinFinal);
            }
        } else {
            printAndLog("Action Interdite : Impossible de soigner un compagnon mort.", "warning");
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
