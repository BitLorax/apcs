package rockPaperScissors;

import java.util.*;
/**
 * This is where the main game will be played
 *
 */
public class Game
{
    private int numRounds;  //Random number 
    private List <Player> players;
    private int score1;
    private int score2;
    private List <String> movesP1;
    private List <String> movesP2;
    private boolean print;
    public int [] scores;
    /**
     * Constructor for objects of class Game
     */
    public Game(List <Player> players, boolean print)
    {
        // initialise instance variables
        this.players = players;
        numRounds = 50; //SET TO 50 FOR TESTING, WILL BE RANDOM 100 - 200
        score1 = score2 = 0;
        this.print = print;
        scores = new int [players.size()];
    }
    
    public void play()
    {
        for(int one = 0; one < players.size() - 1; one++)
        {
            Player pOne = players.get(one);
            for (int two = one + 1; two < players.size(); two++)
            {
                Player pTwo = players.get(two);
              
                int points = 0;
                score1 = 0; 
                score2 = 0;
                
                movesP1 = new ArrayList <String> ();
                movesP2 = new ArrayList <String> ();
                
                if(print)
                    System.out.print("1 2\n");
            
                for (int round = 1; round <= numRounds; round++)
                {
                    points = oneRound(pOne, pTwo, round);
                    
                    if(points < 0)  //ILLEGAL MOVE
                    {
                        if(points == -1)    //PLAYER 1 Illegal
                        {
                            score1 -= 10;
                            score2 += 1;
                        }
                        else if (points == -2)  //PLAYER 2 Illegal
                        {
                            score1 += 1;
                            score2 -= 10;
                        }
                        else                    //BOTH Players Illegal
                        {   
                            score1 -= 10;
                            score2 -= 10;
                        }
                    }
                    else
                    {
                        if(points == 0 || points == 1)
                        {
                            score1 += points;
                            score2 -= points;
                        }
                        else
                        {
                            score1 -= 1;
                            score2 += 1;
                        }
                    }
                   
                }
                
                scores[one] += score1;
                scores[two] += score2;
                
                if(print)
                {
                    System.out.println(pOne.getName() + ": " + score1);
                    System.out.println(pTwo.getName() + ": " + score2);
                }
            }
        }
    }
    
    public void displayScore()
    {
        for(int i = 0; i < scores.length; i++)
        {
            System.out.println(players.get(i).getName() + ": " + scores[i]);
        }
    }
    
    private int oneRound(Player one, Player two, int round)
    {
        String move1 = one.move(movesP1, movesP2, score1, score2);
        String move2 = two.move(movesP2, movesP1, score2, score1);
        int illegal = 0;
        
        //CHECK THAT AN INVALID CHARACTER IS NOT ENTERED
        if(move1 != null && (move1.equals("r") || move1.equals("p") || move1.equals("s")))
        {
        }
        else
            illegal -= 1;
        if(move2 != null && (move2.equals("r") || move2.equals("p") || move2.equals("s")))
        {
        }
        else
            illegal -= 2;
            
        if(illegal < 0)
            return illegal;
            
        movesP1.add(move1);
        movesP2.add(move2);
        
        String move = move1 + move2;
        
        if(print)
            System.out.println(round + ": " + move);
        
        if(move.equals("rr") || move.equals("pp") || move.equals("ss"))
            return 0;
        else if (move.equals("rs") || move.equals("sp") || move.equals("pr"))
            return 1;
        else
            return 2;
    }
   
}
