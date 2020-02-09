package com.egms.api.service;

import com.egms.api.model.Outage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutagesRepository extends CrudRepository<Outage, Integer> {

}
