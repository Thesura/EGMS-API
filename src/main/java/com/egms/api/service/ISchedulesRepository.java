package com.egms.api.service;

import com.egms.api.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchedulesRepository extends CrudRepository<Schedule, Integer> {

}
