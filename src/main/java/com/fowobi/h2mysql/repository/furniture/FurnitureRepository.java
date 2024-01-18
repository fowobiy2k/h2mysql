package com.fowobi.h2mysql.repository.furniture;

import com.fowobi.h2mysql.model.furniture.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
}
