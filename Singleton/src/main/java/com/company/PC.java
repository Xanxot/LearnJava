package com.company;

public class PC extends Device {
    public PC(String device) {
        super(device);
    }


    @Override
    protected void use(String str) {
        if (buffer == null) {
            buffer = str;
        } else {
            buffer = buffer + str;
        }
    }

    @Override
    public String toString() {

        if (flag) {
            return "Device{" +
                    "id='" + getId() + '\'' +
                    ", name='" + getDevice() + '\'' +
                    ", enabled=" + flag +
                    '}';
        } else {
            return null;
        }
    }
}
