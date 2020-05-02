package com.egms.api.service;

import com.egms.api.model.Outage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutagesRepository extends CrudRepository<Outage, Integer> {
    @Query("DELETE FROM Outage AS O WHERE O.status = ?1")
    void deleteFixedOutages(String status);
}
