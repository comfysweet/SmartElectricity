package com.devices.controller;

import com.devices.domain.Device;
import com.devices.domain.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/devices")
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public @ResponseBody
    ArrayList<Device> getDevices(){
        return deviceService.getDevices();
    }

}
