 // lab02_Q1.java
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String category;

    // Constructor
    public Book(String title, String author, String isbn, double price, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author +
               ", ISBN: " + isbn + ", Price: " + price +
               ", Category: " + category;
    }
}


public class lab02_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Create an array of 8 Book objects, initialized with null
        Book[] books = new Book[8];
        for (int i = 0; i < books.length; i++) {
            books[i] = null;
        }

        // b. Update objects in the array (hardcoding some values)
        books[0] = new Book("The Alchemist", "Paulo Coelho", "ISBN001", 350, "Fiction");
        books[1] = new Book("Sapiens", "Yuval Noah Harari", "ISBN002", 500, "History");
        books[2] = new Book("1984", "George Orwell", "ISBN003", 300, "Fiction");
        books[3] = new Book("Animal Farm", "George Orwell", "ISBN004", 250, "Satire");
        books[4] = new Book("Wings of Fire", "A.P.J. Abdul Kalam", "ISBN005", 400, "Autobiography");
        books[5] = new Book("Harry Potter", "J.K. Rowling", "ISBN006", 600, "Fantasy");
        books[6] = new Book("Becoming", "Michelle Obama", "ISBN007", 550, "Autobiography");
        books[7] = new Book("Ikigai", "Francesc Miralles", "ISBN008", 450, "Self-help");

        // c. Input author name → list all titles by that author
        System.out.print("\nEnter author name: ");
        String searchAuthor = sc.nextLine();
        System.out.println("Books by " + searchAuthor + ":");
        boolean found = false;
        for (Book b : books) {
            if (b != null && b.getAuthor().equalsIgnoreCase(searchAuthor)) {
                System.out.println("- " + b.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }

        // d. Input category → list all titles in that category
        System.out.print("\nEnter category: ");
        String searchCategory = sc.nextLine();
        System.out.println("Books in category '" + searchCategory + "':");
        found = false;
        for (Book b : books) {
            if (b != null && b.getCategory().equalsIgnoreCase(searchCategory)) {
                System.out.println("- " + b.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found in this category.");
        }

        // e. Input price → list all titles with price <= input
        System.out.print("\nEnter maximum price: ");
        double maxPrice = sc.nextDouble();
        System.out.println("Books priced <= " + maxPrice + ":");
        found = false;
        for (Book b : books) {
            if (b != null && b.getPrice() <= maxPrice) {
                System.out.println("- " + b.getTitle() + " (" + b.getPrice() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found within this price range.");
        }

        // f. Null vs primitive data type
        // Objects like String can be null
        String str = null; // valid
        // int x = null;   // ❌ invalid, compilation error (primitive types cannot be null)

        sc.close();
    }
}

