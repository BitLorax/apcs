package unit1.act_121;

import unit1.act_122.MediaFile;

public class Form121 {
    public static void main(String[] args) {
        int songNum = 0;
        int minWord = 2000000000;
        int maxWord = 0;
        double yearAvg = 0;
        outer: while (true) {
            for (int i = 0; i < 4; i++) {
                String in = MediaFile.readString();
                if (in == null) break outer;
                if (i == 2) yearAvg += Integer.parseInt(in);
                if (i == 3) {
                    int wordCount = Integer.parseInt(in);
                    minWord = Math.min(minWord, wordCount);
                    maxWord = Math.max(maxWord, wordCount);
                }
            }
            songNum++;
        }
        System.out.println("songNum: " + songNum);
        System.out.println("yearAvg: " + (yearAvg / songNum));
        System.out.println("max: " + maxWord);
        System.out.println("min: " + minWord);
    }

}
