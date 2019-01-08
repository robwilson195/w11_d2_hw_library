import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book1;

    @Before
    public void before() {
        book1 = new Book("A Scary Book", "Tim Riggins", "Horror");
    }

    @Test
    public void bookShouldHaveTitleAuthorAndGenre() {
        assertEquals("A Scary Book", book1.getTitle());
        assertEquals("Tim Riggins", book1.getAuthor());
        assertEquals("Horror", book1.getGenre());

    }

}
