package com.atuldwivedi.cp.design.patterns.behavioral.observer.impl01;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Atul Dwivedi
 */
public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... eventTypes) {
        for (String eventType : eventTypes) {
            listeners.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener eventListener) {
        listeners.get(eventType).add(eventListener);
    }

    public void unsubscribe(String eventType, EventListener eventListener) {
        listeners.get(eventType).remove(eventListener);
    }

    public void notify(String eventType, File file) {
        for (EventListener listener : listeners.get(eventType)) {
            listener.update(eventType, file);
        }
    }
}
