package com.egms.api.service;

import com.egms.api.model.Coordinate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoordinatesRepository extends CrudRepository<Coordinate, Integer> {

}
