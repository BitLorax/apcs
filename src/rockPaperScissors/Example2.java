package rockPaperScissors;

import java.util.*;
/**
 * Example1 Player will first play rock, then all scissors
 */
public class Example2 implements Player
{
    private static String name = "Example2";
    private static String teamNames = "Sos1";
    private static String strategy = "Rock then all scissors";

    public String move(List <String> myMoves, List <String> opponentMoves, int myScore, int opponentScore)
    {
        if (myScore > opponentScore) return "r";
        if (myScore < opponentScore) return "p";
        return "s";
    }

    public String getName()
    {
        return name;
    }
}
