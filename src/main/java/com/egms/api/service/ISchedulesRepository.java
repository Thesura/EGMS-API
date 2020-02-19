package com.egms.api.service;

import com.egms.api.model.Schedule;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ISchedulesRepository extends CrudRepository<Schedule, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Schedule WHERE end_date_time < CURRENT_TIMESTAMP")
    void deleteOutdated();

}
