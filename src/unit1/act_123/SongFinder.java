package unit1.act_123;

import unit1.act_112_113.Song;

public class SongFinder
{
    public static int findTitle(Song[] songs, String target){
        if (songs == null) return -1;
        for (int i = 0; i < songs.length; i++){
            String word = songs[i].getTitle();
            if (word.equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static int getIndexLastDiscount(Song[] songs, double compare){
        if (songs == null) return -1;

        int found = -1;
        for (int i = songs.length - 1; i >=0; i--) {
            if (songs[i].getPrice() < compare) {
                found = i;
            }
        }
        return found;
    }
    public static int getIndexLastTitle(Song[] songs)
    {
        int i;
        if (songs == null) {
            return -1;
        }
        for (i = 0; i < songs.length; i++) {
            if (songs[i].getTitle().equals("")) {
                return -1;
            }
        }
        return i - 1;
    }
}