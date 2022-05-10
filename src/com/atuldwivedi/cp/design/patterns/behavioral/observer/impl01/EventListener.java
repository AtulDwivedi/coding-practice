package com.atuldwivedi.cp.design.patterns.behavioral.observer.impl01;

import java.io.File;

/**
 * @author Atul Dwivedi
 */
public interface EventListener {
    void update(String eventType, File file);
}
