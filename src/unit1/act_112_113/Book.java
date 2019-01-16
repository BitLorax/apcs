package unit1.act_112_113;

public class Book
{
    private int rating;
    private String title;
    private String author;
    public Book() {
        rating = 0;
        title = "";
        author = "";
    }
    public Book(String t, String a) {
        rating = 0;
        title = t;
        author = a;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String t) {
        title = t;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor (String u) {
        author = u;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int r) {
        rating = r;
    }

    public void print() {
        System.out.println("\"" + title + "\" by " + author);
    }
}
