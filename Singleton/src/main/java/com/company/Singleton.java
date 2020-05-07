package com.company;

public class Singleton {
    private static Singleton singleton;
    public boolean isOn;

    private Singleton() {
    }

    public static Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }
}
