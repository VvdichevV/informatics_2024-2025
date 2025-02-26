import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Harry Potter", "J.K. Rowling", 1997),
                new Book("Atomic Habits", "James Clear", 2018),
                new Book("The Alchemist", "Paulo Coelho", 1988),
                new Book("The Da Vinci Code", "Dan Brown", 2003),
                new Book("Percy Jackson", "Rick Riordan", 2005),
        };
        Scanner sc = new Scanner(System.in);
        char option;
        System.out.println("Welcome to the Library Management System!");
        do {
            System.out.print("Enter 'd' to display the library, 'b' to borrow a book, 'r' to return a book, 'f' to find a book, and 'q' to quit: ");
            option = sc.next().charAt(0);
            switch (option) {
                case 'd':
                    displayLibrary(books);
                    break;
                case 'b':
                    System.out.print("Enter the book you wish to borrow: ");
                    sc.nextLine();
                    String searchTitle = sc.nextLine();
                    System.out.print("Enter your name: ");
                    String borrowerName = sc.nextLine();
                    borrowBook(books, borrowerName, searchTitle);
                    break;
                case 'r':
                    System.out.print("Enter the book you wish to return: ");
                    sc.nextLine();
                    String searchTitle2 = sc.nextLine();
                    returnBook(books, searchTitle2);
                    break;
                case 'f':
                    System.out.print("Enter the book you wish to find: ");
                    sc.nextLine();
                    String searchTitle3 = sc.nextLine();
                    findBookByTitle(books, searchTitle3);
                    break;
                case 'q':
                    System.out.println("Thank you for visiting the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid option. Try again!");
                    break;
            }

        } while (option != 'q');

    }

    public static void displayLibrary(Book[] books) {
        for (Book book : books) {
            book.getDetails();
        }

    }

    public static void borrowBook(Book[] books, String borrowerName, String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                if (book.getBorrowerName().equalsIgnoreCase("No borrower")) {
                    System.out.println("You have borrowed the book successfully!");
                    book.borrowBook(borrowerName);
                } else {
                    System.out.println("Unfortunately, the book is already borrowed! Come back later!");
                }
                return;
            }
        }
        System.out.println("We don't have the book you're looking for. Sorry!");
    }

    public static void returnBook(Book[] books, String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("The book has successfully been returned!");
                book.returnBook();
                return;
            }
        }
        System.out.println("We don't have that book in our catalogue. Sorry!");
    }

    public static void findBookByTitle(Book[] books, String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                book.getDetails();
                return;
            }
        }
        System.out.println("We don't have the book you're looking for. Sorry!");
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;
    private String borrowerName;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowerName = "No borrower";
    }

    public void getDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year Published: " + yearPublished + ", Borrower Name: " + borrowerName);
    }

    public void updateBookInfo(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void borrowBook(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void returnBook() {
        borrowerName = "No borrower";
    }

    public String getTitle() {
        return title;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
}