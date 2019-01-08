import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> collection;

    public Borrower(String name) {
        this.name = name;
        this.collection = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public int bookCount() {
        return this.collection.size();
    }


    public void addBook(Book book1) {
        this.collection.add(book1);
    }

    public Book removeBook() {
        return this.collection.remove(0);
    }

    public void rentBookFromLibrary(Library library) {
        this.addBook(library.removeBook());
    }

    public void returnBookToLibrary(Library library) {
        if (!library.atCapacity()) {
            library.addBook(this.removeBook());
        }
    }
}
