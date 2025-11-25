package com.chronosync.manager;

import com.chronosync.model.Event;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EventManager {
    private final ConcurrentMap<String, Event> events = new ConcurrentHashMap<>();

    public void addEvent(String name, Event event) {
        events.put(name, event);
    }

    public void showAllEvents() {
        for (Event event : events.values()) {
            System.out.println(event);
        }
    }

    public Map<String, Event> getEvents() {
        return events;
    }
}
