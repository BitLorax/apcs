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
public class VincentHsu implements Player
{
    private static String name = "VincentHsu";
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
        double r = Math.random();
        double fif = Math.random();
        if(myMoves.size() == 0) {
            return "r";
        }
        if(myScore == opponentScore) {
            if(r < 0.334) {
                return "r";
            }
            if(r > 0.666) {
                return "p";
            }
            else return "s";
        }
        if(myScore < opponentScore) {
            return mostPlayed(opponentMoves);
        }
        if(myScore > opponentScore) {
            if(fif < 0.5) {
                if(opponentMoves.get(opponentMoves.size()-1) == "r") {
                    return "p";
                }
                if(opponentMoves.get(opponentMoves.size()-1) == "p") {
                    return "s";
                }
                if(opponentMoves.get(opponentMoves.size()-1) == "s") {
                    return "r";
                }
            }
            else {
                                if(opponentMoves.get(opponentMoves.size()-1) == "r") {
                    return "p";
                }
                if(opponentMoves.get(opponentMoves.size()-1) == "p") {
                    return "s";
                }
                if(opponentMoves.get(opponentMoves.size()-1) == "s") {
                    return "r";
                }
            }
        }
        return "p";
    }
    /**
     * Returns the name of the player
     * 
     * @return      the name of the player              
     */
    public String getName()
    {
        return name;
    }
    public String mostPlayed(List <String> opponentMoves) {
        int countR = 0;
        int countP = 0;
        int countS = 0;
        for(int i = 0; i < opponentMoves.size(); i++) {
            if(opponentMoves.get(i) == "r") {
                countR++;
            }
            if(opponentMoves.get(i) == "p") {
                countP++;
            }
            if(opponentMoves.get(i) == "s") {
                countS++;
            }
        }
        if(Math.max(Math.max(countR, countP), countS) == countR) {
            return "p";
        }
        if(Math.max(Math.max(countR, countP), countS) == countP) {
            return "s";
        }
        if(Math.max(Math.max(countR, countP), countS) == countS) {
            return "r";
        }
        return "p";
    }
}

