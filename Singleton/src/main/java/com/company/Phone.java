package com.company;

public class Phone extends Device {

    public Phone(String device) {
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
