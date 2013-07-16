package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldSeeWelcomeMessage()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        Library library = new Library(printStream, null);
        library.welcomeMessage();
        assertEquals("Welcome to Bangalore Public Library\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldSeeMenuOptions()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        Library library = new Library(printStream, null);
        library.displayListOfMenuOptions();
        assertEquals("1. Option One. \n2. Option Two. \n3. Option Three.\n>>\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldCheckIfSelectedOptionExists() throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("2".getBytes());
        Library library = new Library(printStream, new Scanner(byteArrayInputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        library.getUserChoice();
        assertEquals("2", bufferedReader.readLine());
    }

    @Test
    public void shouldDisplayBooks()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        Library library = new Library(printStream, null);
        library.displayBooks();
        assertEquals("1. Title of first book.\n2. Title of second book.\n...\nn. Title of nth book.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReserveBookThatAlreadyExistsInListsOfBooks() throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("2".getBytes());
        Library library = new Library(printStream, new Scanner(byteArrayInputStream));
        library.reserveBookThatAlreadyExistsInListOfBooks();
        assertEquals("Thank You! Enjoy the book.", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReserveBookThatDoesNotExistInListsOfBooks() throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("12".getBytes());
        Library library = new Library(printStream, new Scanner(byteArrayInputStream));
        library.reserveBookThatAlreadyExistsInListOfBooks();
        assertEquals("Sorry we don't have that book yet.", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToViewMembershipDetails()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        Library library = new Library(printStream, null);
        library.viewMembershipDetails();
        assertEquals("Please talk to a Librarian. Thank you.", byteArrayOutputStream.toString());
    }
}