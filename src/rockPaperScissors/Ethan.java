package rockPaperScissors;

import java.util.*;
public class Ethan implements Player
{
    private static String name = "EthanKuo";
    private static String strat = "random until pattern found";
    public String move(List <String> myMoves, List <String> opponentMoves, int myScore, int opponentScore)
    {
        if(myMoves.size() > 1){
            String prediction = this.checkPatterns(opponentMoves);
            if(prediction.equals("r")) return "p";
            if(prediction.equals("p")) return "s";
            if(prediction.equals("s")) return "r";
            int random = (int)(Math.random()*3);
            if(random == 0) prediction = "r";
            if(random == 1) prediction = "p";
            if(random == 2) prediction = "s";
            return prediction;
        }
        return "p";
    }

    public String checkPatterns(List <String> opponentMoves){
        int lastInd = opponentMoves.size()-1;
        String prediction = "";
        for(int i = lastInd-1; i >= 0; i--){
            if(opponentMoves.get(lastInd).equals(opponentMoves.get(i))){
                int betweens = lastInd-i-1;
                for(int k = 1; k <= betweens;){
                    if(i-k >= 0){
                        if(opponentMoves.get(i-k).equals(opponentMoves.get(lastInd-k))){
                            k++;
                            if(k > betweens){
                                prediction = opponentMoves.get(i+1);
                            }
                        }
                        else k = betweens+1;
                    }
                    else k = betweens+1;
                }
                if(i == lastInd-1){
                    int count = 1;
                    int temp = i-1;
                    while(temp >= 0 && opponentMoves.get(temp).equals(opponentMoves.get(i))){
                        count++;
                        temp--;
                    }
                    for(int j = i-count; j >= count; j--){
                        if(opponentMoves.get(i).equals(opponentMoves.get(j))){
                            for(int l = 1; l < count;){
                                if(i-count-l >= 0 && j-count-l >= 0){
                                    if(opponentMoves.get(i-count-l).equals(opponentMoves.get(j-count-l))){
                                        l++;
                                        if(l == count){
                                            int intermediates = i-j-count;
                                            for(int m = 0; m < intermediates;){
                                                if(i-m >= 0){
                                                    if(i-count-m >= 0 && j-count-m >= 0){
                                                        if(opponentMoves.get(i-count-m).equals(opponentMoves.get(j-count-m))){
                                                            m++;
                                                            if(m >= intermediates){
                                                                prediction = opponentMoves.get(j+1);
                                                            }  
                                                        }
                                                        else break;
                                                    }
                                                    else break;
                                                }
                                                else break;
                                            }
                                        }
                                        else break;
                                    }
                                    else break;
                                }
                                else break;
                            }
                        }
                    }
                }
            }
        }
        return prediction;
    }

    public String getName()
    {
        return name;
    }
}

