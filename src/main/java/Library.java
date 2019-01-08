import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> collection;
    private int capacity;
    private HashMap<String, Integer> genreSpread;

    public Library(int capacity) {
        this.collection = new ArrayList<>();
        this.capacity = capacity;
        this.genreSpread = new HashMap<>();
    }
    public Library(int capacity, ArrayList<Book> books) {
        this.collection = books;
        this.capacity = capacity;
        this.genreSpread = new HashMap<>();
        populateGenreSpread();
    }

    public int bookCount() {
        return collection.size();
    }

    public boolean atCapacity () {
        return this.collection.size() >= this.capacity;
    }

    public void addBook(Book book1) {
        if (!atCapacity()) {
            this.collection.add(book1);
            populateGenreSpread();
        }
    }

    public Book removeBook() {
        Book book =  this.collection.remove(0);
        populateGenreSpread();
        return book;
    }

    public void populateGenreSpread() {
        this.genreSpread = new HashMap<>();
        for (Book book : this.collection) {
            if (genreSpread.containsKey(book.getGenre())) {
                int newTotal = genreSpread.get(book.getGenre()) +1;
                genreSpread.replace(book.getGenre(), newTotal);
            } else {
                this.genreSpread.put(book.getGenre(), 1);
            }
        }
    }

    public HashMap<String, Integer> getGenreSpread() {
        return this.genreSpread;
    }
}
