package rockPaperScissors;

import java.util.*;
/**
 * Each player or team will create their own Player, this is only an example....
 * 
 * Your code MUST INCLUDE a move method with the following signature. To insure that, you must implement
 * the Player interface
 * 
 * You can create additional methods but must have the move method
 * 
 */
public class ZhaiDaniel implements Player
{
    private static String name = "ZhaiDaniel";
    /**
     * An example of a method - replace this comment with your own
     * You must create some kind of logic of what to play against your opponent...start researching,
     * driver code to be provided MONDAY, 2/27
     * 
     * @return      the move you want to play against opponent
     *              "r" - rock
     *              "p" - paper
     *              "s" - scissors
     *              anything else - forfeit the turn
     */
    public String move(List <String> myMoves, List <String> opponentMoves, int myScore, int opponentScore)
    {
        int q = 0;
        if(q == 0) {
            q--;
            return "r";
        }
        if (opponentMoves.get(opponentMoves.size() - 1) == "r")
            return "p";
        else if (opponentMoves.get(opponentMoves.size() - 1) == "s")
            return "r";
        else if (opponentMoves.get(opponentMoves.size() - 1) == "p")
            return "s";
        return "r";
    }
    
    /**
     * Returns the name of the player
     * 
     * @return the name of the player              
     */
    public String getName()
    {
        return name;
    }
}

