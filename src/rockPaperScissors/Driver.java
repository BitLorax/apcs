package rockPaperScissors;

import java.util.*;
/**
 * Driver class, sets up game
 * 
 * To test your code, add a line like players.add(new ________)
 * of your class
 */
public class Driver
{
    public static void main(String [] args)
    {
        List <Player> players = new ArrayList <Player> ();
        boolean printsRun = false;
        //add players to game
        players.add(new Sos());
        players.add(new LiangWill());
        Game newGame = new Game(players, printsRun);
        newGame.play();
        newGame.displayScore();
        //add players.add(new ______________) for your code
//        int s1 = 0, s2 = 0;
//        for (int i = 0; i < 20; i++) {
//            Game newGame = new Game(players, printsRun);
//            newGame.play();
//            s1 += newGame.scores[0];
//            s2 += newGame.scores[1];
//            System.out.println(s1 + " " + s2);
//        }
    }
}
