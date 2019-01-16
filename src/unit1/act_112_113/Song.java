package unit1.act_112_113;

/**
 * Write a description of class Song here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Song implements Comparable<Song>
{
    // instance variables - replace the example below with your own
    private int rating;
    private String title;
    private String artist;
    private double price;
    private boolean favorite;
    private int days;
    /**
     * Constructor for objects of class Song
     */
    public Song()
    {
        // initialise instance variables
        rating = 0;
        title = "";
        artist = "";
        price = 0.0;
        favorite = false;
        days = 0;
    }
    public Song(String title) {
        this.title = title;
    }
    public Song(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
    public Song(String title, double price, int rating) {
        this.title = title;
        this.price = price;
        this.rating = rating;
    }
    public int compareTo(Song a) {
        return a.getRating() - this.rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String a) {
        artist = a;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int r) {
        rating = r;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    public void addToFavorites() {
        favorite = true;
    }

    public void setFavorite(boolean f) {
        favorite = f;    
    }  

    public void setDays(int d) {
        days = d;
    }

    public void printDays () {
        System.out.println("This song is " + (days / 365) + " Years " + ((days % 365)/21
            ) + " Months " + ((days % 365)%30) + " Days Old");
    }
}
