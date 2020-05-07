package com.company.service;

import com.company.Device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DeviceServiceMap implements DeviceService {


    private Map<String, Device> deices = new HashMap<>();



    @Override
    public Device save(Device device) {
        return deices.put(device.getId(), device);

    }

    @Override
    public List<Device> getAll() {

        return new ArrayList<>(deices.values());
    }

    @Override
    public Device getDevice(String id) {
        Device device = deices.get(id);
        if (device != null) {
            return device;
        } else {
            return null;
        }
    }
}
