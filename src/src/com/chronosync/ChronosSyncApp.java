package com.chronosync;

import com.chronosync.manager.EventManager;
import com.chronosync.model.Event;
import com.chronosync.notifier.EventNotifier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChronosSyncApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        EventNotifier notifier = new EventNotifier(eventManager);
        Thread notifierThread = new Thread(notifier);

        notifierThread.start();

        boolean doesLoopContinue = true;
        int choice;

        while (doesLoopContinue) {
            System.out.println("""
                    === ChronosSync ===
                    
                    1. Add an event
                    2. List all events
                    3. Exit
                    """);

            while (true) {
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Not a valid choice!");
                    scanner.next();
                }
            }

            switch (choice) {
                case 1:
                    String nameForEvent;
                    LocalDate dateForEvent;
                    CharSequence date;
                    Event newEvent;

                    System.out.println("=== Enter a name for your event ===");
                    nameForEvent = scanner.nextLine();

                    System.out.println("=== Enter the date of your event ===");


                    while (true) {
                        try {
                            date = scanner.nextLine();
                            dateForEvent = LocalDate.parse(date, dateFormatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.err.println("Date could not be parsed!");
                        }
                    }


                    newEvent = new Event(nameForEvent, dateForEvent);

                    eventManager.addEvent(nameForEvent, newEvent);
                    break;

                case 2:
                   eventManager.showAllEvents();
                    break;

                case 3:
                    doesLoopContinue = false;
                    break;
            }
        }
    }
}