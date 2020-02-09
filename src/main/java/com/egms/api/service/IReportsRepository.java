package com.egms.api.service;

import com.egms.api.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportsRepository extends CrudRepository<Report, Integer> {

}
