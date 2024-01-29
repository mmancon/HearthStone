package hearthstone.champion;

public interface ChampionBuilder {

    Champion build();

    ChampionBuilder setId(int id);

    ChampionBuilder setNom(String nom);

    ChampionBuilder setPv(int pv);
    ChampionBuilder setCapacite(String nom);


}
