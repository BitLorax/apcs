package rockPaperScissors;

import java.util.*;
/**
 * Write a description of interface Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Player
{
    public String move(List <String> myMoves, List <String> opponentMoves, int myScore, int opponentScore);
    public String getName();
}
