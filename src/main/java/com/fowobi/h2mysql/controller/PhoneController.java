package com.fowobi.h2mysql.controller;

import com.fowobi.h2mysql.model.Phone;
import com.fowobi.h2mysql.service.PhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/add")
    public Phone add(@RequestBody Phone phone) {
        return phoneService.addPhone(phone);
    }

    @GetMapping("/getall")
    public List<Phone> getAll() {
        return phoneService.getAll();
    }

    @GetMapping("/get/{id}")
    public Phone getById(@PathVariable(name = "id") int id) {
        return phoneService.getById(id);
    }
}
