import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private Library library1;
    private Library library2;
    private Borrower person1;

    @Before
    public void before() {
        book1 = new Book("A Scary Book", "Tim Riggins", "Horror");
        book2 = new Book("About Me", "Donald Trump", "Biography");
        book3 = new Book("Indian Food", "Jamie Richardson", "Cooking");
        book4 = new Book("A Scarier Book", "Steve Rogers", "Horror");
        book5 = new Book("The Scariest Book", "Steve Rogers", "Horror");
        book6 = new Book("Space", "Ronald McDonald", "Science");


        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book3);
        books.add(book4);

        library1 = new Library(2);
        library2 = new Library(4, books);

        person1 = new Borrower("Steve");
    }

    @Test
    public void hasName() {
        assertEquals("Steve", person1.getName());
    }

    @Test
    public void startsWithEmptyCollection() {
        assertEquals(0, person1.bookCount());
    }

    @Test
    public void canAddBook() {
        person1.addBook(book1);
        assertEquals(1, person1.bookCount());
    }

    @Test
    public void canRemoveBook() {
        person1.addBook(book2);
        assertEquals(1, person1.bookCount());
        person1.removeBook();
        assertEquals(0, person1.bookCount());
    }

    @Test
    public void canRentBookFromLibrary() {
        person1.rentBookFromLibrary(library2);
        assertEquals(1, person1.bookCount());
        assertEquals(2, library2.bookCount());
    }

    @Test
    public void canReturnBookToLibrary() {
        person1.rentBookFromLibrary(library2);
        person1.returnBookToLibrary(library2);
        assertEquals(0, person1.bookCount());
        assertEquals(3, library2.bookCount());

    }

    @Test
    public void wontReturnBookToLibraryAtCapacity() {
        person1.rentBookFromLibrary(library2);
        assertEquals(1, person1.bookCount());
        assertEquals(2, library2.bookCount());
        library1.addBook(book5);
        library1.addBook(book6);
        person1.returnBookToLibrary(library1);
        assertEquals(1, person1.bookCount());
        assertEquals(2, library1.bookCount());

    }

}
