package completable.homework;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int year;
    private String signature;

    public Book() {
        this.title = "Are women human?";
        this.author = "John Doe";
        this.year = 2005;
        this.signature = "";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(signature, book.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, signature);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", signature='" + signature + '\'' +
                '}';
    }
}
