package hearthstone.monstre;

public class MonstreClassiqueBuilder implements MonstreBuilder {
    private MonstreClassique monstre = new MonstreClassique(0, 100, "Monstre Classique", 25);

    @Override
    public Monstre build() {
        logger.info("Création d'un Monstre Classique :\n - id : "+monstre.getId()+"\n - Nom : "+monstre.getNom()+"\n - Quantité de PVs :"+monstre.getPv()+"\n - Quantité de Dégâts : "+monstre.getDegats());
        return monstre;
    }

    public MonstreBuilder setDegats(int degats) {
        monstre.setDegats(degats);
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
