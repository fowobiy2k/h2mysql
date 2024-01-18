package com.fowobi.h2mysql.repository.phone;

import com.fowobi.h2mysql.model.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
