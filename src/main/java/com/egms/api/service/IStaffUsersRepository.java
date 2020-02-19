package com.egms.api.service;

import com.egms.api.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffUsersRepository extends CrudRepository<Staff, Integer> {

    Staff findByName(String name);
    Staff findById(int id);
    boolean existsByName(String name);
}
