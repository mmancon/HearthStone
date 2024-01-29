package hearthstone.champion;

public interface ChampionListener {
    public void mortChampion();
    public void attaquerAdversaire(int amount);
    public void finDuTour();
}