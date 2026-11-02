package part2_hobby;
// Part 2.1 Collection of books
public class BookCollection {
    // array where we keep the books
    private Book[] books = new Book[100];
    // how many books we have now
    private int count = 0;
    // adds a new book to the end of the array
    public void add(Book newBook) {
        if (count < books.length) {
            books[count] = newBook;
            count++;
        } else {
            System.out.println("Sorry, the collection is full.");
        }
    }
    // prints one book by its index
    public void printOne(int i) {
        if (i >= 0 && i < count) {
            System.out.print((i + 1) + ". ");
            books[i].printInfo();
        } else {
            System.out.println("There is no book with this number.");
        }
    }
    // prints all books
    public void print() {
        if (count == 0) {
            System.out.println("The collection is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            printOne(i);
        }
    }
    // Part 2.1.5 search by title (part of the title is ok, big and small letters don't matter)
    public void find(String s) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            String title = books[i].getTitle().toLowerCase();
            if (title.contains(s.toLowerCase())) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing was found.");
        }
    }
    // Part 2.1.6 bubble sort by year, oldest book goes first
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                // if the left book is newer, swap them
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }
    // Part 2.1.7 search by year
    public void findByYear(int year) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getYear() == year) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing was found.");
        }
    }
    // Part 2.1.7 search by author and year at the same time
    public void findByAuthorAndYear(String author, int year) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            String bookAuthor = books[i].getAuthor().toLowerCase();
            if (bookAuthor.contains(author.toLowerCase()) && books[i].getYear() == year) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing was found.");
        }
    }
}