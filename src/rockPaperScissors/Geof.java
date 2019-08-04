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
public class Geof implements Player
{
    private static String name = "Geoffrey X.";
    private static String strategy = "idk";
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
        String currentChoice = "";
        if (myMoves.size() > 1 && !didILose(myMoves.get(myMoves.size()-1), opponentMoves.get(opponentMoves.size()-1))) {
            currentChoice = myMoves.get(myMoves.size()-1);
        }
        double chooser = Math.random() *3;
        if (chooser < 1) {
            currentChoice = "r";
        }
        else if (chooser < 2) {
            currentChoice = "p";
        }
        else {
            currentChoice = "s";
        }
        if (opponentMoves.size() >= 5) {
            int rCount = 0; 
            int pCount = 0;
            int sCount = 0;
            for (int i = opponentMoves.size()-3; i < opponentMoves.size(); i++) {
                 if (opponentMoves.get(i) == "r") {
                     rCount++;
                 }
                 if (opponentMoves.get(i) == "p") {
                     pCount++;
                 }
                 if (opponentMoves.get(i) == "s") {
                     sCount++;
                 }
            }
            if (rCount == 3) {
                return "p";
            }
            if (sCount == 3) {
                return "r";
            }
            if (pCount == 3) {
                return "s";
            }
            if (rCount == sCount && sCount == pCount) {
                if (opponentMoves.get(opponentMoves.size()-3) == "s") {
                    return "r";
                }
                else if (opponentMoves.get(opponentMoves.size()-3) == "p") {
                    return "s";
                }
                else {
                    return "p";
                }
            }
        }
        return currentChoice;
    }
    public boolean didILose(String me, String them) {
        if (me == "s" && them == "r") {
            return true;
        }
        else if (me == "r" && them == "p") {
            return true;
        }
        else if (me == "p" && them == "s") {
            return true;
        }
        else {
            return false;
        }
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
}

