import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> collection;
    private int capacity;
//    private HashMap<String, Integer> genreSpread;

    public Library(int capacity) {
        this.collection = new ArrayList<>();
        this.capacity = capacity;
    }
    public Library(int capacity, ArrayList<Book> books) {
        this.collection = books;
        this.capacity = capacity;
    }

    public int bookCount() {
        return collection.size();
    }
}
