package com.fowobi.h2mysql.service;

import com.fowobi.h2mysql.model.Furniture;
import com.fowobi.h2mysql.repository.furniture.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public Furniture add(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    public List<Furniture> getAll() {
        return furnitureRepository.findAll();
    }

    public Furniture getById(int id) {
        Optional<Furniture> output = furnitureRepository.findById(id);
        return output.isPresent() ? output.get() : null;
    }
}
