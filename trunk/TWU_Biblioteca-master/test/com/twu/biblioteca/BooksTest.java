package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    books.add("Lord of the Rings: The Fellowship of the Ring.");
    books.add("Lord of the Rings: The Two Towers.");
    books.add("Lord of the Rings: The Return of the King.");
 */

public class BooksTest {

    @Test
    public void shouldSayIfBookIsAvailable()
    {
        Books books = new Books();
        //books.addBook(2, "Lord of the Rings: The Fellowship of the Ring.");
        books.removeBook(2, "Lord of the Rings: The Fellowship of the Ring.");
        assertEquals(false, books.isAvailable(2));
    }

}
