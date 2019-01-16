package unit1.act_112_113;

/**
 * Write a description of class Movie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private double duration;
    private String title;
    /**
     * Constructor for objects of class Movie
     */
    public Movie()
    {
        // initialise instance variables
        duration = 0.0;
        title = "";
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String t) {
        title = t;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double d) {
        duration = d;
    }
}
