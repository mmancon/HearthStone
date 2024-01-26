package hearthstone.monstre;

public interface MonstreBuilder {

        Monstre build();

        MonstreBuilder setId(int id);

        MonstreBuilder setNom(String nom);

        MonstreBuilder setPv(int pv);


}
