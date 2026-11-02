package part2_hobby;
// Part 2.1 Book class (my hobby item)
public class Book {
    private String title;
    private String author;
    private int year; // numeric property
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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
    // shows all info about the book
    public void printInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year);
    }
}