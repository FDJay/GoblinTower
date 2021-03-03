package goblintower.mvc;

import goblintower.mvc.controller.Game;
import goblintower.mvc.model.Player;
import goblintower.mvc.model.Goblin;
//DUWINE FLORES

public class Main{
    static int gold = 0;
    public static void main(String[] args){

        Player hero = new Player();
        hero.setHvals(gold);

        Goblin goblin = new Goblin();
        goblin.setGvals();

        Game newGame = new Game();
        newGame.start(hero, goblin);
    }
}
