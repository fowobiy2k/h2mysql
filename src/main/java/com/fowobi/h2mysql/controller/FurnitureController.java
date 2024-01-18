package com.fowobi.h2mysql.controller;

import com.fowobi.h2mysql.model.furniture.Furniture;
import com.fowobi.h2mysql.service.FurnitureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/add")
    public Furniture add(@RequestBody Furniture furniture) {
        return furnitureService.add(furniture);
    }

    @GetMapping("/getall")
    public List<Furniture> getAll() {
        return furnitureService.getAll();
    }

    @GetMapping("/get/{id}")
    public Furniture getById(@PathVariable( name = "id") int id) {
        return furnitureService.getById(id);
    }
}
