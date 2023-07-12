package com.dds.phones.controller;

import com.dds.phones.service.PhoneGeoLookupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PhoneGeoLookupController {

    private final PhoneGeoLookupService service;

    @GetMapping("/lookup")
    public List<String> getCountriesByPhone(@RequestParam(name = "phone") String phone) {
        return service.getCountriesByPhone(phone);
    }
}
