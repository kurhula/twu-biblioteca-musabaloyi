package com.twu.biblioteca;

import java.io.ByteArrayInputStream;

public class Biblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.welcomeMessage();
        biblioteca.displayListOfMenuOptions();
        biblioteca.getUserChoice();
        biblioteca.getWrongUserChoice();
        biblioteca.displayBooks();
        biblioteca.reserveBooks();
        biblioteca.notifyReservationSuccess();
        biblioteca.notifyReservationFailure();
        biblioteca.viewMembershipDetails();
    }

    public void welcomeMessage()
    {
        System.out.println("Welcome to Bangalore Public Library");
    }

    public void displayListOfMenuOptions() {
        System.out.println("1. Option One. \n2. Option Two. \n3. Option Three.\n>>");
    }

    public char selectFirstMenuOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        return (char) in.read();
    }

    public char getUserChoice() {
        String choice = Integer.toString(1 + (int) (Math.random() * 3));
        ByteArrayInputStream in = new ByteArrayInputStream(choice.getBytes());
        return (char) in.read();
    }

    public char getWrongUserChoice() {
        String choice = Integer.toString(4 + (int) (Math.random() * 3));
        ByteArrayInputStream in = new ByteArrayInputStream(choice.getBytes());
        return (char) in.read();
    }

    public void displayBooks() {
        System.out.print("1. Title of first book.\n2. Title of second book.\n...\nn. Title of nth book.\n");
    }

    public boolean reserveBooks() {
        boolean reserved = false;

        int choice = 1 + (int) (Math.random() * 3);
        if (0 < choice && choice < 4 ) {
            reserved = true;
        }

        return reserved;
    }

    public void notifyReservationSuccess() {
        System.out.print("Thank You! Enjoy the book.");
    }

    public void notifyReservationFailure() {
        System.out.print("Sorry we don't have that book yet.");
    }

    public void viewMembershipDetails() {
        System.out.print("Please talk to a Librarian. Thank you.");
    }
}