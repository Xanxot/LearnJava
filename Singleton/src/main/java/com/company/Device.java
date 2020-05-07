package com.company;

import java.util.UUID;

public abstract class Device {
    protected boolean flag;
    protected String buffer;
    private String device;
    private String id;


    public Device(String device) {
        this.device = device;
        this.id = UUID.randomUUID().toString();

    }

    public void turnON(String device) {

        Singleton state = Singleton.instance();
        if (!flag && state.getIsOn() == flag) {
            this.device = device;
            state.setIsOn(true);
            flag = state.getIsOn();
            buffer = device + " is enabled- " + state.getIsOn();
            System.out.println("Устройство: " + device + " активировано");

        } else {
            System.out.println("Одновременно может работать только 1 устройство");
        }
    }

    public void turnOff() {
        Singleton state = Singleton.instance();
        if (flag && state.getIsOn() == flag) {
            state.setIsOn(false);
            flag = state.getIsOn();
            buffer = this.device + " is enabled- " + state.getIsOn();
            System.out.println("Устройство" + " выключено");
        } else {
            System.out.println("Устройство уже выключено");
        }
    }

    public String getBuffer() {
        Singleton state = Singleton.instance();
        if (buffer == null && state.getIsOn()) {
            System.out.println("Включено другое устройство");
        } else if (!state.getIsOn()) {
            System.out.println("Невозможно использовать выключенное устройство");
        } else {
            return buffer;
        }
        return null;
    }

    public String getDevice() {

        return device;
    }

    public String getId() {
        return id;
    }


    public abstract String toString();

    protected abstract void use(String str);


}
