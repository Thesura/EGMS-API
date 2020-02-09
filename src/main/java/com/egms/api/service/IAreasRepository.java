package com.egms.api.service;

import com.egms.api.model.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAreasRepository extends CrudRepository<Area, Integer> {

    Area findByName(String name);
    boolean existsByName(String name);
}
