package rockPaperScissors;

import java.util.*;

public class Sos implements Player
{
    private static String name = "Sos";
    private static String strategy = "50 rocks, 50 papers, 50 scissors";

    public String move(List <String> myMoves, List <String> opponentMoves, int myScore, int opponentScore)
    {
        if(myMoves.size() < 50)
        {
            return "r";
        }
        else if (myMoves.size() < 100)
        {
            return "p";
        }
        else
        {
            return "s";
        }
    }

    public String getName()
    {
        return name;
    }
}
