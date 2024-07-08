package multi.parallel;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private Books() {
    }

    public static List<Book> randomBooks(int number) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            books.add(new Book("Title number " + i, "Author number " + i, i));
        }
        return books;
    }
}
