package Day3;

class Library {
    String book1;
    String book2;

    // Add two books
    void addBook(String b1, String b2) {
        book1 = b1;
        book2 = b2;
        System.out.println("Books added: " + book1 + ", " + book2);
    }

    // Issue a book
    void issueBook(String bookName) {
        if (bookName.equals(book1) || bookName.equals(book2)) {
            System.out.println(bookName + " has been issued.");
        } else {
            System.out.println(bookName + " is not available.");
        }
    }

    // Remove a book
    void removeBook(String bookName) {
        if (bookName.equals(book1)) {
            book1 = null;
            System.out.println(bookName + " removed.");
        } else if (bookName.equals(book2)) {
            book2 = null;
            System.out.println(bookName + " removed.");
        } else {
            System.out.println(bookName + " not found.");
        }
    }

    // Show books
    void showBooks() {
        System.out.println("Available books:");
        if (book1 != null) System.out.println(book1);
        if (book2 != null) System.out.println(book2);
    }
}

// Main class
public class Libraryclass {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook("Harry Potter", "Java Basics");

        lib.showBooks();

        lib.issueBook("Harry Potter");

        lib.removeBook("Java Basics");

        lib.showBooks();
    }
}

