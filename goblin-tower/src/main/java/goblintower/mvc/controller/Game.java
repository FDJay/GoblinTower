package goblintower.mvc.controller;
import java.util.Random;
import goblintower.mvc.model.Goblin;
import goblintower.mvc.model.Player;
import goblintower.mvc.view.Display;
 
public class Game {
    static Display msg = new Display();
    static int level = 1;
    static int slain = 0;    

    public void start(Player hero, Goblin goblin){
        int gHealth = goblin.getHealthPoints();
        int hHealth = hero.getHealthPoints();
        int gold = hero.getGold();
        int stepCount = 0; 
        int [] potions = hero.getPotions();
        boolean play = true;
        System.out.println("\nHello, Welcome Player 'Hero'");

        while(play){
            if(hHealth >= 0){
                int re = msg.console();     // give options to choose from
                if(re == 1){
                    stepCount += 1; 
                    msg.step(hHealth, stepCount); //take step
                    if(stepCount % 10 == 0)
                        level+=1;
                    int randGoblin = randGoblin();
                    if(randGoblin == 5 || randGoblin == 1){     //check if theres a goblin
                        hHealth = fight(hHealth, gHealth, hero.getDefense(), goblin.getDefense(), hero.getAttackPower(), goblin.getAttackPower());
                        if(hHealth > 0){
                            System.out.println("You beat the goblin! Reward: 2 gold points");
                            System.out.println("health update: " + hHealth);
                            gold += 2;
                            System.out.println("Gold update: " + gold);
                            slain += 1;
                            goblin.setGvals(); 
                        }
                        else{
                            play = msg.playing();
                            if(play == true){
                             //set up new goblin and hero
                                hero.setHvals(gold);
                                goblin.setGvals();
                                potions = hero.getPotions();
                                stepCount = 0;
                                hHealth = hero.getHealthPoints();
                            }
                            else
                                break;
                        }
                    } 
                }
                else if(re == 2 ){
                    if(stepCount % 10 == 0 &&  gold >= 4 && potions[4] == 0){
                            for(int i = 0; i < potions.length; i++){
                                if(potions[i]==0){
                                    potions[i] = 2;
                                    System.out.println("\nVISITED - Gained one Potion");
                                    break;
                                }
                            }
                   }
                    else
                        System.out.println("\nSorry, you can either \n1.only visit every other 10th step, \n2.Dont have enough gold yet \n3.Or your potion slots are currently full \nTry A Different Option");
                }
                else if(re == 3){
                    if(potions[0] == 2 && hHealth < hero.getHealthPoints() - 1){
                        for(int i = potions.length - 1 ; i >= 0; i--){
                                if(potions[i]==2){
                                    hHealth+= 2;
                                    potions[i] = 0;
                                    msg.drinking(hHealth);
                                    break;
                                }
                        }
                    }
                    else if(hHealth == hero.getHealthPoints())
                        System.out.println("\n**Health is at max number already");
                    else
                        System.out.println("No potions left, try a different option.");
                }
                else
                    msg.invalid();
            }
        }
        msg.exit(level, slain);
    }
 
    public static int randGoblin(){
        return new Random().nextInt((5-1) + 1) + 1; 
    }

    public static int fight(int hHealth, int gHealth, int hDefense, int gDefense, int hAttack, int gAttack){
        System.out.println("\nOh no! You've encounter a goblin! \nTheres no other choice but to fight!");
        System.out.println();
        boolean p, pass = true;
        if(hDefense >= gDefense)
            p = true;
        else
            p = false;
        while(pass){
            if(hHealth <= 0 || gHealth <= 0)
                pass = false;
            else if(p == true){
                    gHealth = gHealth - hAttack;
                    p = false;
            }
            else{
                hHealth = hHealth - gAttack;
                p = true;
            }
        }
        return hHealth;
    }
}