package unit1.act_123;

import unit1.act_112_113.Song;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Algorithms {
    void findBest(Song[] songs) {
        int best = 0, worst = Integer.MAX_VALUE;
        int bestIndex = -1, worstIndex = -1;
        for (int i = 0; i < songs.length; i++) {
            Song s = songs[i];
            if (s.getRating() > best) {
                best = s.getRating();
                bestIndex = i;
            }
            if (s.getRating() < worst) {
                worst = s.getRating();
                worstIndex = i;
            }
        }
        System.out.println(best);
        System.out.println(songs[bestIndex].getTitle());
        System.out.println(worst);
        System.out.println(songs[worstIndex].getTitle());
    }
    void findMatches(Song[] songs) {
        Arrays.sort(songs);
        int best = songs[songs.length - 1].getRating();
        String matches = "";
        for (int i = songs.length - 1; i >= 0; i--) {

        }
    }
}
