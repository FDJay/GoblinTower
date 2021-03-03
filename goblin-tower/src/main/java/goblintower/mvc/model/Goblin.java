package goblintower.mvc.model;
import java.util.Random;

public class Goblin{
    private int hPoints;
    private int aPower;
    private int defense;

    public void setGvals(){
        this.hPoints = new Random().nextInt((10-5)+1) + 5;
        this.aPower = new Random().nextInt((3-2) +1) + 2;
        this.defense = new Random().nextInt((2-1) + 1) + 1;
    }
    public int getHealthPoints(){ return hPoints; }
    public int getAttackPower(){ return aPower; }
    public int getDefense(){ return defense; }
}