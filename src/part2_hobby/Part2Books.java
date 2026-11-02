package part2_hobby;
import java.util.Scanner;
public class Part2Books {
    // one scanner for the whole program
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Part 2.2 Main with user dialogue
        BookCollection collection = new BookCollection();
        int choice = -1;

        System.out.println("Welcome to the book database!");

        // show the menu again and again until user types 0
        while (choice != 0) {
            System.out.println();
            System.out.println("Choose an option to proceed:");
            System.out.println("1 - add books to collection");
            System.out.println("2 - print all books");
            System.out.println("3 - sort books by year");
            System.out.println("4 - search books");
            System.out.println("0 - exit the program");

            choice = readInt("Your choice: ");

            if (choice == 1) {
                inputItems(collection);
            } else if (choice == 2) {
                collection.print();
            } else if (choice == 3) {
                sort(collection);
            } else if (choice == 4) {
                search(collection);
            } else if (choice == 0) {
                System.out.println("Bye!");
            } else {
                System.out.println("Wrong option, please try again.");
            }
        }
    }
    // user types new books until he wants to stop
    public static void inputItems(BookCollection collection) {
        String answer = "y";
        while (answer.equals("y")) {
            System.out.print("Enter the title: ");
            String title = scanner.nextLine();
            System.out.print("Enter the author: ");
            String author = scanner.nextLine();
            int year = readInt("Enter the year: ");
            // create the book and put it into the collection
            collection.add(new Book(title, author, year));
            System.out.println("Book was added!");
            // user can stop here
            System.out.print("Do you want to add one more book? (y/n): ");
            answer = scanner.nextLine();
        }
    }
    // user picks how to search
    public static void search(BookCollection collection) {
        System.out.println("1 - search by title");
        System.out.println("2 - search by year");
        System.out.println("3 - search by author and year");
        int option = readInt("Your choice: ");
        if (option == 1) {
            System.out.print("Enter the title or a part of it: ");
            String title = scanner.nextLine();
            collection.find(title);
        } else if (option == 2) {
            int year = readInt("Enter the year: ");
            collection.findByYear(year);
        } else if (option == 3) {
            System.out.print("Enter the author: ");
            String author = scanner.nextLine();
            int year = readInt("Enter the year: ");
            collection.findByAuthorAndYear(author, year);
        } else {
            System.out.println("Wrong option.");
        }
    }
    // sorts the books and shows the result
    public static void sort(BookCollection collection) {
        collection.sort();
        System.out.println("Books sorted by year:");
        collection.print();
    }
    // reads a number from the user, asks again if it is not a number
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("That is not a number, try again.");
            }
        }
    }
}