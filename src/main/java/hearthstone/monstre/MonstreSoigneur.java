package hearthstone.monstre;

public class MonstreSoigneur extends Monstre {
    private int quantiteSoin;
    public MonstreSoigneur(int id, int pv, String nom, int quantiteSoin) {
        super(id, pv, nom);
        this.quantiteSoin = quantiteSoin;
    }

    public void soigner(Monstre cible){
        if(cible.getPv() > 0) {
            if (this.isBuffed()) {
                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + (100 + getQuantiteBuff()) + "% de " + quantiteSoin + " ! Pour un total de : " + getBuffedStat(quantiteSoin), "info");
                cible.prendreDegats(-getBuffedStat(quantiteSoin));
            } else {
                printAndLog(getNom() + " soigne " + cible.getNom() + " et lui rend " + quantiteSoin + " PVs", "info");
                cible.prendreDegats(-quantiteSoin);
            }
        }
        else
            printAndLog("Action Interdite : Impossible de soigner un compagnon mort.","warning");
    }

    public int getQuantiteSoin(){
        return quantiteSoin;
    }

    protected void setQuantiteSoin(int quantiteSoin){
        this.quantiteSoin = quantiteSoin;
    }

    @Override
    protected void mourir() {
        // do smth
    }
}
