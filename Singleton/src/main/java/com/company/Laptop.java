package com.company;

import com.company.service.DeviceService;
import com.company.service.DeviceServiceMap;

public class Laptop extends Device {

    DeviceService deviceService = new DeviceServiceMap();


    public Laptop(String device) {
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


        return "Device{" +
                "id='" + getId() + '\'' +
                ", name='" + getDevice() + '\'' +
                ", enabled=" + flag +
                '}';


    }


}
