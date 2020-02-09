package com.egms.api.service;

import com.egms.api.model.NonStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INonStaffUserRepository extends CrudRepository<NonStaff, Integer> {

    NonStaff findByName(String name);
    NonStaff findById(int id);
    boolean existsByName(String name);

}
