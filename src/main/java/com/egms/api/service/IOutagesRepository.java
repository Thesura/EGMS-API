package com.egms.api.service;

import com.egms.api.model.Outage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IOutagesRepository extends CrudRepository<Outage, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Outage AS O WHERE O.status = ?1")
    void deleteFixedOutages(String status);
}
