package com.chronosync.model;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Event {
    private String name;
    private LocalDate date;

    public Event(String name, LocalDate date) {
        System.out.println("Creating Event, please wait...");

        try {
            this.name = name;
            this.date = date;
            System.out.println("Event has been created successfully!");
        } catch (InputMismatchException e) {
            System.err.println("This is not a valid event!");
        }
    }

    @Override
    public String toString() {
        return String.format("""
                         === %s ===
                         \t%s
                            \s
                        \s""",
                date,
                name
        );
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
