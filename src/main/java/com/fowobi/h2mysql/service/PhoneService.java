package com.fowobi.h2mysql.service;

import com.fowobi.h2mysql.model.Phone;
import com.fowobi.h2mysql.model.PhoneMapper;
//import com.fowobi.h2mysql.repository.PhoneRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private final JdbcTemplate jdbcTemplate;

    public PhoneService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//    private final PhoneRepository phoneRepository;
    private final String SQL_FIND_PHONE = "select * from tbl_phones where id = ?";
    private final String SQL_DELETE_PPHONE = "delete from tbl_phones where id = ?";
    private final String SQL_UPDATE_PHONE = "update tbl_phones set first_name = ?, last_name = ?, age  = ? where id = ?";
    private final String SQL_GET_ALL = "select * from tbl_phones";
    private final String SQL_INSERT_PHONE = "insert into tbl_phones(brand, model, weight) values(?,?,?)";


    public int addPhone(Phone phone) {
        return jdbcTemplate.update(SQL_INSERT_PHONE, phone.getBrand(), phone.getModel(), phone.getWeight());
    }

    public List<Phone> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new PhoneMapper());
    }

    public Phone getById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PHONE, new Object[] { id }, new PhoneMapper());
    }

//    public Phone addPhone(Phone phone) {
//        return phoneRepository.save(phone);
//    }
//
//    public List<Phone> getAll() {
//        return phoneRepository.findAll();
//    }
//
//    public Phone getById(int id) {
//        return phoneRepository.findById(id).get();
//    }
}
