package unit1.act_122;

import unit1.act_112_113.Song;
import unit1.act_123.SongFinder;

public class ArrayMediaLib {
    public static void main(String[] args) {
        String sharingFriends[] = {"Vincent", "Greg", "Danny", "Neal", "Bincent"};
        for (int i = 0; i < sharingFriends.length; i++) System.out.println(sharingFriends[i]);

        int daysBtwnPurchase[] = {2, 5, 1, 2, 4, 2, 1, 3};
        int total = 0;
        for (int a : daysBtwnPurchase) total += a;
        System.out.println(total / daysBtwnPurchase.length);

        Song topTenSongs[] = {new Song("The Twist", 1),
                new Song("Smooth", 3),
                new Song("Mack the Knife", 5),
                new Song("How Do I Live", 2),
                new Song("Party Rock Anthem", 8),
                new Song("I Gotta Feeling", 7),
                new Song("Macarena", 5),
                new Song("Physical", 8),
                new Song("You Light Up My Life", 9),
                new Song("Hey Jude", 2)};
        for (Song s : topTenSongs) System.out.println(s.getTitle());

        for (Song s : topTenSongs) s.setPrice(1.29);
        for (int i = 0; i < topTenSongs.length; i+= 3) topTenSongs[i].setPrice(.99);
        for (Song s : topTenSongs) {
            System.out.println(s.getTitle() + " with a price of " + s.getPrice());
        }

        for (int i = 0; i < topTenSongs.length; i+= 2) System.out.println(topTenSongs[i].getTitle());
        int l = 0;
        for (Song s : topTenSongs) if (l++ % 2 == 0) System.out.println(s.getTitle());

        int index = SongFinder.findTitle(topTenSongs, "Mack the Knife");
        if (index >= 0) System.out.println("Found " + topTenSongs[index].getTitle());
        else System.out.println("Song not found");

        System.out.println(SongFinder.getIndexLastTitle(topTenSongs));
    }
}
