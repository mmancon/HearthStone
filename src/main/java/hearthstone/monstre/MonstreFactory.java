package hearthstone.monstre;

public class MonstreFactory {
    public MonstreClassique buildClassique(int id, int pv, String nom, int degats) {
        MonstreClassiqueBuilder builder = new MonstreClassiqueBuilder();
        builder.setId(id);
        builder.setNom(nom);
        builder.setPv(pv);

        builder.setDegats(degats);
        return (MonstreClassique) builder.build();
    }

    public MonstreClassique buildClassique() {
        MonstreClassiqueBuilder builder = new MonstreClassiqueBuilder();
        return (MonstreClassique) builder.build();
    }


    public MonstreSoigneur buildSoigneur(int id, int pv, String nom, int quantiteSoin) { // Soigne une entité mais ne peut pas attaquer
        MonstreSoigneurBuilder builder = new MonstreSoigneurBuilder();
        builder.setId(id);
        builder.setNom(nom);
        builder.setPv(pv);

        builder.setQuantiteSoin(quantiteSoin);
        return (MonstreSoigneur) builder.build();
    }

    public MonstreSoigneur buildSoigneur() { // Soigne une entité mais ne peut pas attaquer
        MonstreSoigneurBuilder builder = new MonstreSoigneurBuilder();
        return (MonstreSoigneur) builder.build();
    }

    public void buildMascotte(MonstreBuilder b) {
    // Booste les dégâts d'une entité
    }

    public MonstreProtecteur buildProtecteur(int id, int pv, String nom) { // Protège des attaques vers la barre de vie du joueur ou vers un monstre de type non protecteur
        MonstreProtecteurBuilder builder = new MonstreProtecteurBuilder();
        builder.setId(id);
        builder.setNom(nom);
        builder.setPv(pv);

        return (MonstreProtecteur) builder.build();
    }
    // Autres Monstres à implémenter
}