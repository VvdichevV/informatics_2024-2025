public class library {
    public static void main(String[] args) {
        Book romance = new Book("The Love Hypothesis", "Ali Hazelwood", 376);
        Book crime_thriller = new Book("In Cold Blood", "Truman Capote", 343);
        romance.displayDetails();
        crime_thriller.displayDetails();
        // Task 4: Create two or more Book objects with different attributes.
        // Task 5: Call the displayDetails method for each object.
    }
}

// Define the Book class
class Book {
    private String title;
    private String author;
    private int numberOfPages;
    // Task 1: Add three attributes: title, author, and numberOfPages.

    // Constructor
    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        // Task 2: Initialize the attributes inside this constructor.
    }
    void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numberOfPages);
    }
    // Task 3: Add a method displayDetails() to print the book's details (title, author, and numberOfPages).
}