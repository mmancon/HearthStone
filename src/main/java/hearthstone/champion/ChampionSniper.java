package hearthstone.champion;

public abstract class ChampionSniper extends Champion {
    private int degats;

    public ChampionSniper() {
        super(1,30,"Mage");
    }

    @Override
    public void utiliserCapacite() {
        getListener().attaquerAdversaire(2);
        // Logique pour attaquer un champion
        System.out.println(this.getNom() + " attaque avec " + this.degats + " de dégâts.");
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
