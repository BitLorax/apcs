package unit1.act_112_113;

import unit1.act_122.MediaFile;

import java.util.ArrayList;

public class MediaLib {
    public static void main(String[] args) {
        Book bok = new Book("Bok", "Geg");
        Book gog = new Book("Gog", "Bin");
        Book[] books = {bok, gog};
        for (Book a : books) write(a);
        MediaFile.saveAndClose();

        ArrayList<Book> readBooks = new ArrayList<>();
        String currLine = MediaFile.readString();
        while (currLine != null) {
            readBooks.add(new Book(currLine.substring(0, currLine.indexOf("|")), currLine.substring(currLine.indexOf("|") + 1)));
            currLine = MediaFile.readString();
        }
        for (Book a : readBooks) a.print();
    }
    private static void write(Book a) {
        MediaFile.writeString(a.getTitle() + "|" + a.getAuthor());
    }
}
