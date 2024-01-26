package hearthstone.monstre;

public class MonstreSoigneurBuilder implements MonstreBuilder {
    private MonstreSoigneur monstre = new MonstreSoigneur(0, 100, "Monstre Soigneur", 12);

    @Override
    public Monstre build() {
        return monstre;
    }

    public MonstreBuilder setQuantiteSoin(int quantiteSoin){
        monstre.setQuantiteSoin(quantiteSoin);
        return this;
    }

    @Override
    public MonstreBuilder setId(int id) {
        monstre.setId(id);
        return this;
    }

    @Override
    public MonstreBuilder setNom(String nom) {
        monstre.setNom(nom);
        return this;
    }

    @Override
    public MonstreBuilder setPv(int pv) {
        monstre.setPv(pv);
        return this;
    }
}
