package rockPaperScissors;

import java.util.List;

public class LiangWill implements Player {
    private static String name = "Will Liang";
    private static String strat = "Counter";

    private String moves[] = {"r", "p", "s"}; //winning move is (oppoIndx + 1) % 3
    private int counters[][] = new int[3][2]; //[rock, paper, scissors][winning or not]
    private String record[] = {"", "", "", ""}; //[myScore > oppoScore, myScore < oppoScore, myScore == oppoScore, all]
    private String prevPat[] = {"", "", "", ""};
    private int prevMyScore = 0, prevOppoScore = 0;

    int counterLastPlay = 0, commonCounterPlay = 0;

    int ll = 0;
    public String move(List<String> myMoves, List <String> opponentMoves, int myScore, int opponentScore) {
        if (opponentMoves.size() == 0) return randPlay();

        //store prev move for analysis
        int k = getIndx(prevMyScore, prevOppoScore);
        record[k] += opponentMoves.get(opponentMoves.size() - 1);
        record[3] += opponentMoves.get(opponentMoves.size() - 1);
        prevMyScore = myScore; prevOppoScore = opponentScore;

        k = getIndx(myScore, prevOppoScore);
        if (record[k].length() == 0) return randPlay();

        //analyze pattern
        String pat = getPat(record[k]);
        if (pat.equals(prevPat[k])) { //pattern confirmed
            return moves[(toInt("" + pat.charAt(opponentMoves.size() % pat.length())) + 1) % 3];
        }
        prevPat[k] = pat;
        pat = getPat(record[3]);
        if (pat.equals(prevPat[3])) { //pattern confirmed
            return moves[(toInt("" + pat.charAt(opponentMoves.size() % pat.length())) + 1) % 3];
        }
        prevPat[3] = pat;

        if (detectCounterLastPlay(myMoves, opponentMoves)) counterLastPlay++;
        if (counterLastPlay > 10) {
            return moves[(toInt(myMoves.get(myMoves.size() - 1)) + 2) % 3];
        }

        if (detectCommonCounterPlay(myMoves, opponentMoves)) commonCounterPlay++;
        if (commonCounterPlay > 10) {
            int count[] = {0, 0, 0};
            for (int i = 0; i < myMoves.size(); i++) {
                count[toInt(myMoves.get(i))]++;
            }
            int max = Math.max(count[0], Math.max(count[1], count[2]));
            if (max == count[0]) return "s";
            if (max == count[1]) return "r";
            if (max == count[2]) return "p";
        }

        return patPlay(myScore, opponentScore);
    }
    private String getPat(String oppo) {
        int ind = 0;
        String cur = "" + oppo.charAt(ind++);
        boolean patFound = false;
        while (!patFound) {
            patFound = true;
            for (int i = 0; i < oppo.length(); i += cur.length()) {
                String window = "";
                for (int j = 0; j < cur.length() && i + j < oppo.length(); j++) window += oppo.charAt(i + j);
                boolean isEqual = true;
                for (int j = 0; j < Math.min(cur.length(), window.length()); j++) {
                    if (cur.charAt(j) != window.charAt(j)) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual) {
                    cur += oppo.charAt(ind++);
                    patFound = false;
                    break;
                }
            }
        }
        return cur;
    }
    private boolean detectCounterLastPlay(List<String> my, List<String> oppo) {
        if (my.size() <= 1 || oppo.size() <= 1) return false;
        return oppo.get(oppo.size() - 1).equals(my.get(my.size() - 2));
    }
    private boolean detectCommonCounterPlay(List<String> my, List<String> oppo) {
        if (my.size() <= 1 || oppo.size() <= 1) return false;
        int count[] = {0, 0, 0};
        for (int i = 0; i < my.size() - 1; i++) {
            count[toInt(my.get(i))]++;
        }
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        int k;
        if (max == count[0]) k = 0;
        else if (max == count[1]) k = 1;
        else k = 2;
        return toInt(oppo.get(oppo.size() - 1)) == (k + 1) % 3;
    }
    private int toInt(String a) {
        switch(a) {
            case "r": return 0;
            case "p": return 1;
            case "s": return 2;
        }
        return -1;
    }
    private String randPlay() {
        return moves[(int)(Math.random() * 3)];
    }
    private int getIndx(int myScore, int oppoScore) {
        if (myScore > oppoScore) return 0;
        if (myScore < oppoScore) return 1;
        return 2;
    }
    private String patPlay(int my, int oppo) {
        if (my > oppo) ll++;
        if (oppo < my - 2) ll+= 2;
        if (my * 2 < oppo) ll++;
        ll %= 3;
        return moves[ll];
    }
    public String getName() {
        return name;
    }
}
