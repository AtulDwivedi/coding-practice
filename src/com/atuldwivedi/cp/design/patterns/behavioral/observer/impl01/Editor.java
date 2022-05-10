package com.atuldwivedi.cp.design.patterns.behavioral.observer.impl01;

import java.io.File;

/**
 * @author Atul Dwivedi
 */
public class Editor {
    public EventManager eventManager;
    private File file;

    public Editor() {
        this.eventManager = new EventManager("open", "update", "save");
    }

    public void open(String filePath) {
        file = new File(filePath);
        eventManager.notify("open", file);
    }

    public void update() throws Exception {
        if (this.file != null) {
            //code to update file
            eventManager.notify("update", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }

    public void save() throws Exception {
        if (this.file != null) {
            //code to save file
            eventManager.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
