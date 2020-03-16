package com.egms.api.service;

import com.egms.api.model.Coordinate;
import com.egms.api.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportsRepository extends JpaRepository<Report, Integer> {

    @Query("SELECT c1 FROM Coordinate c1\n" +
           "WHERE (?1>c1.lng1 AND ?2<c1.lat1)" +
            " AND (?1<c2.lng3 AND ?2>c2.lat3)")
    Coordinate getAreaId(double longitude1, double latitude1);

}
