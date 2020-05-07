package com.company.service;

import com.company.Device;

import java.util.List;

public interface DeviceService {
    Device save(Device device);

    List<Device> getAll();

    Device getDevice(String DeviceId);
}
