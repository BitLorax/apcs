package rockPaperScissors;

import java.util.*;
/**
 * Example1 Player will ALWAYS play rock
 */
public class Example1 implements Player
{
    private static String name = "Example1";
    private static String teamNames = "Sos1";
    private static String strategy = "Always rock";
    
    public String move(List <String> myMoves, List <String> opponentMoves, int myScore, int opponentScore)
    {
        
        return "r";
    }
    
    public String getName()
    {
        return name;
    }
}

