package hearthstone.monstre;

public class MonstreFactory {
    public MonstreClassique buildClassique(int id, int pv, String nom, int degats) {
        MonstreClassiqueBuilder builder = new MonstreClassiqueBuilder();
        builder.setId(id).setNom(nom).setPv(pv);

        builder.setDegats(degats);
        return (MonstreClassique) builder.build();
    }

    public MonstreSoigneur buildSoigneur(int id, int pv, String nom, int quantiteSoin) { // Soigne une entité mais ne peut pas attaquer
        MonstreSoigneurBuilder builder = new MonstreSoigneurBuilder();
        builder.setId(id).setNom(nom).setPv(pv);

        builder.setQuantiteSoin(quantiteSoin);
        return (MonstreSoigneur) builder.build();
    }

    public MonstreMascotte buildMascotte(int id, int pv, String nom, int pourcentageBuff) { // Booste une stat d'une entité
        MonstreMascotteBuilder builder = new MonstreMascotteBuilder();
        builder.setId(id).setNom(nom).setPv(pv);

        builder.setPourcentageBuff(pourcentageBuff);
        return (MonstreMascotte) builder.build();
    }

    public MonstreProtecteur buildProtecteur(int id, int pv, String nom) { // Protège des attaques vers la barre de vie du joueur ou vers un monstre de type non protecteur
        MonstreProtecteurBuilder builder = new MonstreProtecteurBuilder();
        builder.setId(id).setNom(nom).setPv(pv);

        return (MonstreProtecteur) builder.build();
    }
    // Autres Monstres à implémenter
}