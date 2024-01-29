package hearthstone.monstre;

public class MonstreMascotteBuilder implements MonstreBuilder {
    private MonstreMascotte monstre = new MonstreMascotte(0, 50, "Monstre Mascotte", 0);


    @Override
    public Monstre build() {
        logger.info("Création d'un Monstre Mascotte :\n - id : "+monstre.getId()+"\n - Nom : "+monstre.getNom()+"\n - Quantité de PVs :"+monstre.getPv()+"\n - Quantité de Buff : "+monstre.getPourcentageBuff()+"%");
        return monstre;
    }

    public MonstreBuilder setPourcentageBuff(int pourcentageBuff){
        if (pourcentageBuff <= 100 && pourcentageBuff >= 0)
            monstre.setPourcentageBuff(pourcentageBuff);
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
