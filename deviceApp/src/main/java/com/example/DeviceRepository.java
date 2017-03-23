package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by kvajramani on 15-03-2017.
 */
@Repository
public interface DeviceRepository extends CrudRepository<Device,String> {
    public Device findDeviceById(@Param("id") Long id);
    public Iterable<Device> findDeviceBySku(@Param("sku") String sku);
    public Device findDeviceByName(@Param("name") String name);
}
