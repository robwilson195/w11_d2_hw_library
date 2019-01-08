import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Library library1;
    private Library library2;

    @Before
    public void before() {
        book1 = new Book("A Scary Book", "Tim Riggins", "Horror");
        book2 = new Book("About Me", "Donald Trump", "Biography");
        book3 = new Book("Indian Food", "Jamie Richardson", "Cooking");
        book4 = new Book("A Scarier Book", "Steve Rogers", "Horror");

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book3);
        books.add(book4);

        library1 = new Library(2);
        library2 = new Library(4, books);
    }

    @Test
    public void canStartEmpty() {
        assertEquals(0, library1.bookCount());
    }

}
