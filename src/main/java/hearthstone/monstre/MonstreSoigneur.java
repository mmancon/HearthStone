package hearthstone.monstre;

public class MonstreSoigneur extends Monstre {
    private int quantiteSoin;
    public MonstreSoigneur(int id, int pv, String nom, int quantiteSoin) {
        super(id, pv, nom);
        this.quantiteSoin = quantiteSoin;
    }

    public void soigner(Monstre cible){
        if(cible.getPv() > 0){
            cible.prendreDegats(-quantiteSoin);
        } else {
            System.out.println("Impossible de soigner un compagnon mort..");
        }
    }

    public int getQuantiteSoin(){
        return quantiteSoin;
    }

    protected void setQuantiteSoin(int quantiteSoin){
        this.quantiteSoin = quantiteSoin;
    }
}
