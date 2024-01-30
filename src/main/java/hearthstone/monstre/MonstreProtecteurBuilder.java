package hearthstone.monstre;

public class MonstreProtecteurBuilder implements MonstreBuilder {
    private MonstreProtecteur monstre = new MonstreProtecteur(0, 300, "Monstre Protecteur");

    @Override
    public Monstre build() {
        logger.info("Création d'un Monstre Protecteur :\n - id : "+monstre.getId()+"\n - Nom : "+monstre.getNom()+"\n - Quantité de PVs :"+monstre.getPv());
        return monstre;
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
