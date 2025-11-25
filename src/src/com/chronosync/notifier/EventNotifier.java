package com.chronosync.notifier;

import com.chronosync.manager.EventManager;
import com.chronosync.model.Event;

import java.time.LocalDate;

public record EventNotifier(EventManager manager) implements Runnable {

    @Override
    public void run() {
        while (true) {
            for (Event event : manager.getEvents().values()) {

                if (event.getDate().equals(LocalDate.now()) || event.getDate().equals(LocalDate.now().plusDays(1L))) {
                    System.out.printf("""
                                    === ERINNERUNG ===
                                    Event %s findet bald statt!
                                    
                                    """,
                            event.getName()
                    );
                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted unexpectedly!");
            }
        }
    }
}
