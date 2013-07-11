package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void before(){
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void shouldSeeWelcomeMessage()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.welcomeMessage();
        assertEquals("Welcome to Bangalore Public Library\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldSeeMenuOptions()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.displayListOfMenuOptions();
        assertEquals("1. Option One. \n2. Option Two. \n3. Option Three.\n>>\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldSelectFirstMenuOption()
    {
        Biblioteca biblioteca = new Biblioteca();
        assertEquals('1',biblioteca.selectFirstMenuOption());
    }

    @Test
    public void shouldCheckIfSelectedOptionExists()
    {
        Biblioteca biblioteca = new Biblioteca();
        int userChoice = (int) biblioteca.getUserChoice();
        assertTrue("Select a valid option!!", 1 < userChoice || userChoice > 3);
    }

    @Test
    public void userChoiceShouldFail()
    {
        Biblioteca biblioteca = new Biblioteca();
        int userChoice = (int) biblioteca.getUserChoice();
        assertTrue("Select an invalid option!!", 3 < userChoice || userChoice > 6);
    }

    @Test
    public void shouldDisplayBooks()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.displayBooks();
        assertEquals("1. Title of first book.\n2. Title of second book.\n...\nn. Title of nth book.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReserveBook()
    {
        Biblioteca biblioteca = new Biblioteca();
        assert biblioteca.reserveBooks();
    }

    @Test
    public void shouldNotifyReservationSuccess()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.notifyReservationSuccess();
        assertEquals("Thank You! Enjoy the book.", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotifyReservationFailure()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.notifyReservationFailure();
        assertEquals("Sorry we don't have that book yet.", byteArrayOutputStream.toString());

    }

    @Test
    public void shouldBeAbleToViewMembershipDetails()
    {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.viewMembershipDetails();
        assertEquals("Please talk to a Librarian. Thank you.", byteArrayOutputStream.toString());

    }
}