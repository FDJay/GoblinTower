package goblintower.mvc.model;
import java.util.Random;

public class Player{
    private int hPoints;
    private int aPower;
    private int defense;
    private int gold;
    private int[] potions = {2, 2, 2, 2, 2};;

    public void setHvals(int gold){
        this.hPoints = new Random().nextInt((30-20)+1) + 20;
        this.aPower = new Random().nextInt((3-1) +1) + 1;
        this.defense = new Random().nextInt((5-1) + 1) + 1;
        this.gold = gold;
    }
    public int getHealthPoints(){ return hPoints; }
    public int getAttackPower(){ return aPower; }
    public int getDefense(){ return defense; }
    public int getGold(){ return gold; }
    public int[] getPotions(){ return potions; }
}