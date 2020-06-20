package com.company;

import java.util.ArrayList;
import java.util.List;

public class CommandGenerator {

    private final List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void reset() {
          listeners.forEach(Listener::reset);
    }


}
