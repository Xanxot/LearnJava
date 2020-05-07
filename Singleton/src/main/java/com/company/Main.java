package com.company;

import com.company.service.DeviceService;
import com.company.service.DeviceServiceMap;

public class Main {

    public static void main(String[] args) {
        DeviceService deviceService = new DeviceServiceMap();
        Laptop laptop = new Laptop("Test");
        Phone phone = new Phone("Test2");
        laptop.turnON("Asus");
        deviceService.save(laptop);
        laptop.turnOff();
        phone.turnON("iphone");
        deviceService.save(phone);
        System.out.println(deviceService.getAll());
        System.out.println(deviceService.getDevice(phone.getId()));


    }
}
