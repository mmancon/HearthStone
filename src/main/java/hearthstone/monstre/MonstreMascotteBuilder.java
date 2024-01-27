package hearthstone.monstre;

public class MonstreMascotteBuilder implements MonstreBuilder {
    private MonstreMascotte monstre = new MonstreMascotte(0, 50, "Monstre Mascotte", 0);


    @Override
    public Monstre build() {
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
