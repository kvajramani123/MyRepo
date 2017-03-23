package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * Created by kvajramani on 15-03-2017.
 */
@RestController
@RequestMapping(value = "/devices", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceController {

    @Autowired
    public DeviceRepository deviceRepo;

    @RequestMapping
    private Iterable<Device> devices()
    {
        return deviceRepo.findAll();
    }

    @RequestMapping(value = "/device/{id}")
    public Device getDeviceById(@PathVariable("id") Long id)
    {
        return deviceRepo.findDeviceById(id);
    }

    @RequestMapping(value = "/device/{sku}")
    public Iterable<Device> getDeviceBySku(@PathVariable("sku") String sku)
    {
        return deviceRepo.findDeviceBySku(sku);
    }

    @RequestMapping(value = "/device/{name}")
    public Device getDeviceByName(@PathVariable("name") String name)
    {
        return deviceRepo.findDeviceByName(name);
    }

}
